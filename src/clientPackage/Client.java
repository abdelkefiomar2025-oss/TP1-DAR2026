package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String ip = "192.168.1.140";
        int port = 1234;
        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress(InetAddress.getByName(ip), port));
            System.out.println("Connecté au serveur " + ip);

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);

            int choix;
            do {
                System.out.println("\n1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = sc.nextInt();
                out.writeInt(choix);

                if (choix != 0) {
                    System.out.print("x = ");
                    double a = sc.nextDouble();
                    System.out.print("y = ");
                    double b = sc.nextDouble();
                    out.writeDouble(a);
                    out.writeDouble(b);
                    System.out.println("Resultat : " + in.readUTF());
                }
            } while (choix != 0);

            sc.close();
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}