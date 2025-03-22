/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package splitfile;
import java.io.*;
import java.util.zip.*;
/**
 *
 * @author javie
 */
public class SplitFile {

    public static void main(String[] args) {
        // Definir la ruta del archivo y el tamaño del chunk directamente en el código
        String filePath = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\demo.txt";  // Ruta del archivo
        int chunkSize = 1024;  // Tamaño de cada chunk en bytes (1 KB)

        try {
            splitTextFile(filePath, chunkSize);  // Llamada al método para dividir el archivo
        } catch (IOException e) {
            System.err.println("Error splitting file: " + e.getMessage());
        }
    }

    public static void splitTextFile(String filePath, int chunkSize) throws IOException {
        File inputFile = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int partNumber = 1;
            int bytesRead = 0;
            char[] buffer = new char[chunkSize];

            while ((bytesRead = reader.read(buffer)) > 0) {
                String partFileName = filePath.replace(".txt", "_PART" + String.format("%03d", partNumber++) + ".txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(partFileName))) {
                    writer.write(buffer, 0, bytesRead);
                    System.out.println("Created part file: " + partFileName);
                }
            }
        }
    }
    
}
