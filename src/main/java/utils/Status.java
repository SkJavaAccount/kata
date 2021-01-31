package utils;

public enum Status {
    SUCCESS("Operation SUCCESS"),
    FAILED_AMOUNT_NEGATIVE("amount should be positive"),
    FAILED_TRANSACTION_INSUFFISANT_BALANCE("insuffisant balance");

    private String message;

    Status(String s) {
        this.message = s;

    }
}
