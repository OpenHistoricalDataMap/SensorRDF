import api.APIConnector;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        APIConnector ac = new APIConnector();
        List<String> availableAPIurls = initAvailableUrls();

        try {
        ac.sendGetToAll(availableAPIurls);


        } catch (Exception e){
            e.printStackTrace();
        }


    }

    private static List<String> initAvailableUrls(){

        int i = 1;

        ArrayList<String> availableUrls = new ArrayList<String>();




       return availableUrls;
    }

}
