import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


import javax.net.ssl.HttpsURLConnection;

public class APIConnector {

    private List<String> availableAPIurls;
    private final String USER_AGENT = "Mozilla/5.0";
    private final String HTW_SENSEBOX_ID = "5ce2722730705e001adf023a";
    private final String BIKE_SENSOR_ID = "5cc58071facf70001a872bef";


    public APIConnector() {
        this.availableAPIurls = new ArrayList<String>();
    }

    void sendGet() throws Exception {

        String alldata_url = "https://api.opensensemap.org/boxes/"+BIKE_SENSOR_ID;
        String location_url = "https://api.opensensemap.org/boxes/"+HTW_SENSEBOX_ID+"/locations";
        String sensors_url = "https://api.opensensemap.org/boxes/"+HTW_SENSEBOX_ID+"/sensors";

        availableAPIurls.add(alldata_url);
        availableAPIurls.add(location_url);
        availableAPIurls.add(sensors_url);

        for (String u : availableAPIurls){
            URL url = new URL(u);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
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
            in.close();

            //print result
            System.out.println(response.toString());
        }



    }


}


