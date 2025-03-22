# Programming-on-Java

## Index
1. Task 1
2. Task 3
3. HW-Zip
4. HW-Files


## Task 1:
First of all I have to inform that I have been using windows so I haven't figured out how to use the terminal.
So we are going to start with the principal task:
```
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        /**
         We have to start to write on a empty "file" so
         we are going to use Scanner to understand what each person wants to write on the file.
        **/
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter file name: ");
        String filepath = scanner.nextLine();
      
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String mail = scanner.nextLine();
        
        System.out.print("Enter your phone: ");
        String number = scanner.nextLine();
        
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            writer.write("BEGIN:VCARD\n");
            writer.write("VERSION:3.0\n");
            writer.write("FN:" + name + "\n");
            writer.write("EMAIL:" + mail + "\n");
            writer.write("NOTE:Phone number: " + number + "\n");
            writer.write("NOTE:Address: " + address    + "\n");
            writer.write("END:VCARD\n");
        }catch(IOException e){
            e.printStackTrace();
            System.out.print("Error");   
        } 
        scanner.close();
    }
    
}
```
That's the code so in the first line we use the Scanner librery to read all the things that we write on the terminal. Also, we have to know about the other libraries that we use:

```

import java.io.BufferedWriter;

```
BufferedWriter is a class used to write text to an output stream (such as a file) efficiently. It uses an internal buffer to reduce the number of accesses to the writing system.

```

import java.io.FileWriter;

```
FileWriter is a class that allows you to write characters to a file. It is a simple way to write text to files in Java.

```

import java.io.IOException;

```
IOException is a checked exception that occurs when there are input/output (I/O) problems in a program. It is used to handle errors when working with files, data streams, sockets, etc.

Then when can focus on the rest of the code, that we use the libraries to do all the project, becaus eof the problem that I mentioned before is a very simple project, but with this we can practice how to use the different libraries. 

You can execute the problem, only press the run button and on the terminal you write the things needed to do the vfc file.

## Task 3

In this case, we can break down each part of the code bit by bit in this case we will see the following:
1. Student Class(get/set).
2. Specific Methods.
3. Main

### Student Class:
```
public class Student {
    //Atributes
    private String faculty_number;
    private String name;
    private String surname;
    private double average_grade;
    
    //Constructor without parameters
    public Student(){
        this.faculty_number="UnKnown";
        this.average_grade=0.0;
        this.name= "UnKnown";
        this.surname= "UnKnown";
    }
    
    //Constructor 
    public Student(String faculty,String n,double a_g,String sn){
        if( !validFacultyNumber(faculty) || a_g < 0 || a_g > 6 ){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.faculty_number=faculty;
        this.name=n;
        this.average_grade=a_g;
        this.surname= sn;
    }
    
    //Setters
    public void setFaculty_Number(String faculty){
        if( !validFacultyNumber(faculty)){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.faculty_number=faculty;
    }
    
    public void setName(String n){
        this.name=n;
    }
    
    public void setSurname(String sn){
        this.surname=sn;
    }
    
    public void setAverage_grade(double a_g){
        if ( a_g < 0 || a_g > 6){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.average_grade=a_g;
    }
    
    //Getters
    public String getFaculty_Number(){
        return this.faculty_number;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getAverage_grade(){
        return this.average_grade;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    //Methods:
    public String toString(){
        return this.name + " " + this.surname + " " + this.faculty_number + " " + this.average_grade;
    }


```
First we will focus on the private attributes, which are private class attributes, that is: Private attributes are variables declared with the access modifier private within a class. They can only be accessed and modified from within the same class, not from other classes. This follows the principle of encapsulation, one of the foundations of object-oriented programming (OOP), which helps to protect data and avoid undue modification.

Constructor initialises to an unknown value if it has not been initialised with parameters, and we apply the overload, since there is another constructor with parameter passing. Looking at different ways of doing this
```
//Constructor 
    public Student(String faculty,String n,double a_g,String sn){
        if( !validFacultyNumber(faculty) || a_g < 0 || a_g > 6 ){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.faculty_number=faculty;
        this.name=n;
        this.average_grade=a_g;
        this.surname= sn;
    }
    
    //Setters
    public void setFaculty_Number(String faculty){
        if( !validFacultyNumber(faculty)){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.faculty_number=faculty;
    }

```
Otherwise, the set methods only allow us to modified the value of the private class atributes:
```

 //Setters
    public void setFaculty_Number(String faculty){
        if( !validFacultyNumber(faculty)){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.faculty_number=faculty;
    }
    
    public void setName(String n){
        this.name=n;
    }
    
    public void setSurname(String sn){
        this.surname=sn;
    }
    
    public void setAverage_grade(double a_g){
        if ( a_g < 0 || a_g > 6){
            throw new IllegalArgumentException("Invalid faculty number");
        }
        this.average_grade=a_g;
    }

```
Because is a bulgarian grade the grade only goes from 0 to 6, so it's important to take care.

Finally e have the getters, only to use it to show the values. In addition, it is important that I have made a to string to make it easier in main or elsewhere to express the class and its attributes.
```

 //Getters
    public String getFaculty_Number(){
        return this.faculty_number;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getAverage_grade(){
        return this.average_grade;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    //Methods:
    public String toString(){
        return this.name + " " + this.surname + " " + this.faculty_number + " " + this.average_grade;
    }

```

### Specific Methods.
```

public static boolean validFacultyNumber(String faculty_number){
        if(faculty_number == null || faculty_number.length() < 5 || faculty_number.length() > 10 ){
            System.out.println("ERROR EN LA LONGITUD");
            return false;
        }else if ( faculty_number.length() >= 5 && faculty_number.length() <= 6){
            for( int i = 0; i < faculty_number.length(); i++){
                char c = faculty_number.charAt(i);
                boolean check = (c >= '0' && c <= '9');
                if( check == false ){
                    System.out.println("ERROR POR PONER LETRA EN LONGITUD DE 5-6");
                    return false;
                }
            }
        }
        
//        int checksum = faculty_number.charAt(0) - '0';
//        int c_checksum = 0;
//        
//        for( int i = 1; i < faculty_number.length(); i++){
//            char c = faculty_number.charAt(i);
//            int value = (c >= '0' && c <= '9') ? (c - '0') : ((c & 31));
//            c_checksum += value;
//            System.out.print(c_checksum + "\n");
//        }   
//        
//        return (c_checksum % 11) == checksum;
          return true;
    }

```
If the number of faculty is null, less than 5 characters or greater than 10 characters, an error is displayed and the function returns false. If the length is between 5 and 6 characters, it checks that all characters are numbers. If it finds a letter, it displays an error and returns false.

### Main
```

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import task3.Student;

public class SortStudentsInUniversity {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Student> students = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many students do you want to sort: ");
        int number_students = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < number_students; i++){
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter your surname: ");
            String surname = scanner.nextLine();
            
            System.out.print("Enrer Faculty number: ");
            String faculty_number = scanner.nextLine();
            
            System.out.print("Average grade: ");
            double a_g = scanner.nextDouble();
            scanner.nextLine();
            
            students.add(new Student(faculty_number,name,a_g,surname));
        }
        
        scanner.close();
        
       //students.sort(Comparator.comparingDouble(Student::getAverage_grade).reversed().thenComparing(Student::getName));
       
       for(int i = 0; i < students.size() - 1; i++){
           for(int j = i + 1; j < students.size() ; j++){
               if( students.get(i).getAverage_grade() < students.get(j).getAverage_grade() ||
                   students.get(i).getAverage_grade() == students.get(j).getAverage_grade() && 
                   students.get(i).getName().compareTo(students.get(j).getName()) > 0 ||
                   students.get(i).getSurname().compareTo(students.get(j).getSurname()) > 0){
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);    
               }
           }
       }
        
       System.out.println("Name Surname FacultyNumber AverageGrade");
       
       for(Student student : students){
           System.out.println(student.toString());
       }
    }
    
}


```
We use arraylist to be able to store the number of users that people request. We then use Scanner to together with the for to be able to store all the students that are requested using the constructor of the class. And the to string to show the students already sorted.
Then we sort mainly by grades, then first name, then surname.

For execute we only have to touch the run button.


## HW-Zip
First of all, we understand what we have to do in this project. First we have to talk about what we have to do. 
First of all we have to focus on unzip, which is the method that allows us to decompress the file where the zip file is located.
```

public static void unzipArchive(String zipFilePath, String outputDir) throws IOException{
        byte[] buffer = new byte[1024]; // With this buffer we can read the content of the files.
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipFilePath)); // This class implements an input stream filter for reading files in the ZIP file format. 
        ZipEntry entry; // This class is used to represent a ZIP file entry.

        while ((entry = zipInput.getNextEntry()) != null) { // WHile there are files on the directory
            String fileName = new File(entry.getName()).getName(); // To know the names.
            File newFile = new File(outputDir, fileName);
            new File(newFile.getParent()).mkdirs(); // Create the necesary directories.
            try (FileOutputStream fos = new FileOutputStream(newFile)) {
                int len;
                while ((len = zipInput.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
            } // This lines is to read what is on the files.
            zipInput.closeEntry();
        }
        zipInput.close();
    } 

```
After that, as it says in the statement itself, we have to merge the different files into one.
```

 public static void mergeFiles(String output,String mergedFileName) throws IOException {
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt"};  // Files to combine
        BufferedWriter writer = new BufferedWriter(new FileWriter(output + File.separator + mergedFileName));

        for (String fileName : fileNames) {
            BufferedReader reader = new BufferedReader(new FileReader(output + File.separator + fileName));
            String line;
            while ((line = reader.readLine()) != null) {  // Read line by line
                writer.write(line);  // Write each line in the combined file
                writer.newLine();  // Add line break
            }
            reader.close();
        }
        writer.close();
    }

```
Finally, as requested, we need to re-compress the file.
```

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
    }

```

With this last one we have already made the complete programme together with the main one that I am going to show now, which is very basic, but finally we have to take into account that we use the absolute route.
```

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

```
Finally we use two libraries:
```

import java.io.*; // For exceptions.
import java.util.zip.*; // For use the classes.

```

## HW-Files
### SplitFile:
```

public static void splitTextFile(String filePath, int chunkSize) throws IOException {
        File inputFile = new File(filePath); // Creates a File object representing the file located at the path filePath
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) { // Used to ensure that the resource (BufferedReader in this case) is automatically closed after use.
            int partNumber = 1; // Initialises a partNumber counter that keeps track of the parts into which the file is to be split (part 1, part 2, part 3, etc.).
            int bytesRead = 0; // Create a bytesRead variable that will store the number of bytes read in each iteration of the loop.
            char[] buffer = new char[chunkSize]; // Creates a buffered character array with size equal to chunkSize. This buffer shall temporarily store each chunk of data read from the file.

            while ((bytesRead = reader.read(buffer)) > 0) { // The loop continues to run as long as bytesRead > 0.
                String partFileName = filePath.replace(".txt", "_PART" + String.format("%03d", partNumber++) + ".txt"); // Generates the file name of the current part.
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(partFileName))) { 
                    writer.write(buffer, 0, bytesRead); // Writes to the file the buffered characters, from index 0 to the number of characters read in that iteration (bytesRead).
                    System.out.println("Created part file: " + partFileName);
                }
            }
        }
    }

```
After this we need the main:
```

public static void main(String[] args) {
        // Definir la ruta del archivo y el tamaño del chunk directamente en el código
        String filePath = "C:\\Users\\javie\\OneDrive - UNIVERSIDAD DE GRANADA\\Documentos\\3 Carrera\\1 Semestre\\Programming on  Java\\demo.txt";  // Ruta del archivo
        int chunkSize = 1024;  // 1 KB

        try {
            splitTextFile(filePath, chunkSize);
        } catch (IOException e) {
            System.err.println("Error splitting file: " + e.getMessage());
        }
    }
    
```
### SplitBinaryFile:
```

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

```
After this we need the main:
```

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

```
### Differencies between SplitFile and SplitBinaryFile:
- SplitFile (Texto):

Este programa procesa archivos de texto.

Utiliza clases como BufferedReader y BufferedWriter que trabajan con datos de texto (caracteres).

Maneja texto codificado en formatos legibles como ASCII o UTF-8, por lo que trabaja en términos de caracteres.

- SplitBinaryFile (Binario):

Procesa archivos binarios, como imágenes, videos, archivos ejecutables, o archivos comprimidos.

Utiliza clases como BufferedInputStream y BufferedOutputStream, que trabajan con datos binarios (bytes).

En lugar de caracteres, lee y escribe datos byte por byte, lo cual es esencial para preservar la integridad de archivos binarios que podrían corromperse si se tratan como texto.

























