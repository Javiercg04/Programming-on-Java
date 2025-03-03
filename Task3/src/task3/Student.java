/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task3;
/**
 *
 * @author javie
 */
public class Student {
    //Atributes
    private String faculty_number;
    private String name;
    private String surname;
    private double average_grade;
    
    //Constructor sin parámetros
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
    
    //Static Methods:
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
}
