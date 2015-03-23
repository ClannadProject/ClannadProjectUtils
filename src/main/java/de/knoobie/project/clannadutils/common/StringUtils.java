package de.knoobie.project.clannadutils.common;

public class StringUtils {

    public static final String EMPTY = "";

    public static String removeNPE(String s) {
        return s == null ? EMPTY : s;
    }

    public static String trim(String s) {
        return removeNPE(s).trim();
    }

    public static boolean isEmpty(String val) {
        return isEmpty(val, true);
    }

    public static boolean isEmpty(Object obj, String value) {
        return obj == null ? true : isEmpty(value, true);
    }

    public static boolean isEmpty(String val, boolean checkNPE) {
        return checkNPE ? trim(val).isEmpty() : val.isEmpty();
    }

    public static String removeLastCharacters(String s, int chars) {
        if (s == null || chars <= 0) {
            return EMPTY;
        }
        return s.length() > chars ? s.substring(0, s.length() - chars) : EMPTY;
    }

    public static int getInt(String source, int defaultValue, boolean ignoreExceptions) {
        return getInteger(source, defaultValue, ignoreExceptions);
    }

    public static Integer getInteger(String source, Integer defaultValue, boolean ignoreExceptions) {
        if (isEmpty(source)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(source);
        } catch (Throwable t) {
            if (ignoreExceptions) {
                return defaultValue;
            }
            throw t;
        }
    }
}
