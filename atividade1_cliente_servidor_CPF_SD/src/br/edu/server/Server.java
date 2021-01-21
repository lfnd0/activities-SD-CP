package br.edu.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.edu.validator.CPF.CPFValidator;

public class Server {

	private static final int PORT = 8000;
	private static ServerSocket serverSocket;
	private static Socket socket;

	public static void main(String[] args) throws IOException {
		serverSocket = new ServerSocket(PORT);
		System.out.println("[SERVIDOR] conectado com sucesso na porta: " + PORT);

		socket = serverSocket.accept();
		System.out.println("[SERVIDOR] IP do cliente: " + socket.getInetAddress().getHostAddress() + " conectado");

		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

		String messageInput = "";
		String messageOutput = "";

		while (!messageInput.equals("!quit")) {
			messageInput = dataInputStream.readUTF();

			System.out.println("\n> [SERVIDOR] verificando dados: " + messageInput);

			if (CPFValidator.isValidCPF(messageInput)) {
				messageOutput = "VALIDO";
			} else {
				messageOutput = "INVALIDO";
			}

			dataOutputStream.writeUTF(messageOutput);
		}

		socket.close();
		System.out.println("\n![SERVIDOR] Desconectado");
	}
}
