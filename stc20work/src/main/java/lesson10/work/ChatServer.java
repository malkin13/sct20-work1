package lesson10.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ChatServer extends Thread {

    private static Logger logger = LogManager.getLogger(ChatServer.class);

    public final static int PORT = 7331;
    private final static int BUFFER = 1024;

    private DatagramSocket socket;
    private ArrayList<InetAddress> clientAddresses;
    private ArrayList<Integer> clientPorts;
    private HashSet<String> existingClients;
    public ChatServer() throws IOException {
        socket = new DatagramSocket(PORT);
        clientAddresses = new ArrayList();
        clientPorts = new ArrayList();
        existingClients = new HashSet();
    }

    public void run() {
        byte[] buf = new byte[BUFFER];
        while (true) {
            try {

                Arrays.fill(buf, (byte)0);
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String content = new String(buf, buf.length);

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                String id = clientAddress.toString() + ":" + clientPort;
                if (!existingClients.contains(id)) {
                    existingClients.add( id );
                    clientPorts.add( clientPort );
                    clientAddresses.add(clientAddress);
                }

              //  System.out.println(id + " - " + content.trim());
                String msg = content.trim();
                String name = msg.substring(0, msg.indexOf("-=-"));
                String message = msg.substring(msg.indexOf("-=-")+3);
                logger.info("["+ id.substring(1) + "] Serv - Message from " + name + " - " + message);

                byte[] data = (content).getBytes();
                for (int i=0; i < clientAddresses.size(); i++) {
                    InetAddress cl = clientAddresses.get(i);
                    int cp = clientPorts.get(i);
                    packet = new DatagramPacket(data, data.length, cl, cp);
                    socket.send(packet);
                }
            } catch(Exception e) {
                logger.error(e);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        ChatServer s = new ChatServer();
        s.start();
        logger.info("server started, wait for clients...");
    }



}
