import java.net.*;
import java.io.*;

public class Conexao {

    public static void send(Socket socket, String txt) {
        OutputStream out;
        try {
            out = socket.getOutputStream();
            out.write(txt.getBytes());
        } catch (IOException e) {
            System.out.println("Excecao no OutputStream");
        }
    }

    public static String receive(Socket socket) {
        InputStream in;
        int bt;
        byte btxt[] = new byte[64];
        String txt = "";
       
        try {
            in = socket.getInputStream();
            bt = in.read(btxt);
            if (bt > 0) {
                txt = new String(btxt);
            }
        } catch (IOException e) {
            System.out.println("Excecao no InputStream: " + e);
        }
        return txt;
    }
}