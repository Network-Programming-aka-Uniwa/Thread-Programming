/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
public class SleepAndInterrupt {
  public static void main(String[] args) 
                      throws InterruptedException {
  ExampleRunnableWithSleep tl = 
          new ExampleRunnableWithSleep("Slow : ", 7);
  Thread t2 = new Thread(tl);
         t2.start();

      for(int i = 0; i < 3; i++) {
         t2.interrupt();
         Thread.sleep(500);
      }
  }
}

