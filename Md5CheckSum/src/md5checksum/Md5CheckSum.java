/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package md5checksum;
import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.util.stream.*;

public class Md5CheckSum {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java DirectoryChecksum <directory_path>");
            return;
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.err.println("The provided path is not a directory.");
            return;
        }

        String outputFilePath = directoryPath + File.separator + "checksum-java.md5";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            // Traverse the directory and process each file
            Files.walk(Paths.get(directoryPath))
                 .filter(Files::isRegularFile)
                 .forEach(filePath -> {
                     try {
                         String relativePath = directory.toURI().relativize(filePath.toUri()).getPath();
                         String md5Checksum = calculateMD5(filePath.toFile());
                         writer.write(md5Checksum + " *" + relativePath);
                         writer.newLine();
                         System.out.println("Processed: " + filePath);
                     } catch (IOException | NoSuchAlgorithmException e) {
                         System.err.println("Failed to process file: " + filePath + " - " + e.getMessage());
                     }
                 });
            System.out.println("Checksum file created: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Failed to write checksum file: " + e.getMessage());
        }
    }

    // Calculate MD5 checksum of a given file
    public static String calculateMD5(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = new FileInputStream(file);
             DigestInputStream dis = new DigestInputStream(is, md)) {

            // Read file data and update the digest
            byte[] buffer = new byte[1024];
            while (dis.read(buffer) != -1) { }
        }

        // Convert the resulting hash to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : md.digest()) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString().toUpperCase(); // Return uppercase MD5
    }
}