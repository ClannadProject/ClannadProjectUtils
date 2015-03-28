package de.knoobie.project.clannadutils.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayUtils {

    public static ArrayList<?> getListFromArray(Object[] array) {
        return new ArrayList(Arrays.asList(array));
    }

    /**
     * @todo EXPERIMENTELL!!!
     * @param array
     * @param containingObj
     * @return
     */
    public static boolean contains(Object[] array, Object containingObj) {
        if (containingObj == null) {
            return false;
        }
        return new ArrayList(Arrays.asList(array)).contains(containingObj);
    }

    public static <T> T getFirstItemFromList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T getFirstItemFromCollection(Collection<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.iterator().next();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length <= 0;
    }
}
