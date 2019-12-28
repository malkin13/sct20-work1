package lesson10.work.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MessageReceiver implements Runnable {

    DatagramSocket sock;
    byte buf[];

    MessageReceiver(DatagramSocket s) {
        sock = s;
        buf = new byte[1024];
    }

    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                sock.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                String msg = received.trim();
                String name = msg.substring(0, msg.indexOf("-=-"));
                String message = msg.substring(msg.indexOf("-=-")+3);
                System.out.println("Client - Message from " + name + " : " + message);

               // System.out.println(received.trim());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
