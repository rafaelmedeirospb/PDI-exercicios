package treinando;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente extends Thread{

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket socket = new Socket("localhost",6512);

		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
		
		
		while(socket.isConnected()){
			
			
			
			System.out.println("Digite a mensagem:");
			
			Scanner in = new Scanner(System.in);
			String msg = in.nextLine();
			
			saida.writeUTF(msg);
			

			System.out.println("Resposta:"+entrada.readUTF());
		}
	}

}
