public class UserData {
    private long ID;
    private long BANK_ACCOUNT;
    private long CARD_NUMBER;
    private long PHONE_NUMBER;
    private String NAME;
    public UserData (){}

    public UserData (long id, String name){}

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getBANK_ACCOUNT() {
        return BANK_ACCOUNT;
    }

    public void setBANK_ACCOUNT(long BANK_ACCOUNT) {
        this.BANK_ACCOUNT = BANK_ACCOUNT;
    }

    public long getCARD_NUMBER() {
        return CARD_NUMBER;
    }

    public void setCARD_NUMBER(long CARD_NUMBER) {
        this.CARD_NUMBER = CARD_NUMBER;
    }

    public long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
