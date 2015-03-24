package de.knoobie.project.clannadutils.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String TAG_MONTAG_JAHR_UM_STUNDE_MINUTE_SEKUNDE = "dd.MM.yy 'um' hh:mm:ss";
    public static final String DATE_FORMAT_YEAR_MINUS_MONTH_MINUS_DAY = "YYYY-MM-dd";

    public static String getNow(String simpleDateFormat) {
        DateFormat dfmt = new SimpleDateFormat(simpleDateFormat);
        return dfmt.format(getNow());
    }

    public static String getDateWithFormat(Date date, String simpleDateFormat) {
        DateFormat dfmt = new SimpleDateFormat(simpleDateFormat);
        return dfmt.format(date);
    }

    public static Date getNow() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public static Date getFutureDate(int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Timestamp getTimestampNow() {
        return new Timestamp(getNow().getTime());
    }

}
