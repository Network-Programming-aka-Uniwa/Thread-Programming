/**
 *
 * @author Nick Z. Zacharis
 */

abstract class nzProcess
{
    abstract void printit();
}

class nzWindows extends nzProcess
{
    void printit()
    {
        System.out.println("Hello in Windows");
    }
}

class nzLinux extends nzProcess
{
    void printit()
    {
        System.out.println("Hello in Linux");
    }
}

class nzProcessBuilder
{
    static nzProcess getit()
    {
        nzWindows t = new nzWindows();
        return t;
    }
}

public class ExampleRunTime {
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) 
  {
    //nzProcess p = nzProcessBuilder.getit();  
    //p.printit();
    // if(3 > 1) return;
    
    try 
    {
      // create a new process
      System.out.println("Starting MsPaint");
      Process msp = Runtime.getRuntime().exec("mspaint.exe");
      // This application will stop until process msp is terminated
      msp.waitFor();
      System.out.println("The process MsPaint was completed.");
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }    
  }
}


