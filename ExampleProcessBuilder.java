/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick Z. Zacharis
 */
import java.util.*;

public class ExampleProcessBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] CommandArgs = {"notepad.exe", "c:\\temp\\example.txt"};
        ProcessBuilder pb = new ProcessBuilder(CommandArgs);
        Map<String, String> env = pb.environment();
        
        for (Map.Entry<String, String> entry : env.entrySet()) {
           System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        
        try {
           //start the subprocess
           System.out.println("Starting the process.");
           pb.start();
           pb.start();
           System.out.println("The process was completed. ");
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
