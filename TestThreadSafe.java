/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
class ShowCounter {
    public synchronized void  Display(int value){
           for(int i = 0; i < value; i++)
               System.out.println(i);
        }
}	

class HandleShowCounter implements Runnable{
  private ShowCounter oneCounter = null;
  private int value;
  
  public HandleShowCounter(ShowCounter oneCounter, int value){
    this.oneCounter = oneCounter;
    this.value = value;
  }

  public void run(){
    this.oneCounter.Display(value);
  }
}

public class TestThreadSafe {
    public static void main(String[] args){
 ShowCounter sharedShowCounter = new ShowCounter();
System.out.println("The race condition begins");

Thread t1 = new Thread(new HandleShowCounter(sharedShowCounter, 5));
Thread t2 = new Thread(new HandleShowCounter(sharedShowCounter, 5));
t1.start();
t2.start();

try {
    t1.join();
    t2.join();
} catch ( Exception e) {
     System.out.println("Interrupted");
 }
    }
}



