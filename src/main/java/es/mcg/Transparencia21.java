package es.mcg;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Transparencia21 {
    protected static final int PORT = 8080;

    public static void main(String[] args) 
    {
        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        DataOutputStream dataOutputStream = null;
        try 
        {
            socketServidor = new ServerSocket(PORT);

            socketCliente = socketServidor.accept();

            dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
            dataOutputStream.writeUTF("Hola, soy Manuel Cano, este es mi servidor");

            dataOutputStream.close();
            socketCliente.close();
            socketServidor.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            if(dataOutputStream != null)
            {
                try {
                    dataOutputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                
            }
            if(socketCliente != null)
            {
                try {
                    socketCliente.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if(socketServidor != null)
            {
                try {
                    socketServidor.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                
            }
        }
    }
}
