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
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fileHandler = new FileHandler("C:\\Users\\wajid\\Desktop\\Github reops\\Chatbox\\Chatbox\\Chatbox\\src\\Log\\chatlog.txt", true);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String user2;
        user2=din.readUTF();

        System.out.println("USERNAME: " + user2);

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println(user2 + " says: " + str);
            dout.writeUTF(str2);
            logger.info(user2 + ": "+ str);
            dout.flush();
        }


        din.close();
        s.close();
        ss.close();
    }
}
