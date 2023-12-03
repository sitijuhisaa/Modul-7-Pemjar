package tugas;
import java.net.*;
import java.io.*;

class serverDatagram {
    public static DatagramSocket ds;
    public static int serverport = 9000;

    public static void main(String args[]) throws Exception {
        byte[] buffer = new byte[1024];
        ds = new DatagramSocket(serverport);

        System.out.println("Server berjalan dan menunggu pesan dari client...");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            ds.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            System.out.println("Diterima dari " + clientAddress + ":" + clientPort + ": " + receivedMessage);

            if (receivedMessage.equalsIgnoreCase("end")) {
                System.out.println("Server berhenti...");
                break;
            }
        }
        ds.close();
    }
}
