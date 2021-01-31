import FinancyAcount.Account;
import FinancyAcount.Amount;
import utils.Status;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utils.Date;

@RunWith(MockitoJUnitRunner.class)
public class TestTransactionAcount {

    @InjectMocks
    Account account;
    @Mock
    Amount amount;
    @Mock
    Date date;


    @Test
    public void check_operation() throws Exception {
        Assert.assertEquals(account.getBalance().getValue(), Amount.getValueOf(0).getValue());
        Amount balanceAfterTransaction = Amount.getValueOf(5000);
        account.setBalance(balanceAfterTransaction);
        account.deposit(1000, "31/02/2021");
        account.withdrawal(2000, "31/02/2021");
        Assert.assertEquals(account.getBalance().getValue(), Amount.getValueOf(4000).getValue());

    }

    @Test
    public void save_money() throws Exception {
        Amount balanceAfterTransaction = Amount.getValueOf(10);
        account.setBalance(balanceAfterTransaction);
        Assert.assertEquals(account.deposit(10, "31/02/2021"), Status.SUCCESS);

    }

    @Test
    public void retrive_with_negative_amount() throws Exception {
        Assert.assertEquals(account.withdrawal(-10, "31/02/2021"), Status.FAILED_AMOUNT_NEGATIVE);

    }

    @Test
    public void retrive_with_amount_insuffisant() throws Exception {
        Amount balanceBeforeTransaction = Amount.getValueOf(1000);
        account.setBalance(balanceBeforeTransaction);
        Assert.assertEquals(account.withdrawal(2000, "31/02/2021"), Status.FAILED_TRANSACTION_INSUFFISANT_BALANCE);
    }

    @Test
    public void retrive_with_amount_valid() throws Exception {
        Amount balanceBeforeTransaction = Amount.getValueOf(3000);
        account.setBalance(balanceBeforeTransaction);
        Assert.assertEquals(account.withdrawal(2000, "31/02/2021"), Status.SUCCESS);


    }

}
