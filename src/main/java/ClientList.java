import java.util.ArrayList;

public class ClientList {
    ArrayList<Client> clients;
    int index;
    String allClients;

    ClientList() {
        clients = new ArrayList<Client>();
    }
//Получение списка клиентов в виде массива
    public synchronized ArrayList<Client> get() {
        return clients;
    }
//Добавление клиентов в список
    public synchronized int add(Client client) {
        clients.add(client);
        System.out.println(client.getId());
        return client.getId();
    }
//Удаление клиента по совпадению в обном из полей
    public synchronized boolean remove(String value) {
        boolean ifExist = false;
        for (Client client : clients) {
            if (value.equals(client.getBankAccount()) || value.equals(client.getCardNumber())
                    || value.equals(client.getPhoneNumber())) {
                clients.remove(client.getId());//Если есть совпадение удаляем запись
                ifExist = true;
                break;
            }
        }
        return ifExist;
    }
//Показатьт весь список клиентов с реквизитами и балансом
    public synchronized String viewAll() {

        for (Client client : clients) {
            allClients += client.getId() + "\t" + client.getName() + "\t"
                    + client.getBankAccount() + "\n" + client.getCardNumber() + "\t"
                    + client.getPhoneNumber() + "\t" + client.getBalance() + "\n\n";
        }
        return allClients;
    }
}