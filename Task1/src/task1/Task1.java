/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author javie
 */
public class Task1{

    /**
     * @param args the command line arguments
     */
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
