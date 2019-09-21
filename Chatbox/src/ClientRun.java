import java.net.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class ClientRun {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int valg;
        int portNr = 0;
        System.out.println("Vælg dit unikke port: \n" +
                "Tast 1: port 6000\n" +
                "Tast 2: port 6001\n" +
                "Tast 3: port 6002\n" +
                "Tast 4: port 6003\n" +
                "Tast 5: port 6004");
        boolean runPort = true;
        while (runPort) {

            try {

                valg = scan.nextInt();
                if (valg == 1) {
                    portNr = 6000;
                    runPort = false;
                } else if (valg == 2) {
                    portNr = 6001;
                    runPort = false;
                } else if (valg == 3) {
                    portNr = 6002;
                    runPort = false;
                } else if (valg == 4) {
                    portNr = 6003;
                    runPort = false;
                } else if (valg == 5) {
                    portNr = 6004;
                    runPort = false;
                } else {
                    System.out.println("Vælg venligst en gyldig port!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Du ødelage programmet");
                System.out.println("Skriv et tal mellem 1-5!");
                System.exit(0);
            }

        }
        try {


            Socket s = new Socket("localhost", portNr);

        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String allMsg = "";
        String user;
        boolean run = true;
        while (run) {
            System.out.print("Skriv UserName Her: ");
            user = br.readLine();
            if (user.matches("^[a-zA-Z.\\-_]{1,12}$")) {

                dout.writeUTF(user);
                run = false;
            } else {
                System.out.println("Your username must be max be 12 chars long \nOnly letters, digits, ‘-‘ and ‘_’ allowed");
            }
        }

        System.out.println("Velkommen til Chatrum");
        System.out.println("Du kan nu skrive en beskid som vil blive vist til alle Clienter gennem Serveren!");
        while (!str.equals("stop")) {
            str = br.readLine();
            dout.writeUTF(str);
            allMsg = din.readUTF();
            System.out.println("Du siger: " + allMsg);
            dout.flush();
            System.out.println("Sendt");
            System.out.println("Skriv \"stop\" for at disconnect");
        }

        dout.close();
        s.close();
        }
        catch (ConnectException e){
            System.out.println("Port allerede i brug!");
            System.out.println("Start programmet igen og vælg en anden port!");
            System.exit(0);
        }
    }

}