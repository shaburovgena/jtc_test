/*
Класс с данными о пользователях
 */

public class UserData {
    private long id;
    private double bankAccount;
    private double cardNumber;
    private double phoneNumber;
    private double balance;
    private String name;
    public UserData (){}

    public UserData (long id, String name, double bankAccount, double cardNumber, double phoneNumber, double balance){
        this.name = name;
        this.bankAccount = bankAccount;
        this.cardNumber = cardNumber;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(double cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
