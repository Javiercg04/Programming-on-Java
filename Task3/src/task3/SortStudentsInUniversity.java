/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import task3.Student;

/**
 *
 * @author javie
 */
public class SortStudentsInUniversity {

    /**
     * @param args the command line arguments
     */
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

