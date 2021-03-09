import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        HashMap<String, TradeImpl> tradeHashList = new HashMap<>();

        // run till user enter "exit"
        while (true) {

            boolean flag = true;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            /*Write input trade with spaces between all field and hit enter
            Example: T1 1 CP-1 B1 20/05/2020
            */
            System.out.println("Please enter your trade details(Otherwise type \"exit\" to exit):");
            String tradesString = bufferedReader.readLine().trim();

            if (null != tradesString && tradesString.trim().equalsIgnoreCase("exit")) {

                System.out.println("################ Exiting process ################");
                break;
            }

            String[] tradesValue = tradesString.split(" ");

            // If wrong trades entered
            if (tradesValue.length != 5) {
                System.out.println("#### Wrong trade entered. Please try again ####");
                continue;
            }

            //creating trade object
            TradeImpl tradeObject = Util.createTradeObject(tradesValue);

            if (tradeObject.getMaturityDate().before(new Date())) {
                System.out.println("#### Entered Maturity date is not a future or current date ####");
                continue;
            }

            //set Created Date of a Trade
            tradeObject.setCreatedDate(new Date());

            //check if less version present
            for(Map.Entry<String,TradeImpl> e:tradeHashList.entrySet()){

                if (e.getKey().contains(tradeObject.getTradeID())) {
                    int version = Integer.parseInt(e.getKey().substring(e.getKey().indexOf("_") + 1, e.getKey().length()));
                    if (version >= tradeObject.getVersion()) {

                        flag = false;
                        try {
                            throw new MyException("### New Version is already present for this Trade ###");
                        } catch (MyException exp) {
                            System.out.println(exp.getMessage());
                        }
                    }
                }
            }

            if(flag){
                tradeHashList.put(tradeObject.getTradeID() + "_" + tradeObject.getVersion(), tradeObject);
                System.out.println("trade entered succesfully");
            }
        }
    }
}

