import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

class MyClient {
    public static void main(String args[]) throws Exception {
        Thread beat;
        Socket s = new Socket("localhost", 4567);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//        final long startTime = System.nanoTime();
//        ClientBeat clientBeat = new ClientBeat();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!str.equals("stop")) {

//                clientBeat.run();
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                System.out.println("Modtaget");
            }

        dout.close();
        s.close();
    }
}