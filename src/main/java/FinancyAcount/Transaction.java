package FinancyAcount;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static final String EMPTY_VALUE = "        ";
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private Amount value;
    private Date date;

    public Transaction(Amount value, Date date) {
        this.value = value;
        this.date = date;
    }


    public void addCurrentBalanceTransaction(StringBuilder builder, Amount currentBalance) {
        builder.append("  | ")
                .append(currentBalance.amountFormat());
    }


    private void debitAddToTransaction(StringBuilder builder) {
        builder.append(EMPTY_VALUE)
                .append("  |")
                .append(valueToString())
                .append(" ");
    }

    private void creditAddToTransaction(StringBuilder builder) {
        builder.append(valueToString())
                .append("  |")
                .append(EMPTY_VALUE);
    }

    private String valueToString() {
        return " " + value.absoluteValue().amountFormat();

    }

    public void addDateTransaction(StringBuilder builder) {
        builder.append(dateFormat.format(date));
        builder.append(" |");
    }

    public void addValueTransaction(StringBuilder builder) {
        if (value.compareToValueOf(Amount.getValueOf(0)))
            debitAddToTransaction(builder);
        else
            creditAddToTransaction(builder);

    }


}
