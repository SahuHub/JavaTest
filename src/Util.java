import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {

    public static TradeImpl createTradeObject(String[] str) throws ParseException {

        TradeImpl trade = new TradeImpl();

        trade.setTradeID(str[0]);
        trade.setVersion(new Integer(str[1]));
        trade.setCounterPartyID(str[2]);
        trade.setBookID(str[3]);
        trade.setMaturityDate(new SimpleDateFormat("dd/MM/yyyy").parse(str[4]));

        return trade;
    }
}
