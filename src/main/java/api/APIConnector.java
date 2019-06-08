package api;

import models.Location;
import models.Measurement;
import models.SenseBox;
import models.Sensor;
import org.json.JSONArray;
import org.json.JSONObject;
import util.Helpers;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import static api.APIConstants.*;


public class APIConnector {


    public void sendGetToAll(List<String> availableAPIurls) throws Exception {

       // for (String u : availableAPIurls) {
            URL url = new URL("https://api.opensensemap.org/boxes/5ce2722730705e001adf023a/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            //System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
           // System.out.println(response);

            SenseBox sb = Helpers.readJSONResponseToPOJO(response.toString());

            System.out.println(sb);
            in.close();


       // }


    }


    /**
     *
     * {
     *     "_id": "5ce2722730705e001adf023a",
     *     "sensors": [
     *         {
     *             "title": "Temperatur",
     *             "unit": "°C",
     *             "sensorType": "HDC1080",
     *             "icon": "osem-thermometer",
     *             "_id": "5ce2722730705e001adf023f",
     *             "lastMeasurement": {
     *                 "value": "25.24",
     *                 "createdAt": "2019-06-06T14:32:17.623Z"
     *             }
     *         },
     *         {
     *             "title": "rel. Luftfeuchte",
     *             "unit": "%",
     *             "sensorType": "HDC1080",
     *             "icon": "osem-humidity",
     *             "_id": "5ce2722730705e001adf023e",
     *             "lastMeasurement": {
     *                 "value": "59.89",
     *                 "createdAt": "2019-06-06T14:32:17.623Z"
     *             }
     *         },
     *         {
     *             "title": "Luftdruck",
     *             "unit": "hPa",
     *             "sensorType": "BMP280",
     *             "icon": "osem-barometer",
     *             "_id": "5ce2722730705e001adf023d",
     *             "lastMeasurement": {
     *                 "value": "1002.88",
     *                 "createdAt": "2019-06-06T14:32:17.623Z"
     *             }
     *         },
     *         {
     *             "title": "Beleuchtungsstärke",
     *             "unit": "lx",
     *             "sensorType": "TSL45315",
     *             "icon": "osem-brightness",
     *             "_id": "5ce2722730705e001adf023c",
     *             "lastMeasurement": {
     *                 "value": "8.00",
     *                 "createdAt": "2019-06-06T14:32:17.623Z"
     *             }
     *         },
     *         {
     *             "title": "UV-Intensität",
     *             "unit": "μW/cm²",
     *             "sensorType": "VEML6070",
     *             "icon": "osem-brightness",
     *             "_id": "5ce2722730705e001adf023b",
     *             "lastMeasurement": {
     *                 "value": "0.00",
     *                 "createdAt": "2019-06-06T14:32:17.623Z"
     *             }
     *         }
     *     ]
     * }
     * **/

    public void sendGet(String toBeQueried) throws Exception {


        URL url = new URL(toBeQueried);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        System.out.println(response);

        SenseBox sb = Helpers.readJSONResponseToPOJO(response.toString());

        in.close();





    }



}


