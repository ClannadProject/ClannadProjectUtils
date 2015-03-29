package de.knoobie.project.clannadutils.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NetUtils {

    public static final int DEFAULT_CONNECTION_TIMEOUT = 2000;
    public static final int DEFAULT_READ_TIMEOUT = 5000;

    public static String normalizeFragment(String urlFragment) {
        if (StringUtils.isEmpty(urlFragment)) {
            return StringUtils.EMPTY;
        }

        return urlFragment.replace(" ", "%20");
    }

    public static InputStream getInputStream(String url) throws MalformedURLException, IOException, FileNotFoundException {
        URLConnection connection = getURLConnection(url);
        return connection != null ? connection.getInputStream() : null;
    }

    public static OutputStream getOutputStream(String url) throws MalformedURLException, IOException, FileNotFoundException {
        URLConnection connection = getURLConnection(url);
        return connection != null ? connection.getOutputStream() : null;
    }

    public static URLConnection getURLConnection(String url) throws MalformedURLException, IOException {
        URL _url = new URL(url);
        URLConnection connection = _url.openConnection();
        connection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
        connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
        return connection;
    }

    /**
     *
     * @param source
     * @param target
     * @return boolean - if the source is correctly downloaded to target
     * @throws MalformedURLException if the source is not a valid url
     * @throws IOException if an I/O error occurs while creating the input stream.
     */
    public static boolean downloadFromUrl(String source, String target) throws MalformedURLException, IOException {
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(target)) {
            return false;
        }
        
        Path newFile = new File(target).toPath();

        if (newFile == null) {
            return false;
        }
        Files.copy(getInputStream(source), newFile,
                StandardCopyOption.REPLACE_EXISTING);

        return Files.exists(newFile, LinkOption.NOFOLLOW_LINKS);
    }
}
