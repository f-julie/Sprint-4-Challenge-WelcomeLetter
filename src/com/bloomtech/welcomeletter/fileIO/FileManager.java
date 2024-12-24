package com.bloomtech.welcomeletter.fileIO;

import java.io.*;
import java.util.Scanner;

// I added
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileManager {
    public FileManager() {
    }

    public String getTextFromFile(String filename) throws FileNotFoundException {
        //String returnString = "";

        // With help from BloomTech LearnBot
        String filePath = "src/resources/" + filename + ".txt";
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at path: " + filePath);
        }

        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                content.append('\n'); // add newline character
            }
        }

        return content.toString();

        //return returnString;
    }

    public void writeTextToFile(String outFileName, String text) throws IOException {
        String outFilePath = "src/resources/out/" + outFileName + ".txt";
        try {
            Files.write(Paths.get(outFilePath), text.getBytes());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
