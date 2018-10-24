import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {
        StartServer server = new StartServer();
        server.start();
        System.out.printf("111111111111111");

        //Создаем потокобезопасный контейнер для хранения пользовательских данных

        ConcurrentMap  <id, User> USERS = new Map ();
    }
}
