/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task;

/**
 *
 * @author javie
 */
public class IntThread extends Thread{
     private int number;
    
    public IntThread(int number){
        this.number = number;
    }
    
    @Override
    public void run(){
        //15 times the number:
        for(int i = 0; i < 15; i++){
            System.out.println("The number thread is: " + number);
        }
        
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println("Hilo interrumpido.");
        }
    }
}
