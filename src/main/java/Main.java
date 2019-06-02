public class Main {
    public static void main(String[] args) {

        APIConnector ac = new APIConnector();


        try {
        ac.sendGet();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
