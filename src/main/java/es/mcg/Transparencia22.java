package es.mcg;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Transparencia22 
{
    private static final String HOST = "localhost";
    public static void main(String[] args) {
        Socket socketCliente = null;
        DataInputStream flujoEntrada = null;
        try 
        {
            socketCliente = new Socket(HOST, Transparencia21.PORT);

            flujoEntrada = new DataInputStream(socketCliente.getInputStream());
            System.out.println(flujoEntrada.readUTF());
        } 
        catch (UnknownHostException unknownHostException) 
        {
            unknownHostException.printStackTrace();
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            try {
                flujoEntrada.close();
            } catch (IOException ioException2) {
                ioException2.printStackTrace();
            }
        }
    }    
}
