/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filemerge;
import java.io.*;

/**
 *
 * @author javie
 */
public class FileMerge {

    public static void main(String[] args) {

        
        String mergedFilePath = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\mergeFiles.png";  // Ruta del archivo final
        String[] partFiles = {
                "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\a.png",  // Fragmento 1
                "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\demo_PART002.txt",  // Fragmento 2
        };
         //For SplitBinaryFile
        /**
        String mergedFilePath = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\mergeFiles.txt";  // Ruta del archivo final
        String[] partFiles = {
                "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\demo_PART001.txt",  // Fragmento 1
                "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Utilities\\demo_PART002.txt",  // Fragmento 2
        };
        **/ //For SplitFile
        try {
            mergeFiles(mergedFilePath, partFiles);  // Ejecutamos la función de merge
        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }

    public static void mergeFiles(String mergedFilePath, String[] partFiles) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(mergedFilePath)) {
            for (String partFile : partFiles) {
                File file = new File(partFile);
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) > 0) {
                        fos.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Merged part: " + partFile);
                }
            }
        }
        System.out.println("Merge complete! Merged file: " + mergedFilePath);
    }
}
