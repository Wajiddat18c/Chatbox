import java.net.*;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class MyServer {

    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(4567);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter("C:\\Users\\wajid\\Desktop\\Github reops\\Chatbox\\Chatbox\\Chatbox\\src\\Log\\chatlog.txt", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fileHandler = new FileHandler("C:\\Users\\wajid\\Desktop\\Github reops\\Chatbox\\Chatbox\\Chatbox\\src\\Log\\chatlog.txt", true);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);

        String str = "", str2 = "";
        while (!str.equals("stop")) {

            str = din.readUTF();
            System.out.println("client says: " + str);
            str2 = br.readLine();
            dout.writeUTF(str2);
            logger.info(str);
//            buffer.append(str);
            dout.flush();
        }


        buffer.close();
        din.close();
        s.close();
        ss.close();
    }
}
