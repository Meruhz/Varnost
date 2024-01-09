package codes.meruhz.varnost.utils;

import codes.meruhz.varnost.Varnost;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class FileUtils {

    public static @NotNull List<InputStream> getAllInputStreamsFromResources(@NotNull String specificFolder) {
        List<InputStream> inputStreams = new ArrayList<>();
        ClassLoader classLoader = Varnost.class.getClassLoader();
        try {
            Enumeration<URL> resources = classLoader.getResources(specificFolder);
            while (resources.hasMoreElements()) {
                URL resourceFolder = resources.nextElement();
                if (resourceFolder.getProtocol().equals("jar")) {
                    String jarPath = resourceFolder.getFile();
                    String jarFilePath = jarPath.substring(5, jarPath.indexOf("!"));
                    String folderPath = jarPath.substring(jarPath.indexOf("!") + 2);
                    try (java.util.jar.JarFile jarFile = new java.util.jar.JarFile(jarFilePath)) {
                        Enumeration<java.util.jar.JarEntry> entries = jarFile.entries();
                        while (entries.hasMoreElements()) {
                            java.util.jar.JarEntry entry = entries.nextElement();
                            if (!entry.isDirectory() && entry.getName().startsWith(folderPath)) {
                                InputStream inputStream = classLoader.getResourceAsStream(entry.getName());
                                if (inputStream != null) {
                                    inputStreams.add(inputStream);
                                }
                            }
                        }
                    }
                } else if (resourceFolder.getProtocol().equals("file")) {
                    File folder = new File(resourceFolder.getFile());
                    processFolder(folder, specificFolder, inputStreams);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inputStreams;
    }

    private static void processFolder(@NotNull File folder, @NotNull String specificFolder, @NotNull List<InputStream> inputStreams) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (file.getName().equals(specificFolder)) {
                        processFolder(file, specificFolder, inputStreams);
                    }
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        inputStreams.add(fileInputStream);
                    } catch (IOException e) {
                        System.err.println("Failed to process file: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

}
