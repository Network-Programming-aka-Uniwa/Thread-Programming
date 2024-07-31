/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
import java.io.*;
import java.net.Socket;

public class WebClient implements Runnable{

    private Socket clientSocket = null;
    
    final String message = "HTTP/1.1 200 OK\n\n<html>\n<body>\n"
            + "<a href=\"http://www.apache.org\">The real stuff is Apache</a>\n"
            + "</body>\n</html>";

    public WebClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    private void HandleRequest(InputStream input) throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(input));

         while(true) {
             String oneLine = br.readLine();
             System.out.println(oneLine);
             if(oneLine.equals(""))
             {
                break;
             }
        }
    }

    private void HandleResponse(OutputStream output) throws IOException
    {
         output.write(message.getBytes());
    }
    
    @Override 
     public void run() {
         InputStream input  = null;
         OutputStream output = null;
         
         try {
           long time1 = System.currentTimeMillis();
           input  = clientSocket.getInputStream();            
           output = clientSocket.getOutputStream();
            
           HandleRequest(input);
           HandleResponse(output);
            
           output.close();
           input.close();
           long diff = System.currentTimeMillis() - time1;            
           System.out.println("Request processed in : " + diff + " msecs.");
         } 
         catch (IOException ex) {
            System.out.println("An error has occured.");
         }   
         finally {
             try {
                 if(input != null) input.close();
               }catch(IOException ex) {}
             try {
                 if(output != null) output.close();
               }catch(IOException ex) {}
         }  
     } // end of run
} // end of class
