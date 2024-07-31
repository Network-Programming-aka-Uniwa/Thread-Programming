/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
public class JavaThreads {
 
    public static void main(String[] args) 
    {
        ExampleThread t1 = new ExampleThread("first", 3000);
        ExampleThread t2 = new ExampleThread("second", 4000);
        ExampleThread t3 = new ExampleThread("third", 5000);
        t1.start();
        t2.start();
        t3.start();
    }
}
