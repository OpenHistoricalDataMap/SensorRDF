package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Location;
import models.Measurement;
import models.SenseBox;
import models.Sensor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static SenseBox readJSONToSongs(String json) throws FileNotFoundException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SenseBox sb = null;
        try  {
            sb = (SenseBox)  objectMapper.readValue(json, SenseBox.class);
        } catch (Exception e){
        e.printStackTrace();
        }

        return sb;
    }

    public static SenseBox readJSONResponseToPOJO(String jsonResponse){

        JSONObject obj = new JSONObject(jsonResponse);

        SenseBox sb = readGeneralInfoFromJSON(obj);

        return sb;
    }


    public static Location readLocationFromJSON(JSONObject obj){

        JSONObject currLoc = obj.getJSONObject("currentLocation");
        String ts = currLoc.getString("timestamp");
        String type = currLoc.getString("type");
        JSONArray coor = currLoc.getJSONArray("coordinates");
        Double[] coorArr = {(Double) coor.get(0), (Double) coor.get(1)};
        Location l = new Location(ts, coorArr, type);

        return l;

    }


    public static Measurement readMeasurementsFromJSON(JSONObject measurementFromJSON){
        String measuredAt = measurementFromJSON.getString("createdAt");
        Double measuredValue = measurementFromJSON.getDouble("value");
        Measurement m = new Measurement(measuredValue, measuredAt);
        return m;

    }

    public static List<Sensor> readSensorsFromJSON(JSONObject obj){
        JSONArray sa = obj.getJSONArray("sensors");
        List<Sensor> sensorList = new ArrayList<Sensor>();
        for (int i = 0; i < sa.length(); i++) {
            JSONObject sensor = sa.getJSONObject(i);

            String title = sensor.getString("title");
            String unit = sensor.getString("unit");
            String id = sensor.getString("_id");
            String sensorType = sensor.getString("sensorType");
            JSONObject meas = sensor.getJSONObject("lastMeasurement");

            Measurement measurement = readMeasurementsFromJSON(meas);
            Sensor s = new Sensor(title, sensorType, id, measurement, unit);
            sensorList.add(s);
        }

        return sensorList;
    }

    public static SenseBox readGeneralInfoFromJSON(JSONObject obj){
        SenseBox sb = new SenseBox();

        sb.setId(obj.getString("_id"));
        if (obj.has("name")){
            sb.setName(obj.getString("name"));
            sb.setCreatedAt(obj.getString("createdAt"));
            sb.setExposure(obj.getString("exposure"));
            sb.setUpdatedAt(obj.getString("updatedAt"));
        }

        if (obj.has("currentLocation")){
            sb.setCurrentLocation(readLocationFromJSON(obj));
        }

        if (obj.has("sensors")){
            sb.setBuiltInSensors(readSensorsFromJSON(obj));

        }
        return sb;
    }



}
