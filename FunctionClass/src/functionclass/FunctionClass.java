/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package functionclass;

import java.io.*;
import java.util.zip.*;

/**
 *
 * @author javie
 */
public class FunctionClass {
    public static void unzipArchive(String zipFilePath, String outputDir) throws IOException{
        byte[] buffer = new byte[1024];
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry;

        while ((entry = zipInput.getNextEntry()) != null) {
            // Asegúrate de que el nombre del archivo no contenga rutas relativas
            String fileName = new File(entry.getName()).getName();
            File newFile = new File(outputDir, fileName);

            // Depuración
            System.out.println("Descomprimiendo: " + newFile.getAbsolutePath());

            // Crea los directorios necesarios
            new File(newFile.getParent()).mkdirs();

            try (FileOutputStream fos = new FileOutputStream(newFile)) {
                int len;
                while ((len = zipInput.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
            }
            zipInput.closeEntry();
        }
        zipInput.close();
        System.out.println("Proceso UNZIP completado exitosamente.");
    } 
    
    public static void mergeFiles(String output,String mergedFileName) throws IOException {
        System.out.println("Entramos en el proceso de mergeFiles.");
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt"};  // Archivos a combinar
        BufferedWriter writer = new BufferedWriter(new FileWriter(output + File.separator + mergedFileName));

        for (String fileName : fileNames) {
            BufferedReader reader = new BufferedReader(new FileReader(output + File.separator + fileName));
            String line;
            while ((line = reader.readLine()) != null) {  // Leer línea por línea
                writer.write(line);  // Escribir cada línea en el archivo combinado
                writer.newLine();  // Añadir salto de línea
            }
            reader.close();
        }
        writer.close();
        System.out.println("Contenido combinado en el archivo: " + mergedFileName);
        System.out.println("Proceso de Merge completado exitosamente");
    }
    
    public static void zipFiles(String outputFolder, String mergedFileName, String zipFilePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(zipFilePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        String[] filesToZip = {"file1.txt", "file2.txt", "file3.txt", mergedFileName};
        for (String fileName : filesToZip) {
            File file = new File(outputFolder + File.separator + fileName);
            FileInputStream fis = new FileInputStream(file);

            ZipEntry zipEntry = new ZipEntry(file.getName());  // Crear entrada en ZIP
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {  // Leer datos y escribir en el ZIP
                zos.write(buffer, 0, len);
            }
            fis.close();
        }

        zos.closeEntry();
        zos.close();
        System.out.println("Archivo ZIP creado: " + zipFilePath);
    }

     
    public static  void main(String[] args){
        String zipFilePath = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\Task-FC.zip";// Archivo ZIP
        String outputFolder = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java";// Carpeta de salida
        String mergedFileName = "merged_file.txt";// Archivo combinado

        try {
            unzipArchive(zipFilePath, outputFolder);
            mergeFiles(outputFolder, mergedFileName);
            zipFiles(outputFolder, mergedFileName, "Task-FC2.zip");

            System.out.println("Proceso completado exitosamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }    
    }
}
