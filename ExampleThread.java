/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
public class ExampleThread extends Thread 
{
   private int plithos =0;
   private String ThreadName = "";
 
   ExampleThread(String ThreadName, int plithos)
   {
      this.ThreadName = ThreadName;
      this.plithos = plithos;
   }
   
   public void run()
   {
        for(int i = 0; i < plithos; i++)
        {
             System.out.println(ThreadName + " - " + i);
        }
   }
}