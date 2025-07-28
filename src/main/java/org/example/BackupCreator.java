package org.example;

import java.io.*;
import java.nio.file.*;

public class BackupCreator {
    public static void backupFiles(String sourceDirName, String backupDirName) throws IOException {
        Path sourceDir = Paths.get(sourceDirName);
        Path backupDir = Paths.get(backupDirName);

        if (!Files.exists(backupDir)) {
            Files.createDirectory(backupDir);
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    Path destination = backupDir.resolve(file.getFileName());
                    Files.copy(file, destination, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }

        System.out.println("Резервное копирование завершено.");
    }
}
