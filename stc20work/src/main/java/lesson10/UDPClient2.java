package lesson10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient2 {

    public static void main(String[] args) throws IOException {

        System.out.print("input Name  = ");

        try {
            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine();

            while (scanner.hasNext()) {
                String message = scanner.next();
                System.out.println("message - " + message);
                sendAndReceive(name + "-=-" + message);

                if (message.equals("quit")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void send(String message) {
        try {
            byte[] data = message.getBytes();
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket pack = new DatagramPacket(data, data.length, addr, 7077);
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void sendAndReceive(String sentence) throws IOException {
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        try {
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            DatagramSocket ds = new DatagramSocket();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, addr, 9999);
            ds.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            ds.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + modifiedSentence);
           // ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
