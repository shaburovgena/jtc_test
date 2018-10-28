import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TransactionTest {
    private ClientList clientList;
    private Transaction transaction;
    private String src, dst;
    private long summ;


    public TransactionTest(String src, String dst, long summ) {
        this.src = src;
        this.dst = dst;
        this.summ = summ;


    }

    @Parameterized.Parameters
    public static Collection requisites() {
        return Arrays.asList(new Object[][]{
                {"11111-11111-11111",
                        "44444-44444-44444", 500},
                {"1111111111",
                        "masha", 500},//Перевод по имени не предусмотрен
                {"1111 1111 1111 1111",
                        "5555555555", -500},//Сумма не должна быть отрицательной
                {"1111111111",
                        "2222 2222 2222 2222", 500},
                {"1111111111",
                        "3333-3333-3333-3333", 500},//Номер карты должен быть в формате хххх хххх хххх хххх
                {"1111111111",
                        "3333 3333 3333 3333", 5000}});//Сумма перевода больше суммы на счету


    }

    @Test(timeout = 10)
    public void transferTest() {
        boolean actuals = transaction.transfer(src, dst, summ);
        Assert.assertTrue(actuals);
    }

    @Before
    public void setUp() {
        this.clientList = new ClientList();//Создаем базу клиентов для теста
        clientList.add(new Client
                ("ivan", "11111-11111-11111",
                        "1111 1111 1111 1111", "1111111111", 2000));
        clientList.add(new Client
                ("petr", "22222-22222-22222",
                        "2222 2222 2222 2222", "2222222222", 10000));
        clientList.add(new Client
                ("gosha", "33333-33333-33333",
                        "3333 3333 3333 3333", "3333333333", 20000));
        clientList.add(new Client
                ("kolya", "44444-44444-44444",
                        "4444 4444 4444 4444", "4444444444", 40));
        clientList.add(new Client
                ("misha", "55555-55555-55555",
                        "5555 5555 5555 5555", "5555555555", 5000));
        clientList.add(new Client
                ("masha", "66666-66666-66666",
                        "5555 5555 5555 5555", "6666666666", 200));
        this.transaction = new Transaction(clientList);
    }

    @After
    public void tearDown() {
        System.out.println(clientList.viewAll());
    }
}