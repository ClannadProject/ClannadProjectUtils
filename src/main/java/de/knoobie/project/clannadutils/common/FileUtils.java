package de.knoobie.project.clannadutils.common;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static final String[] invalidCharacters = new String[]{"\"","*","/",":","<",">","?","\\","|","-"};
    
    public static FileSystem getFileSystem() {
        return FileSystems.getDefault();
    }
    
    public static String normalizeName(String oldName){
        if(StringUtils.isEmpty(oldName)){
            return StringUtils.EMPTY;
        }
        
        for(String s : invalidCharacters){
           oldName = oldName.replace(s, StringUtils.EMPTY);
        }
        
        return oldName;
    }
    
    public static Path createDirectory(Path directory) throws IOException{
        return Files.createDirectory(directory);
    }

    public static Path createSubDirectory(Path parent, String directoryName) throws IOException, IllegalArgumentException {
        if (parent == null) {
            throw new IllegalArgumentException("Parent directory doesn't exist.");
        }
        if (StringUtils.isEmpty(directoryName)) {
            throw new IllegalArgumentException("Directoryname can't be empty!");
        }
        if (!isDirectory(parent)) {
            throw new IllegalArgumentException("Parent directory isn't a directory!");
        }
        return Files.createDirectory(getFileSystem().getPath(parent.toAbsolutePath().toString(), directoryName));
    }    
    
    public static boolean exists(Path path) {
        return Files.exists(path);
    }

    public static boolean isDirectory(Path path) {
        return Files.isDirectory(path);
    }

    public static boolean isRegularFile(Path path) {
        return Files.isRegularFile(path);
    }

    public static boolean isSymbolicLink(Path path) {
        return Files.isSymbolicLink(path);
    }

    public static void openFileBrowser(Path path) throws IOException{
        Desktop.getDesktop().open(path.toFile());
    }
}
