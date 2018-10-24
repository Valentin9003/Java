package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class FolderSize {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long sum = Files.walk(new File("C:\\Users\\Admin\\IdeaProjects\\ExercisesFilesDirectoriesAndExceptions").toPath())
                .map(f -> f.toFile())
                .filter(f -> f.isFile())
                .mapToLong(f -> f.length()).sum();

        FileWriter fr = new FileWriter("OutputFolderSize.txt");
            fr.write(String.format("%d Byte \r\n%.4f Megabyte", sum, ((double) sum / 1024 / 1024)));
        fr.close();
    }
}
