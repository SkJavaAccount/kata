package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {


    final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static java.util.Date convertToDate(String dateString) throws Exception {
        LocalDate date = LocalDate.parse(dateString, FORMATTER);
        return  java.sql.Date.valueOf(date);

    }
}
