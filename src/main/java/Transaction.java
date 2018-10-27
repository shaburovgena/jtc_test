import java.util.ArrayList;

/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    ArrayList<Client> clientsList;
    private Client srcClient, dstClient;

    //Основной конструктор, так как перевод будет осущетсвляться по номеру счета, карты или телефона
    public Transaction(ClientList clientsList) {
        this.clientsList = clientsList.get();
    }

    //Выполняем проверку на вводные данные, разделил чтобы конкретизировать подсказку клиенту
    //Источник и получатель должны быть в базе
    public Client ifSrcExist(String srcNumber) {
        Client srcClient = null;
        for (Client client : clientsList) {
            //Проверяем реквизиты счета списания
            if (srcNumber.equals(client.getBankAccount()) || srcNumber.equals(client.getCardNumber())
                    || srcNumber.equals(client.getPhoneNumber())) {
                srcClient = client;
                break;
            }
        }
        return srcClient;
    }

    public Client ifDstExist(String dstNumber) {
        Client dstClient = null;
        for (Client client : clientsList) {
            //Проверяем реквизиты счета зачисления
            if (dstNumber.equals(client.getBankAccount()) || dstNumber.equals(client.getCardNumber())
                    || dstNumber.equals(client.getPhoneNumber())) {
                dstClient = client;
                break;
            }
        }
        return dstClient;
    }


    //Сумма перевода должна быть положительным числом и больше баланса источника
    public boolean checker(long summ) {
        if (summ <= srcClient.getBalance() && summ > 0) {
            return true;//Операция разрешена
        } else {
            System.out.println("Неверно указана сумма или недостаточно средств");
            return false;//На счете недостаточно средств или не указана сумма
        }
    }

    //Выполняем перевод, списываем с одного счета, зачисляем на другой
    public synchronized String transfer(String srcNumber, String dstNumber, long summ) {
        this.srcClient = ifSrcExist(srcNumber);
        this.dstClient = ifDstExist(dstNumber);
        checker(summ);
        if (checker(summ) && dstClient != null && srcClient != null) {
            srcClient.setBalance(srcClient.getBalance() - summ);
            dstClient.setBalance(dstClient.getBalance() + summ);
            System.out.println("Выполнено. Остаток на счете  " + srcClient.getBalance());
            return "Выполнено. Остаток на счете  " + srcClient.getBalance();
        } else {
            System.out.println("Операция не выполнена");
            return "Операция не выполнена";

        }

    }


}
