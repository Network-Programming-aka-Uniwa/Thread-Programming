/**
 *
 * @author Nick Z. Zacharis
 */
import java.io.*;
import java.net.*;

public class WebServer {
 private ServerSocket WebSocket = null;
    private int port = 80;
    private boolean started = false;
    
    WebServer(){
    }
    
    WebServer(int port){
      this.port = port; 
    }
    
    public void start() 
    {
      try {
            WebSocket = new ServerSocket(port);
        } 
        catch (IOException e) 
        {
            throw new RuntimeException("Error in binding port : " + port, e);
        }
        started = true;
    }
    
    public void run() {
        if(started) {
            while(true) {
                try
                {
                   Socket clientSocket = WebSocket.accept();
                   Thread HandleClient = new Thread(new WebClient(clientSocket));
                   HandleClient.start();
                }
                catch (IOException ex) {            
                    System.out.println("An exception has occured");
                }
            }
        }
        else {
            System.out.println("The server is not started.");
        }
    }
    
     public static void main(String[] args){
         WebServer Navajo = new WebServer(7090);
         Navajo.start();
         Navajo.run();
     }
}
