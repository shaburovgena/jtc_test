import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {
        StartServer server = new StartServer();
        server.start();

        //TODO: Создаем потокобезопасный контейнер для хранения пользовательских данных

        ArrayList <UserData> listUsers = new ArrayList();
        listUsers.add(new UserData
                (1, "ivan", 222222222, 222222222, 123456789, 99999));
        listUsers.add(new UserData
                (2, "petr", 333333333, 333333333, 987654321, 100));
        Transaction firstTransaction = new Transaction(listUsers.get(0),  listUsers.get(1), 1000);
        firstTransaction.transfer();
//        UserData tmp = (UserData) listUsers.get(0);
//        System.out.println("" + tmp.getName());

    }
}
