/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    private UserData srcUser, dstUser;
    private double srcBalance, dstBalance;
    private double summ, balance;

    //Создаем объект транзакции
//TODO:Это тестовая транзакция, удалить, так как получать мы будем или номер счета, карты, телефона
    public Transaction(UserData srcUser, UserData dstUser, double summ) {
        this.srcUser = srcUser;
        this.dstUser = dstUser;
        this.summ = summ;
    }

    //Выполняем проверку на вводные данные
    //Источник и получатель должны быть в базе
    public synchronized boolean ifExist() {
        return true;
    }

    //Сумма перевода должна быть положительным числом и больше баланса источника
    public synchronized boolean checker() {
        return true;
    }

    //Выполняем математические операции с балансом
    public synchronized double transfer() {
        srcBalance = srcUser.getBalance();
        dstBalance = dstUser.getBalance();
        if (checker()) {
            srcUser.setBalance(srcBalance -= summ);
            dstUser.setBalance(dstBalance += summ);
        }
        return summ;
    }

}
