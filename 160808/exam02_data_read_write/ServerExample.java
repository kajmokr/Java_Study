package chap18.sec07.exam02_data_read_write;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();		
			serverSocket.bind(new InetSocketAddress("172.17.80.151", 5001));
			while(true) {
				System.out.println( "[���� ��ٸ�]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[���� ������] " + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				//InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				/*bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");*/
				System.out.println("[������ �ޱ� ����]: " + dis.readUTF());
				//System.out.println("[������ �ޱ� ����]: " + message);
				
				//OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				message = "hello";
				dos.writeUTF(message);
/*				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
*/			
				dos.flush();
				System.out.println( "[������ ������ ����]");
								
				dis.close();
				dos.close();
				//is.close();
				//os.close();
				socket.close();
			}
		} catch(Exception e) {}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
}
