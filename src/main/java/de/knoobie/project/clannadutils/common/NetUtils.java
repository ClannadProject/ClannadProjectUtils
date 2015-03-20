package de.knoobie.project.clannadutils.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtils {

    public static final int DEFAULT_CONNECTION_TIMEOUT = 2000;
    public static final int DEFAULT_READ_TIMEOUT = 5000;

    public static String normalizeFragment(String urlFragment){
        if(StringUtils.isEmpty(urlFragment)){
            return StringUtils.EMPTY;
        }
        
        return urlFragment.replace(" ", "%20");
    }
    
    public static InputStream getInputStream(String url) throws MalformedURLException, IOException {
        URLConnection connection = getURLConnection(url);
        return connection != null ? connection.getInputStream() : null;
    }

    public static URLConnection getURLConnection(String url) throws MalformedURLException, IOException {
        URL _url = new URL(url);
        URLConnection connection = _url.openConnection();
        connection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
        connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
        return connection;
    }
}
