/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package splitbinaryfile;
import java.io.*;
/**
 *
 * @author javie
 */
public class SplitBinaryFile {
     public static void main(String[] args) {
         // Definir la ruta del archivo y el tamaño del chunk directamente en el código
        String filePath = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\a.png";  // Ruta del archivo
        int chunkSize = 1024;  // Tamaño de cada chunk en bytes (1 KB)

        try {
            splitBinaryFile(filePath, chunkSize);  // Llamada al método para dividir el archivo
        } catch (IOException e) {
            System.err.println("Error splitting file: " + e.getMessage());
        }
    }

    public static void splitBinaryFile(String filePath, int chunkSize) throws IOException {
        File inputFile = new File(filePath);
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            byte[] buffer = new byte[chunkSize];
            int partNumber = 1;
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) > 0) {
                String partFileName = filePath + "_PART" + String.format("%03d", partNumber++);
                try (FileOutputStream fos = new FileOutputStream(partFileName)) {
                    fos.write(buffer, 0, bytesRead);
                    System.out.println("Created part file: " + partFileName);
                }
            }
        }
    }

}
    

