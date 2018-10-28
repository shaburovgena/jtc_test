import java.util.ArrayList;

/**
 * Класс обеспечиввающий перевод денег
 */

public class Transaction {
    private ArrayList<Client> clientsList;
    private Client srcClient, dstClient;

    //Основной конструктор
    public Transaction(ClientList clientsList) {
        this.clientsList = clientsList.get();
    }

    //Выполняем проверку на вводные данные, разделил чтобы конкретизировать подсказку клиенту
    //Источник и получатель должны быть в базе
    private Client ifSrcExist(String srcNumber) {
        Client srcClient = null;
        for (Client client : clientsList) {
            //Проверяем реквизиты счета списания
            if (srcNumber.equals(client.getBankAccount()) || srcNumber.equals(client.getCardNumber())
                    || srcNumber.equals(client.getPhoneNumber())) {//Проверяем все поля (кроме имени) на совпадения
                srcClient = client;//Если найдено, возвращаем объект Client
                break;
            }
        }
        return srcClient;
    }

    private Client ifDstExist(String dstNumber) {
        Client dstClient = null;
        for (Client client : clientsList) {
            //Проверяем реквизиты счета зачисления
            if (dstNumber.equals(client.getBankAccount()) || dstNumber.equals(client.getCardNumber())
                    || dstNumber.equals(client.getPhoneNumber())) {//Проверяем все поля (кроме имени) на совпадения
                dstClient = client;//Если найдено, возвращаем объект Client
                break;
            }
        }
        return dstClient;
    }


    //Сумма перевода должна быть положительным числом и больше баланса источника
    private boolean checker(long summ) {
        if (summ <= srcClient.getBalance() && summ > 0) {
            return true;//Операция разрешена
        } else {
            return false;//На счете недостаточно средств или не указана сумма
        }
    }

    //Выполняем перевод, списываем с одного счета, зачисляем на другой
    public synchronized boolean transfer(String srcNumber, String dstNumber, long summ) {
        this.srcClient = ifSrcExist(srcNumber);
        this.dstClient = ifDstExist(dstNumber);
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
