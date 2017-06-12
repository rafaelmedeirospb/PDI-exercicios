package treinando;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clienteUDP {

	  public static void main(String[] args) throws IOException {

		      InetAddress addr = InetAddress.getByName("localhost");
		      DatagramSocket socket = new DatagramSocket();
		      int port =6524;
		      
//		      System.out.println("Digite a mensagem :");
//		      Scanner teclado = new Scanner(System.in);
//		      String msgStr = teclado.nextLine();
//		    		  
//		      byte[] msg = msgStr.getBytes();
//		     
//		      DatagramPacket pkg = new DatagramPacket(msg,msg.length, addr, port);
//		   
//		      socket.send(pkg);
//	      
//	   
//	      
//		      	
//		        
//		        DatagramPacket pkg2 = new DatagramPacket(new byte[1024], 1024);     
//		      
//		        socket.receive(pkg2);
//		        String opcoes= new String(pkg2.getData()).trim();
//		        System.out.println(opcoes);
//		      
//		        socket.close(); 
		      
		    //primeira requisição
		  	byte[] requisicao = "quero opcoes".getBytes();
			DatagramPacket request = new DatagramPacket(requisicao, requisicao.length, addr, 6524);
			socket.send(request);

			DatagramPacket dg1 = new DatagramPacket(new byte[1024],1024);
			socket.receive(dg1); //primeira recepção
			
			String opcoes = new String(dg1.getData()).trim();
			System.out.println(opcoes);
			
			//segunda requisição
			System.out.println("Escolha uma opção:");
			Scanner teclado = new Scanner(System.in);
			String opcao = teclado.nextLine();
			
		
			
			byte[] requisicao2 = opcao.getBytes();
			
			DatagramPacket pkg2 =new DatagramPacket(requisicao2,requisicao2.length,request.getAddress(),request.getPort()); 
			
			socket.send(pkg2);
			
			//segunda recepção
			DatagramPacket pk3 = new DatagramPacket(new byte[1024],1024);
			
			socket.receive(pk3);
			
			String resposta = new String(pk3.getData()).trim();
			
			System.out.println(resposta);
			
			int respostaPalindrome = Integer.parseInt(resposta);
			if(respostaPalindrome==1){
				
				System.out.println("Digite uma palavra:");
				
				Scanner teclado1 = new Scanner(System.in);
				String palavra = teclado1.nextLine();
				
				byte[] requisicao3 = palavra.getBytes();
				
				DatagramPacket pkg8 =new DatagramPacket(requisicao3,requisicao3.length,request.getAddress(),request.getPort()); 
				
				socket.send(pkg8);
				
				
				DatagramPacket pkg11 = new DatagramPacket(new byte[1024],1024);
				socket.receive(pkg11);
				
				String respostaPalindromo = new String(pkg11.getData()).trim();
				
				System.out.println(respostaPalindromo);
				
				
			}
			
			
			socket.close();
	   

}
}