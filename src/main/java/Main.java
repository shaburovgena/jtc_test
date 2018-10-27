
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ClientList clientList = new ClientList();
        clientList.add(new Client
                ("ivan", "11111-11111-11111", "1111 1111 1111 1111", "1111111111", 99999));
        clientList.add(new Client
                ("petr", "22222-22222-22222", "2222 2222 2222 2222", "2222222222", 100));
        clientList.add(new Client
                ("gosha", "33333-33333-33333", "3333 3333 3333 3333", "3333333333", 20000));
        clientList.add(new Client
                ("kolya", "44444-44444-44444", "4444 4444 4444 4444", "4444444444", 40));
        clientList.add(new Client
                ("misha", "55555-55555-55555", "5555 5555 5555 5555", "5555555555", 5000));
        clientList.add(new Client
                ("masha", "66666-66666-66666", "5555 5555 5555 5555", "6666666666", 200));


        StartServer server = new StartServer(clientList);
        server.start();

    }
}
