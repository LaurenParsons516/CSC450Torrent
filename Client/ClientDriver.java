
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDriver 
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 2222);
        Scanner textInput = new Scanner(s.getInputStream());
        Scanner localInput = new Scanner(System.in);
        PrintStream textOutput = new PrintStream(s.getOutputStream());
        String question = textInput.nextLine();
        System.out.print(question);
        String answer = localInput.nextLine();
        textOutput.println(answer);
        if(answer.equals("send"))
        {
            try
            {
                String filename = "cambria.jpeg";
                FileInputStream fis = new FileInputStream(filename);
                DataInputStream dis = new DataInputStream(fis);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                while(true)
                {
                    byte b = dis.readByte();
                    dos.writeByte(b);
                }
            }
            catch(EOFException e)
            {
                System.out.println("Finished Sending File");
            }
        }
        else if(answer.equals("receive"))
        {
            //we want to receive the bytes and write to a local file
        }
    }
}
