import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class MyClient {
    public static void main(String args[]) throws Exception {
        Thread beat;
        Socket s = new Socket("localhost", 4567);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        String user;
        System.out.print("Skriv UserName Her: ");
        user = br.readLine();
        dout.writeUTF(user);

        System.out.println("Velkommen til Chatrum");
        while (!str.equals("stop")) {

                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                System.out.println("Modtaget");
            }

        dout.close();
        s.close();
    }
}