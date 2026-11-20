package serverPackage;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Je suis un serveur en attente la connexion d'un client");
            Socket s = ss.accept();
            System.out.println("un client est connecté");

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            int x;
            while ((x = in.readInt()) != 0) {
                System.out.println("recu : " + x);
                out.writeInt(x * 5);
            }

            in.close();
            out.close();
            s.close();
            ss.close();
            System.out.println("connexion fermee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}