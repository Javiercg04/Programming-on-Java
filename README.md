# Programming-on-Java

## Index
1. Task 1
2. Task 3


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
