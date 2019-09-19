import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class ClientRun {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int valg;
        int portNr = 0;
        System.out.println("Vælg en Port: \n" +
                "Tast 1: port 6000\n" +
                "Tast 2: port 7000\n" +
                "Tast 3: port 8000\n" +
                "Tast 4: port 9000\n" +
                "Tast 5: port 10000");
        valg = scan.nextInt();
        if (valg == 1){
            portNr = 6000;
        }else if (valg == 2){
            portNr = 7000;
        }else if (valg == 3){
            portNr = 8000;
        }else if (valg == 4){
            portNr = 9000;
        }else if (valg == 5){
            portNr = 10000;
        }else {
            System.out.println("Sorry you have to pick a avalible port! Try again!");
            System.exit(0);
        }
        Socket s = new Socket("localhost", portNr);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String allMsg = "";
        String user;
        System.out.print("Skriv UserName Her: ");
        user = br.readLine();
        dout.writeUTF(user);

        System.out.println("Velkommen til Chatrum");
        while (!str.equals("stop")) {
                str = br.readLine();
                dout.writeUTF(str);
                allMsg = din.readUTF();
                System.out.println(user + " siger: " + allMsg);
                dout.flush();
                System.out.println("Modtaget");
            }

        dout.close();
        s.close();
    }
}