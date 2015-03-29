/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.knoobie.project.clannadutils.common;

import de.knoobie.project.clannadutils.common.StringUtils;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author cKnoobie
 */
public class FileUtils {

    public static FileSystem getFileSystem() {
        return FileSystems.getDefault();
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

    public static boolean isDirectory(Path path) {
        return Files.isDirectory(path);
    }

    public static boolean isRegularFile(Path path) {
        return Files.isRegularFile(path);
    }

    public static boolean isSymbolicLink(Path path) {
        return Files.isSymbolicLink(path);
    }
}
