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
  
  public static boolean isEmpty(Object obj, String value){
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

  public static int getInteger(String source, int defaultValue, boolean ignoreExceptions) {

    if (source == null || source.isEmpty() || source.trim().isEmpty()) {
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
