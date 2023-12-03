package tugas;
import java.net.*;
import java.io.*;

class ClientDatagram {
    public static DatagramSocket d;
    public static byte[] buffer = new byte[1024];
    public static int serverport = 9000;

    public static void main(String args[]) throws Exception {
        d = new DatagramSocket();

        // Alamat IP server
        InetAddress serverAddress = InetAddress.getByName("localhost"); // Gantilah dengan alamat IP komputer server

        System.out.println("Client sedang berjalan...");
        System.out.println("Ketik 'end' untuk mengakhiri");

        while (true) {
            // Baca pesan dari console
            BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Client: ");
            String sendMessage = dis.readLine();

            // Kirim pesan ke server
            byte[] sendBuffer = sendMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverport);
            d.send(sendPacket);

            if (sendMessage.equalsIgnoreCase("end")) {
                System.out.println("Client berhenti...");
                break;
            }
        }
        d.close();
    }
}
