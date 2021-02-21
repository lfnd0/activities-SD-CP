package br.edu.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	private static final String IP = "127.0.0.1";
	private static final int PORT = 1201;
	private static Socket socket;

	public static void main(String[] args) {
		try {
			socket = new Socket(IP, PORT);
			System.out.println("[CLIENTE] conectado com sucesso na porta: " + PORT);
			System.out.println("[CLIENTE] IP do cliente: " + IP + " conectado");

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			String messageInput = "";
			String messageOutput = "";

			while (!messageInput.equals("!quit")) {
				System.out.print("> Cliente: ");
				messageOutput = bufferedReader.readLine();
				dataOutputStream.writeUTF(messageOutput);

				messageInput = dataInputStream.readUTF();
				System.out.println("> Servidor: " + messageInput);
			}

			socket.close();
			System.out.println("[CLIENTE] desconectado");

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
