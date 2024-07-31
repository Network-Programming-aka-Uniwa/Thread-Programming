/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */

class SharedMessage {
    private String text;
    
    public SharedMessage(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text=text;
    }
}


class ClientForMessage implements Runnable{
    private SharedMessage message;
   
    public ClientForMessage(SharedMessage message){
        this.message=message;
    }
     public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try{
    System.out.println("Thread " + name + " is running and "
            + " waiting to get notified.");
                message.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
    System.out.println("Thread " + name + " got notified "
            + " for message at time:" + 
            System.currentTimeMillis());
    System.out.println("Thread " +  name+ " processed message : " 
            + message.getText());
}   }   }

class HandleMessageAndNotify implements Runnable {
    private SharedMessage message;
    
    public HandleMessageAndNotify(SharedMessage message) {
        this.message = message;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread " + name+ " started.");
        try {
            Thread.sleep(2000);
            synchronized (message) {
                message.setText(name + " Hello Java Threads");
                //message.notify();
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
  }  }  }

public class NotifyApplication {
    public static void main(String[] args) {
        SharedMessage message = new SharedMessage("The message text");
        
        ClientForMessage client1 = new ClientForMessage(message);
        new Thread(client1,"Client_1").start();
        
        ClientForMessage client2 = new ClientForMessage(message);
        new Thread(client2, "Client_2").start();
        
        HandleMessageAndNotify handler = new HandleMessageAndNotify(message);
        new Thread(handler, "Handler").start();
        
        System.out.println("All the threads are running");
    }
}
