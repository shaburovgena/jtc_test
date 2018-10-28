import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TransactionTest {
    ClientList clientList;
    Transaction transaction;
    String src, dst;
    long summ;

    @Rule
    public TestRule timeout = new Timeout(10);

    public TransactionTest(String src, String dst, long summ) {
        this.src = src;
        this.dst = dst;
        this.summ = summ;
        this.clientList = new ClientList();
        clientList.add(new Client
                ("ivan", "11111-11111-11111",
                        "1111 1111 1111 1111", "1111111111", 2000));
        clientList.add(new Client
                ("petr", "22222-22222-22222",
                        "2222 2222 2222 2222", "2222222222", 1000));
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

    @Parameterized.Parameters
    public static Collection requisites() {
        return Arrays.asList(new Object[][]{
                {"11111-11111-11111",
                        "44444-44444-44444", 500},
                {"1111111111",
                        "masha", 500},
                {"1111 1111 1111 1111",
                        "5555555555", 500},
                {"11111-11111-11111",
                        "22222-22222-22222", 500},
                {"1111111111",
                        "3333 3333 3333 3333", 500},
                {"1111111111",
                        "3333 3333 3333 3333", 500}});


    }

    @Test
    public void actualsTest() {
        boolean actuals = transaction.transfer(src, dst, summ);
        Assert.assertEquals(true, actuals);
    }

    @Before
    public void setUp() throws Exception {

    }

    @Ignore
    @After
    public void tearDown() {
        System.out.println(clientList.viewAll());
    }
}