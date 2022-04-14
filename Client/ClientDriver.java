
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDriver 
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 2222);
        String torrentName = "cambria.jpeg";
        PrintStream textOutputOverSocket = new PrintStream(s.getOutputStream());
        textOutputOverSocket.println(torrentName);
        textOutputOverSocket.println("ip address") //HOW DO WE GET OUT IP!!!!!!
        textOutputOverSocket.println("" + ClientCORE.getNextPortNumber());
    }
}
