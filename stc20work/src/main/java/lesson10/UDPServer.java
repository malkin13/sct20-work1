package lesson10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {


    public static void main(String[] args) {
        try {
            byte[] data = "hello".getBytes();
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            DatagramPacket pack = new DatagramPacket(data, data.length, addr, 6226);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public void main() {

    }
}
