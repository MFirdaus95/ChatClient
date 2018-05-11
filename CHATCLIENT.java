import java.io.*;
import java.net.*;

public class ChatClient
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("192.168.111.129", 4583);
     BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));
     OutputStream ostream = sock.getOutputStream();
     PrintWriter pwrite = new PrintWriter(ostream, true);
     InputStream istream = sock.getInputStream();

     BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));
     System.out.println("START CHAT, type and press Enter key");
     String receiveMessage, sendMessage;

     while(true)
     {
       
       if((receiveMessage = receiveRead.readLine()) != null)
       {
         System.out.println(receiveMessage);
      }

      sendMessage = keyRead.readLine();
      pwrite.println(sendMessage);
      pwrite.flush();
    }
  }
}
