package userservice.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class Converter {

    public static String convertMillsToString(long birthday) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(birthday);

        int mYear = calendar.get(Calendar.YEAR);
        String mMonth = calendar.get(Calendar.MONTH) + 1 < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1) + "";
        String mDay = calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH) + "";
        return mDay + "." + mMonth + "." + mYear;
    }

    public static long convertDateToMills(String date) {
        try {
            date += "T00:00:00.000Z";
            LocalDateTime localDateTime = LocalDateTime.parse(date,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm:ss.SSS'Z'"));

            return localDateTime
                    .atZone(ZoneId.systemDefault())
                    .toInstant().toEpochMilli();
        } catch (DateTimeParseException e) {
            return -1;
        }
    }
}
