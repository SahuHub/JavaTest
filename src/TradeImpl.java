import java.util.Date;

public class TradeImpl {

    private String tradeID;
    private int version;
    private String counterPartyID;
    private String bookID;
    private Date maturityDate;
    private Date createdDate;
    private Character expired;

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCounterPartyID() {
        return counterPartyID;
    }

    public void setCounterPartyID(String counterPartyID) {
        this.counterPartyID = counterPartyID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Character getExpired() {
        return expired;
    }

    public void setExpired(Character expired) {
        this.expired = expired;
    }
}
