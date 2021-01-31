package FinancyAcount;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TransactionFormatter {
    private Transaction transaction;
    private Amount currentBalance;

    public TransactionFormatter(Transaction transaction, Amount currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }

    public void printTo(PrintStream printer) {
        StringBuilder builder = new StringBuilder();
        this.transaction.addDateTransaction(builder);
        this.transaction.addValueTransaction(builder);
        this.transaction.addCurrentBalanceTransaction(builder, currentBalance);
        printer.println(builder.toString());
    }


}
