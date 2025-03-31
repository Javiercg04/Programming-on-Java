/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task;

/**
 *
 * @author javie
 */
public class TestThread2 {
    public static void main(String[] args){
        IntThread thread1 = new IntThread(1);
        IntThread thread2 = new IntThread(2);
        IntThread thread3 = new IntThread(3);
        
        
//        thread1.setPriority(Thread.MIN_PRIORITY);  
//        thread2.setPriority(Thread.MIN_PRIORITY + 1);  
//        thread3.setPriority(Thread.MIN_PRIORITY + 2);  
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
