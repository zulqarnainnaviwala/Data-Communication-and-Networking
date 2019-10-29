
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Server
{
    private DataInputStream in =  null;
    private ServerSocket server = null;
    private Socket socket = null;


    public Server(int port)  //constructor

    {

        try  // Server will be start and waiting for Connection

        {
            server = new ServerSocket(port);
            System.out.println("Server is Started , And waiting for client's message...");

            socket = server.accept(); // will accrpt a server when it i conected
            System.out.println("Successfully Connected to Client...");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));  // taking input from the client 
            String data = "";

            while ( !data.equals("end")) // get all messages until receives over or end from client 
            {

                try

                {
                    data = in.readUTF();
                    System.out.println(data);
                }
                catch(IOException e) //throws Exception

                {
                    System.out.println(e);
                }

            }


            System.out.println("Connection is ShutDown Cause:Received 'end' from Client");
            socket.close();
            in.close();
        }


        catch(IOException e)

        {
            System.out.println(e);
        }

    }


    public static void main(String args[])

    {
        Server server = new Server(9692);

    }

}