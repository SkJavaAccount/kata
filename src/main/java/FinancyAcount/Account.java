package FinancyAcount;

import utils.Date;
import utils.Status;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> listOfTransaction = new ArrayList<Transaction>();
    private Amount balance = Amount.getValueOf(0);
    private List<TransactionFormatter> listOfDiplayLine = new ArrayList<TransactionFormatter>();
    public static final String Lines_HEADER = "date       | credit   | debit    | balance";


    public Status withdrawal(int amountCredit, String date) throws Exception {
        if (amountCredit < 0) {
            return (Status.FAILED_AMOUNT_NEGATIVE);
        }
        Amount amount = Amount.getValueOf(amountCredit);
        Transaction transaction = new Transaction(amount.negative(), Date.convertToDate(date));
        listOfTransaction.add(transaction);

        Amount balanceAfterTransaction = balance.minus(amount);

        if (balanceAfterTransaction.compareToValueOf(Amount.getValueOf(0))) {
            TransactionFormatter transactionFormatter = new TransactionFormatter(transaction, balance);
            listOfDiplayLine.add(transactionFormatter);
            return (Status.FAILED_TRANSACTION_INSUFFISANT_BALANCE);
        } else {
            this.balance = balanceAfterTransaction;
            TransactionFormatter transactionFormatter = new TransactionFormatter(transaction, balance);
            listOfDiplayLine.add(transactionFormatter);
            return (Status.SUCCESS);
        }
    }

    public Status deposit(int amountDeposit, String date) throws Exception {
        if (amountDeposit < 0) {
            return Status.FAILED_AMOUNT_NEGATIVE;

        }
        Amount amount = Amount.getValueOf(amountDeposit);
        Transaction transaction = new Transaction(amount, Date.convertToDate(date));
        listOfTransaction.add(transaction);
        this.balance = balance.plus(amount);
        TransactionFormatter transactionFormatter = new TransactionFormatter(transaction, balance);
        listOfDiplayLine.add(transactionFormatter);
        return (Status.SUCCESS);
    }


    public void setBalance(Amount balance) {
        this.balance = balance;
    }

    public void history(PrintStream printer) {
        printer.println(Lines_HEADER);
        for (TransactionFormatter lines : listOfDiplayLine) {
            lines.printTo(printer);
        }

    }

    public Amount getBalance() {
        return balance;
    }
}
