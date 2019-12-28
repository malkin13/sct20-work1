package lesson10.work.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MessageSender implements Runnable {


    public final static int PORT = 7331;
    private DatagramSocket sock;
    private String hostname;
    private boolean connected = false;

    MessageSender(DatagramSocket s, String h) {
        sock = s;
        hostname = h;
    }

    private void sendMessage(String s) throws Exception {
        byte buf[] = s.getBytes();
        InetAddress address = InetAddress.getByName(hostname);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
        sock.send(packet);
    }

    public void run() {
        do {
            try {
               // System.out.print("input Name  = ");
                startClient();
                connected = true;
            } catch (Exception e) {

            }
        } while (!connected);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                while (!in.ready()) {
                    Thread.sleep(100);
                }
                sendMessage(in.readLine());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }


    public boolean startClient() {
                try {
                    Scanner scanner = new Scanner(System.in);

                    String name = scanner.nextLine();

                    while (scanner.hasNext()) {
                        String message = scanner.next();
                        //System.out.println("message - " + message);

                        sendMessage(name + "-=-" + message);
                        if (message.equals("quit")) {
                           connected = false;
                           sock.disconnect();
                           sock.close();
                           break;


                            //break;
                            //throw new Exception("quit");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                return true;
    }
}

