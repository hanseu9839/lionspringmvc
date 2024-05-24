package org.example.lionboard.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }
}
