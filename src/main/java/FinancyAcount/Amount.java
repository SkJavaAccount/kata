package FinancyAcount;

import java.text.DecimalFormat;

public class Amount {
    private int value;
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Amount absoluteValue() {
        return getValueOf(Math.abs(value));
    }

    public String amountFormat (){
        return decimalFormat.format(value);
    }

    public int getValue() {
        return value;
    }

    public Amount(int value) {
        this.value = value;
    }

    public static Amount getValueOf(int value) {
        return new Amount(value);
    }

    public Amount plus(Amount otherAmount) {
        return getValueOf(this.value + otherAmount.value);
    }

    public Amount minus(Amount otherAmount) {
        return getValueOf(this.value - otherAmount.value);
    }
    public Amount negative(){
        return getValueOf(-value);
    }

    public Boolean compareToValueOf(Amount amount) {
        return value < amount.value;
    }

}
