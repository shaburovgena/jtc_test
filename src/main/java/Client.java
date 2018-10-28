/*
Класс с данными о пользователях
 */

public class Client {
    public String bankAccount; //15 знаков формат ххххх-ххххх-ххххх
    public String cardNumber;  //16 знаков формат хххх хххх хххх хххх
    public String phoneNumber; //10 знаков формат хххххххххх
    public long balance;       //сумма на счету
    public String name;        //имя держателя счета

    public Client() {
    }

     Client(String name, String bankAccount, String cardNumber, String phoneNumber, long balance) {
        this.setName(name);
        this.setBankAccount(bankAccount);
        this.setCardNumber(cardNumber);
        this.setPhoneNumber(phoneNumber);
        this.setBalance(balance);
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
