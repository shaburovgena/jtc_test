
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StartServer server = new StartServer();
        server.start();


        ArrayList <UserData> usersList = new ArrayList();
        usersList.add(new UserData
                (0, "ivan", "11111 22222 33333", "1111 2222 3333 4444", "1234567890", 99999));
        usersList.add(new UserData
                (1, "petr", "99999 88888 77777", "9999 8888 7777 6666", "0987654321", 100));

        Transaction first = new Transaction(usersList, usersList.get(0), "0987654321", 1000);
//        first.ifExist();
//        first.checker();
//        first.transfer();

    }
}
