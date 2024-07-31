/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
public class JavaThreadsRunnable {
    
    public static void main(String[] args) {
        ExampleRunnable first = new ExampleRunnable("first", 3000);
        ExampleRunnable second = new ExampleRunnable("second", 4000);
        
        Thread t1 = new Thread(first);
        Thread t2 = new Thread(second);
        Thread t3 = new Thread(new ExampleRunnable("third", 5000));
        
        t1.start();
        t2.start();
        t3.start();
    }
}
