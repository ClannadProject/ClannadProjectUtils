package de.knoobie.project.clannadutils.common;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtilsJ8 {

    public static final String DATE_FORMAT_YEAR_MINUS_MONTH_MINUS_DAY = "YYYY-MM-dd";

    public static Date getSQLDate(String timeString, Date defaultValue, boolean ignoreExceptions) {
        if (StringUtils.isEmpty(timeString)) {
            return defaultValue;
        }

        try {
            LocalDateTime time = LocalDateTime.parse(timeString);
            return new Date(time.toLocalDate().toEpochDay());

        } catch (Throwable e) {
            if (ignoreExceptions) {
                return defaultValue;
            }
            throw e;
        }
    }

    public static Date getSQLDate(String dateString, String dateFormat, Date defaultValue, boolean ignoreExceptions) {
        return getSQLDate(dateString, dateFormat, Locale.GERMANY, defaultValue, ignoreExceptions);
    }

    public static Date getSQLDate(String dateString, String dateTimeFormatPattern, Locale locale, Date defaultValue, boolean ignoreExceptions) {
        if (StringUtils.isEmpty(dateString)
                || StringUtils.isEmpty(dateTimeFormatPattern)
                || locale == null) {
            return defaultValue;
        }
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern, locale);
            LocalDate date = LocalDate.parse(dateString, formatter);
            return new Date(date.toEpochDay());

        } catch (Throwable e) {
            if (ignoreExceptions) {
                return defaultValue;
            }
            throw e;
        }
    }
}
