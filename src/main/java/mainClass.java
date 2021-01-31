import FinancyAcount.Account;

public class mainClass {


    public static void main(String[] args) throws Exception {
        Account account = new Account();


        System.out.println("Transaction is " + account.deposit(1000, "10/01/2021"));
        System.out.println("Transaction is " + account.deposit(2000, "13/01/2021"));
        System.out.println("Transaction is " + account.withdrawal(500, "14/01/2021"));
        System.out.println("Transaction is " + account.withdrawal(4000, "15/01/2021"));
        System.out.println("Transaction is " + account.withdrawal(-300, "16/01/2021"));
        account.history(System.out);
    }
}