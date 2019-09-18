import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class MyClient {
    public static void main(String args[]) throws Exception {
        Thread beat;
        Socket s = new Socket("localhost", 4567);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        final long startTime = System.nanoTime();
        ClientBeat clientBeat = new ClientBeat();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "", str2 = "";
        while (!str.equals("stop")) {

                clientBeat.run();
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }

        dout.close();
        s.close();
    }
}