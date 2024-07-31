/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
public class TestRunnableInterrupted {
  public static void main(String[] args) 
                      throws InterruptedException {
  ExampleRunnableWithInterrupted tl = 
          new ExampleRunnableWithInterrupted("Slow : ", 20);
  Thread t2 = new Thread(tl);
         t2.start();

      for(int i = 1; i <= 2000; i++) {
          if((i % 50) == 0)
          {
             System.out.println("Call interrupt...." + i);
             t2.interrupt();
          }
      }
  }
}
