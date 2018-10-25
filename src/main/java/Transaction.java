import java.util.ArrayList;

/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    ArrayList<UserData> usersList;
    private UserData srcUser, dstUser;
    private long srcBalance, dstBalance;
    private long summ, balance;
    private String dstNumber;
    private int id;

    //Создаем объект транзакции
//TODO:Это тестовая транзакция, удалить, так как получать мы будем номер счета, карты или телефона
    public Transaction(UserData srcUser, UserData dstUser, long summ) {
        this.srcUser = srcUser;
        this.dstUser = dstUser;
        this.summ = summ;
    }

    //Основной конструктор, так как перевод будет осущетсвляться по номеру счета, карты или телефона
    public Transaction(ArrayList<UserData> usersList, UserData srcUser, String dstNumber, long summ) {
        this.usersList = usersList;
        this.srcUser = srcUser;
        this.dstNumber = dstNumber;
        this.summ = summ;
    }

    //Выполняем проверку на вводные данные
    //Источник и получатель должны быть в базе
    public synchronized int ifExist() {
        int id = -1;
        for (UserData user : usersList) {
            if (dstNumber.equals(user.getBankAccount()) || dstNumber.equals(user.getCardNumber())
                    || dstNumber.equals(user.getPhoneNumber())) {
                id = user.getId();
            }
        }
        System.out.println("ID совпавшей записи  " + id);
        return id;
    }


    //Сумма перевода должна быть положительным числом и больше баланса источника
    public synchronized boolean checker() {
        if (summ > srcUser.getBalance() && summ > 0 && ifExist() >= 0) {
            return true;
        } else {
            return false;
        }
    }

    //TODO: Выполняем математические операции с балансом, должен вернуть и баланс источника и получателя
    public synchronized UserData transfer() {
        srcBalance = srcUser.getBalance();
        dstBalance = usersList.get(id).getBalance();
        if (checker()) {
            srcBalance = srcBalance - summ;
            dstBalance = dstBalance + summ;
            srcUser.setBalance(srcBalance);
            usersList.get(id).setBalance(dstBalance);
        }
        System.out.println("Остаток на счете пользователя источника   " + srcUser.getBalance());
        System.out.println("Остаток на счете пользователя получателя   " + usersList.get(id).getBalance());

        return srcUser;
    }

}
