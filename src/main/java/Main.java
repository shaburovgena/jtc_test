
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        StartServer server = new StartServer();
//        server.start();


        ArrayList<UserData> usersList = new ArrayList();
        usersList.add(new UserData
                (0, "ivan", "11111-11111-11111", "1111 1111 1111 1111", "1111111111", 99999));
        usersList.add(new UserData
                (1, "petr", "22222-22222-22222", "2222 2222 2222 2222", "2222222222", 100));
        usersList.add(new UserData
                (2, "gosha", "33333-33333-33333", "3333 3333 3333 3333", "3333333333", 20000));
        usersList.add(new UserData
                (3, "kolya", "44444-44444-44444", "4444 4444 4444 4444", "4444444444", 40));
        usersList.add(new UserData
                (4, "misha", "55555-55555-55555", "5555 5555 5555 5555", "5555555555", 5000));
        usersList.add(new UserData
                (5, "masha", "66666-66666-66666", "5555 5555 5555 5555", "6666666666", 200));
        System.out.println(usersList.get(2).getName());
        Transaction first = new Transaction(usersList, usersList.get(2), "4444 4444 4444 4444", 1000);
        first.transfer();
        usersList.remove(3);
        first.viewAll();
        Transaction second = new Transaction(usersList, usersList.get(2), "4444 4444 4444 4444", 1000);
        second.transfer();
        second.viewAll();
    }
}
