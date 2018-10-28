import java.util.ArrayList;

/**
 * Класс для работы со списком клиентов
 * Добавление, удаление, поиск
 */
class ClientList {
    private ArrayList<Client> clients;

    ClientList() {
        clients = new ArrayList<Client>();
    }

    //Получение списка клиентов в виде массива
    synchronized ArrayList<Client> get() {
        return clients;
    }

    //Добавление клиентов в список
    synchronized int add(Client client) {
        clients.add(client);
        return clients.indexOf(client);
    }

    //Удаление клиента по совпадению в одном из полей
    synchronized boolean remove(String value) {
        boolean ifExist = false;
        for (Client client : clients) {
            if (value.equals(client.getBankAccount()) || value.equals(client.getCardNumber())
                    || value.equals(client.getPhoneNumber())) {
                clients.remove(clients.indexOf(client));//Если есть совпадение удаляем запись
                ifExist = true;
                break;
            }
        }
        return ifExist;
    }

    synchronized Client find(String requisite) {
        Client clientFind = null;
        for (Client client : clients) {
            if (requisite.equals(client.getBankAccount()) || requisite.equals(client.getCardNumber())
                    || requisite.equals(client.getPhoneNumber())) {//Проверяем все поля (кроме имени) на совпадения
                clientFind = client;//Если найдено, возвращаем объект Client
                break;
            }
        }
        return clientFind;
    }

    //Показатьт весь список клиентов с реквизитами и балансом
    synchronized String viewAll() {
        String allClients = "";
        for (Client client : clients) {
            allClients += clients.indexOf(client) + "\t " + client.getName() + "\n bank account:"
                    + client.getBankAccount() + "\t  balance:" + client.getBalance() + "\n card number:" + client.getCardNumber() + "\n phone number:"
                    + client.getPhoneNumber() + ";\n\n";
        }
        return allClients;
    }
}
