package br.edu.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static final int PORT = 1201;
	private static ServerSocket serverSocket;
	private static Socket socket;

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("[SERVIDOR] conectado com sucesso na porta: " + PORT);

			socket = serverSocket.accept();
			System.out.println("[SERVIDOR] IP do cliente: " + socket.getInetAddress().getHostAddress() + " conectado");

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			String messageInput = "";
			String messageOutput = "";

			while (!messageOutput.equals("!quit")) {
				messageInput = dataInputStream.readUTF();
				System.out.println("> Cliente: " + messageInput);

				System.out.print("> Servidor: ");
				messageOutput = bufferedReader.readLine();
				dataOutputStream.writeUTF(messageOutput);
				dataOutputStream.flush();
			}

			socket.close();
			System.out.println("[SERVIDOR] desconectado");

		} catch (Exception e) {
			System.out.print("Error: " + e);
		}
	}
}
