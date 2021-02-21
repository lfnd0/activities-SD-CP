package br.edu.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	private static final String IP = "127.0.0.1";
	private static final int PORT = 8000;
	private static Socket socket;

	public static void main(String[] args) throws IOException {
		socket = new Socket(IP, PORT);
		System.out.println("[CLIENTE] conectado com sucesso na porta: " + PORT);
		System.out.println("[CLIENTE] IP do cliente conectado: " + IP);

		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String messageInput = "";
		String messageOutput = "";

		while (!messageOutput.equals("!quit")) {
			System.out.print("\n> [CLIENTE] Entre com o CPF (Somente numeros. Para sair digite !quit): ");

			messageOutput = bufferedReader.readLine();
			dataOutputStream.writeUTF(messageOutput);

			if (!messageOutput.equals("!quit")) {
				messageInput = dataInputStream.readUTF();
				System.out.println("\n> [SERVIDOR] Status do CPF: " + messageInput);
			} else {
				System.out.println("\n![CLIENTE] Desconectado");
				socket.close();
			}
		}
	}
}
