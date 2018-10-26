import java.util.ArrayList;

/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    ArrayList<UserData> usersList;
    private UserData srcUser, dstUser;
    private long summ;
    private String dstNumber, srcNumber, allUsers;


    public Transaction(ArrayList<UserData> usersList, UserData srcUser, String dstNumber, long summ) {
        this.usersList = usersList;
        this.srcUser = srcUser;
        this.dstNumber = dstNumber;
        this.summ = summ;
    }

    //Основной конструктор, так как перевод будет осущетсвляться по номеру счета, карты или телефона
    public Transaction(ArrayList<UserData> usersList, String srcNumber, String dstNumber, long summ) {
        this.usersList = usersList;
        this.srcNumber = srcNumber;
        this.dstNumber = dstNumber;
        this.summ = summ;
    }

    //Выполняем проверку на вводные данные, разделил чтобы конкретизировать подсказку клиенту
    //Источник и получатель должны быть в базе
    public synchronized boolean ifSrcExist() {
        boolean ifSrcExist = false;
        for (UserData user : usersList) {
            //Проверяем реквизиты счета списания
            if (srcNumber.equals(user.getBankAccount()) || srcNumber.equals(user.getCardNumber())
                    || srcNumber.equals(user.getPhoneNumber())) {
                srcUser = user;
                ifSrcExist = true;
                System.out.println("Пользователь счета списания  " + srcUser.getName());
                break;
            } else {
                System.out.println("Счет списания не найден, проверьте реквизиты");
            }
        }
        return ifSrcExist;
    }

    public synchronized boolean ifDstExist() {
        boolean ifDstExist = false;
        for (UserData user : usersList) {
            //Проверяем реквизиты счета зачисления
            if (dstNumber.equals(user.getBankAccount()) || dstNumber.equals(user.getCardNumber())
                    || dstNumber.equals(user.getPhoneNumber())) {
                dstUser = user;
                System.out.println("Пользователь счета зачисления  " + dstUser.getName());
                ifDstExist = true;
                break;
            } else {
                System.out.println("Счет зачиления не найден, проверьте реквизиты");
            }
        }
        return ifDstExist;
    }


    //Сумма перевода должна быть положительным числом и больше баланса источника
    public synchronized boolean checker() {
        if (summ < srcUser.getBalance() && summ > 0) {
            System.out.println("Операция разрешена");
            return true;
        } else {
            System.out.println("На счете недостаточно средств или не указана сумма");
            return false;
        }
    }

    //TODO: Выполняем математические операции с балансом, должен вернуть и баланс источника и получателя
    public synchronized void transfer() {
        ifSrcExist();
        ifDstExist();
        checker();
        if (checker() && ifDstExist() && ifSrcExist()) {
            srcUser.setBalance(srcUser.getBalance() - summ);
            dstUser.setBalance(dstUser.getBalance() + summ);
            System.out.println("Остаток на счете списания   " + srcUser.getBalance());
            System.out.println("Остаток на счете зачисления   " + dstUser.getBalance());
        }else {
            System.out.println("Операция не выполнена");
        }

    }

    public synchronized String viewAll() {

        for (UserData user : usersList) {
            allUsers += user.getId() + "\t" + user.getName() + "\t" + user.getBankAccount() + "\n" + user.getCardNumber() + "\t" + user.getPhoneNumber() + "\t" + user.getBalance() + "\n\n";
//
//                    System.out.println(user.getId());
//            System.out.println(user.getName());
//            System.out.println(user.getCardNumber());
//            System.out.println(user.getBankAccount());
//            System.out.println(user.getPhoneNumber());
//            System.out.println(user.getBalance());
        }
        return allUsers;
    }
}
