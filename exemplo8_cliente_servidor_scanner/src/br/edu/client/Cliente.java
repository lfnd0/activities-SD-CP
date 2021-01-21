package br.edu.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("127.0.0.1", 7000);
			System.out.println("[CLIENTE] ativo");
			System.out.println("[CLIENTE] conectado na porta " + clientSocket.getPort() + " com IP " + clientSocket.getInetAddress());
			
			Scanner scannerOutput = new Scanner(System.in);
			Scanner scannerInput = new Scanner(clientSocket.getInputStream());
			
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
			
			String outputMSG = "";
			do {
				System.out.print("> Cliente: ");
				outputMSG = scannerOutput.nextLine();
				printStream.println(outputMSG);
 				
				System.out.println("> Servidor: " + scannerInput.nextLine());
				
			} while (outputMSG.length() != 0); 
			
			clientSocket.close();
			scannerOutput.close();
			System.out.println("[CLIENTE] desconectado");
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
