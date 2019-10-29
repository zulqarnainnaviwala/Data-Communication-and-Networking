

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client

{

    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    private Socket socket            = null;

    public Client(String localHostAddress, int port) throws IOException //constructor
    {

        try  //connection will create..

        {
            socket = new Socket(localHostAddress, port);
            System.out.println("You're Connected to Server , Please Send Message/Data...");


            input  = new DataInputStream(System.in); //taking input
            out    = new DataOutputStream(socket.getOutputStream()); //output to socket..
        }


        catch(UnknownHostException z)

        {
            System.out.println(z);
        }


        catch(IOException e)
        {
            System.out.println(e);
        }


        String data = ""; //declare empty string to read message
        while (!data.equals("end"))

        {
            try

            {
                data = input.readLine();
                out.writeUTF(data);
            }


            catch(IOException e)

            {
                System.out.println(e);
            }

        }


        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

    }

    public static void main(String args[]) throws IOException

    {
        Client client = new Client("localhost", 9692);
    }

}
