import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Denne klasse implementer vi Runnable interface med metode run()
 */
public class ServerThread implements Runnable {

    private String name;
    private int portNumber;

    /**
     * Detter er min constructor med 2 parameter.
     * @param s navn for en "task".
     * @param port sleve portnr som servern kører på.
     */
    public ServerThread(String s, int port)
    {
        name = s;
        portNumber = port;
    }

    /**
     * Dette er run() metode som bliver hentet fra Runnable interface.
     */
    @Override
    public void run() {

        System.out.println("Creating server socket on port " + portNumber);
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(portNumber);
        Socket s = ss.accept();
        System.out.println("Connected to a Client!");
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fileHandler = new FileHandler("./Log/chatlog.txt", true);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String allMsg = "";
        String user2;
        user2=din.readUTF();

        System.out.println("USERNAME: " + user2);

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println(user2 + " says: " + str);
            allMsg = str;
            dout.writeUTF(allMsg);
            logger.info(user2 + ": "+ str);
            dout.flush();
        }


        din.close();
        s.close();
        ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
