package es.mcg;

import java.io.IOException;
import java.net.ServerSocket;

public class Transparencia20 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(0);
            System.out.println("Server started: "+server);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
