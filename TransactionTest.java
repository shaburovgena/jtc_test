import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TransactionTest {
ClientList clientList;
@Before
public void add(){



}
    @Test
    public void transactionTest() {
        Transaction transaction = new Transaction(clientList);
        transaction.transfer( "11111-11111-11111",
                "44444-44444-44444", 500);
        transaction.transfer( "11111-11111-11111",
                "5555555555", 500);
        transaction.transfer( "11111-11111-11111",
                "masha", 500);
        transaction.transfer( "11111-11111-11111",
                "44444-44444-44444", 500);
        transaction.transfer( "11111-11111-11111",
                "44444-44444-44444", 500);
        transaction.transfer( "11111-11111-11111",
                "44444-44444-44444", 500);
    }

    @After
    public void viewAllTest (){

    }

}
