package treinando;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Calendar;
import java.util.Random;

public class servidorUDP {
	
		public static String autoAjuda() {
			Random r = new Random();
			String[] apoios = {"Tudo irá melhorar", "Relaxe", "não se preocupe", "poderia ter sido pior"};
	
			int index = r.nextInt(apoios.length);
			
			return apoios[index];
		}
		
		public static String isPalindromo(String palavra) {
			String normal = palavra;
			String invertida = new StringBuffer(normal).reverse().toString();
			if (normal.equals(invertida)) {
				return "Palindrome"; 
			} else {
				return "Não é um palindrome";
			}	
		}
		
		public static String horas(){
			Calendar calendar = Calendar.getInstance();
			String horas= String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
			String minutos = String.valueOf(calendar.get(Calendar.MINUTE));
			
			return  horas + ":" + minutos;
		}

	  public static void main(String[] args) throws IOException {
	     
	        DatagramSocket socket = new DatagramSocket(6524);     
	     
	  
	        
	        do{
	        //primeira recepção
	        byte[] msg = new byte[1024];
	        DatagramPacket pkg = new DatagramPacket(msg, msg.length);     
	      
	        socket.receive(pkg);
	
	        
	        	//primeira resposta
	        String opcoesStr = "#########Escolha uma opção#########\n 1- Mensagem de Autoajuda \n2-Identificar palíndromo\n3-Informar hora e data";
	        byte[] opcoes = opcoesStr.getBytes();
	        	
	        	DatagramPacket pkg2 = new DatagramPacket(opcoes,opcoes.length,pkg.getAddress(),pkg.getPort());
	        	
	        	socket.send(pkg2);	
	        	
	        //segunda recepção
	        byte[] msg2 = new byte[1024];
	        
	        DatagramPacket pkg3 = new DatagramPacket(msg2,msg2.length);
	        
	        socket.receive(pkg3);
	        
	        String OpcaoEscolhida = new String(pkg3.getData()).trim();
	        int escolha = Integer.parseInt(OpcaoEscolhida);
	        
	        //segunda resposta
	        switch (escolha) {
	        case 1:
	        	String resp1 = autoAjuda();
	        	
	        	DatagramPacket pk5 = new DatagramPacket(resp1.getBytes(),resp1.getBytes().length,pkg.getAddress(),pkg.getPort());
	        	socket.send(pk5);
	            break;
	        case 2:
	        	
	        	String resp2 = "1";
	        	
	        	DatagramPacket pk6 = new DatagramPacket(resp2.getBytes(),resp2.getBytes().length,pkg.getAddress(),pkg.getPort());
	        	socket.send(pk6);
	            break;
	        case 3:
	        	String resp3 = horas();
	        	
	        	DatagramPacket pk7 = new DatagramPacket(resp3.getBytes(),resp3.getBytes().length,pkg.getAddress(),pkg.getPort());
	        	socket.send(pk7);
	            break;
	        }
	        
	        
	        //terceira recepção
	        byte[] msg4 = new byte[1024];
	        
	        DatagramPacket pkg9 = new DatagramPacket(msg4,msg4.length);
	        
	        socket.receive(pkg9);
	        
	        
	        //terceira resposta
	        String resp = isPalindromo(new String(pkg9.getData()).trim());
        	byte[] msg7 = resp.getBytes();
        	
        	DatagramPacket pkg10 = new DatagramPacket(msg7,msg7.length,pkg9.getAddress(),pkg9.getPort());
        	
        	socket.send(pkg10);
	        
	        }while(socket.getInetAddress()!= null);
	    
	        socket.close();    
	  }
}
		  


