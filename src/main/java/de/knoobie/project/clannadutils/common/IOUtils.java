package de.knoobie.project.clannadutils.common;

import java.io.IOException;
import java.io.Reader;

public class IOUtils {
    
    public static String getString(Reader reader) throws IOException {
        if (reader == null) {
            return StringUtils.EMPTY;
        }
        try {
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return StringUtils.trim(buffer.toString());
        } finally {
            reader.close();
        }
    }

}
