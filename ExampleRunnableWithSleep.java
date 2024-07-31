/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
public class ExampleRunnableWithSleep implements Runnable 
{
   private int plithos = 0;
   private String ThreadName = "";
   
   ExampleRunnableWithSleep(String ThreadName, int plithos) {
        this.ThreadName = ThreadName;
        this.plithos = plithos;
   }

   public void run() {
       int k = 0;
       for(int i = 0; i < plithos; i++) {
           System.out.println(ThreadName + " - " + i);
           try {
                 Thread.sleep(1000 * 10);
           }
           catch(InterruptedException ex) {  
            System.out.println("Interrupt Counter : " + ++k);
           }
       }
   }
}









