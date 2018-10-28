/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    private ClientList clientsList;
    private Client srcClient;

    //Основной конструктор
    public Transaction(ClientList clientsList) {
        this.clientsList = clientsList;
    }

    //Выполняем проверку на вводные данные, разделил чтобы конкретизировать подсказку клиенту
    //Источник и получатель должны быть в базе
    private Client ifSrcExist(String srcNumber) {
        //Проверяем реквизиты счета списания
        return clientsList.find(srcNumber);

    }

    private Client ifDstExist(String dstNumber) {
        //Проверяем реквизиты счета зачисления
        return clientsList.find(dstNumber);
    }


    //Сумма перевода должна быть положительным числом и больше баланса источника
    private boolean checker(long summ) {
        return summ <= srcClient.getBalance() && summ > 0;
    }

    //Выполняем перевод, списываем с одного счета, зачисляем на другой
    protected synchronized boolean transfer(String srcNumber, String dstNumber, long summ) {
        srcClient = ifSrcExist(srcNumber);
        Client dstClient = ifDstExist(dstNumber);
        checker(summ);
        if (checker(summ) && dstClient != null && srcClient != null) {
            srcClient.setBalance(srcClient.getBalance() - summ);//Вычитаем из источника
            dstClient.setBalance(dstClient.getBalance() + summ);//Зачисляем получателю
            return true;
        } else {
            return false;
        }

    }


}
