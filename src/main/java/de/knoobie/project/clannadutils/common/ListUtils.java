package de.knoobie.project.clannadutils.common;

import java.util.Collection;

public class ListUtils {

    public static boolean isEmpty(Collection list) {
        return list == null || list.isEmpty();
    }

    public static String getListAsString(Collection list) {
        if (isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        return String.join(", ", list);
    }
}
