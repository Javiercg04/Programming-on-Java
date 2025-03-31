/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task;
import task.IntThread;
/**
 *
 * @author javie
 */
public class TestThread {
    public static void main(String[] args){
        IntThread thread1 = new IntThread(1);
        IntThread thread2 = new IntThread(2);
        IntThread thread3 = new IntThread(3);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
