package lesson10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSpy {

    private DatagramSocket udpSocket;
    private InetAddress serverAddress;
    private int port;
    private Scanner scanner;


    private UDPSpy(int port) throws IOException {
        this.port = port;
        this.udpSocket = new DatagramSocket(this.port);
    }


    private void listen() throws Exception {
        System.out.println("-- Running UDP Spy at " + InetAddress.getLocalHost() + ":7078 --");
        String msg;
        while (true) {

            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            udpSocket.receive(packet);
            msg = new String(packet.getData()).trim();
            System.out.println("Spy - "+msg);
        }
    }

    public static void main(String[] args) throws Exception {
        UDPSpy client = new UDPSpy(7078);
        client.listen();
    }

}
