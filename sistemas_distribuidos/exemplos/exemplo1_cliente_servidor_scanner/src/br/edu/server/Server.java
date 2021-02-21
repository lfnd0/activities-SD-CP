package br.edu.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		Scanner scannerOutput = new Scanner(System.in);
		Scanner scannerInput;

		try {
			ServerSocket serverSocket = new ServerSocket(7000);
			System.out.println("[SERVIDOR] ativo");
			
			Socket clientSocket = serverSocket.accept();
			System.out.println("[SERVIDOR] cliente " + clientSocket.getInetAddress() + " conectado");
			
			scannerInput = new Scanner(clientSocket.getInputStream());
			PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
			
			while(scannerInput.hasNextLine()) {
				System.out.println("> Cliente: " + scannerInput.nextLine());
				System.out.print("> Servidor: ");
				String outputMSG = scannerOutput.nextLine();
				printStream.println(outputMSG);
			}
			
			clientSocket.close();
			serverSocket.close();
			scannerOutput.close();
			
			System.out.println("[SERVIDOR] desconectado");
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
