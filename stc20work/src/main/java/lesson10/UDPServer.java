package lesson10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

    private DatagramSocket udpSocket;
    private int port;

//    public oldUDPServer(int port) throws IOException {
//        this.port = port;
//        this.udpSocket = new DatagramSocket(this.port);
//    }

    public UDPServer(int port) throws IOException {
        this.port = port;
        this.udpSocket = new DatagramSocket(this.port);
    }

    private void listen() throws Exception {
        System.out.println("-- Running UDP Server at " + InetAddress.getLocalHost() + " --");
        String msg;
        String name = "";
        String message = "";

        while (true) {

            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            udpSocket.receive(packet);

            msg = new String(packet.getData()).trim();
           // System.out.println("=s= RECEIVED: " + msg);
            name = msg.substring(0, msg.indexOf("-=-"));
            message = msg.substring(msg.indexOf("-=-")+3);

            System.out.println(
                    "Serv - Message from " + name + ": " + message);

            udpSocket.send(packet);
        }
    }

//    private void newListen() throws IOException {
//        byte[] receiveData = new byte[1024];
//        byte[] sendData = new byte[1024];
//
//        while(true)
//        {
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            udpSocket.receive(receivePacket);
//            String sentence = new String( receivePacket.getData());
//            System.out.println("RECEIVED: " + sentence);
//            InetAddress IPAddress = receivePacket.getAddress();
//            port = receivePacket.getPort();
//            String capitalizedSentence = sentence.toUpperCase();
//            sendData = capitalizedSentence.getBytes();
//            DatagramPacket sendPacket =
//                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
//            udpSocket.send(sendPacket);
//        }
//    }
//

    public static void main(String[] args) throws Exception {
        UDPServer client = new UDPServer(7077);
        client.listen();
      //  client.newListen();


    }
}
