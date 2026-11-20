package serverPackage;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        String ip = "192.168.1.140";
        int port = 1234;
        try {
            InetAddress addr = InetAddress.getByName(ip);
            ServerSocket ss = new ServerSocket();
            ss.bind(new InetSocketAddress(addr, port));
            System.out.println("Serveur en attente sur " + ip + ":" + port);

            Socket s = ss.accept();
            System.out.println("Client connecté : " + s.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            int choix;
            while ((choix = in.readInt()) != 0) {
                double a = in.readDouble();
                double b = in.readDouble();
                String res;
                switch (choix) {
                    case 1: res = String.valueOf(a + b); break;
                    case 2: res = String.valueOf(a - b); break;
                    case 3: res = String.valueOf(a * b); break;
                    case 4:
                        res = (b == 0) ? "Erreur : division par zero" : String.valueOf(a / b);
                        break;
                    default: res = "Choix invalide";
                }
                out.writeUTF(res);
            }

            in.close();
            out.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}