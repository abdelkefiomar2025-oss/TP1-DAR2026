package activite11.clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté…");
            Socket s = new Socket("localhost", 1234);
            System.out.println("je suis un client connecté");
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}