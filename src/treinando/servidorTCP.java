package treinando;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class servidor extends Thread{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket servidor = new ServerSocket(6512);
		Socket cliente = servidor.accept();
		
		
		DataInputStream entrada = new DataInputStream(cliente.getInputStream());
		DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
		
		String response= "";
		
		while(entrada!=null){
		
		response = entrada.readUTF();
		
		
		
		System.out.println("Digite a mensagem: ");
		
		Scanner teclado = new Scanner(System.in);
		String msg = teclado.nextLine();
		
		saida.writeUTF(msg);

			
		}
		
		cliente.close();
		
		servidor.close();
		
	}

}
