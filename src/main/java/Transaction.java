import java.util.ArrayList;

/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    ArrayList<Client> clientsList;
    private Client srcClient, dstClient;
    private long summ;
    private String dstNumber, srcNumber;

    //Основной конструктор, так как перевод будет осущетсвляться по номеру счета, карты или телефона
    public Transaction(ClientList clientsList, String srcNumber, String dstNumber, long summ) {
        this.clientsList = clientsList.get();
        this.srcNumber = srcNumber;
        this.dstNumber = dstNumber;
        this.summ = summ;
    }

    //Выполняем проверку на вводные данные, разделил чтобы конкретизировать подсказку клиенту
    //Источник и получатель должны быть в базе
    public boolean ifSrcExist() {
        boolean ifSrcExist = false;
        for (Client client : clientsList) {
            //Проверяем реквизиты счета списания
            if (srcNumber.equals(client.getBankAccount()) || srcNumber.equals(client.getCardNumber())
                    || srcNumber.equals(client.getPhoneNumber())) {
                srcClient = client;//Если есть совпадение с базой вернуть true
                ifSrcExist = true;
                break;
            }
        }
        return ifSrcExist;
    }

    public boolean ifDstExist() {
        boolean ifDstExist = false;
        for (Client client : clientsList) {
            //Проверяем реквизиты счета зачисления
            if (dstNumber.equals(client.getBankAccount()) || dstNumber.equals(client.getCardNumber())
                    || dstNumber.equals(client.getPhoneNumber())) {
                dstClient = client; //Если есть совпадение с базой вернуть true
                ifDstExist = true;
                break;
            }
        }
        return ifDstExist;
    }


    //Сумма перевода должна быть положительным числом и больше баланса источника
    public boolean checker() {
        if (summ < srcClient.getBalance() && summ > 0) {
            return true;//Операция разрешена
        } else {
            return false;//На счете недостаточно средств или не указана сумма
        }
    }

    //Выполняем перевод, списываем с одного счета, зачисляем на другой
    public synchronized String transfer() {
        ifSrcExist();
        ifDstExist();
        checker();
        if (checker() && ifDstExist() && ifSrcExist()) {
            srcClient.setBalance(srcClient.getBalance() - summ);
            dstClient.setBalance(dstClient.getBalance() + summ);
            return "Выполнено. Остаток на счете  " + srcClient.getBalance();
        } else {
            return "Операция не выполнена";

        }

    }


}
