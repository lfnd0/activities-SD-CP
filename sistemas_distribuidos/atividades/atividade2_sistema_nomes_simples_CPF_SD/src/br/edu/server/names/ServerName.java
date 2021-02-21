package br.edu.server.names;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import br.edu.message.Message;

public class ServerName {

	public static void main(String[] args) {

		ServerSocket serverSocket;
		Message message;
		Map<String, String> dataset = new HashMap<String, String>();

		try {
			serverSocket = new ServerSocket(8000);
			System.out.println("Servico ativo na porta: " + 8000);

			while (true) {
				System.out.println("Aguardando conexao de novo cliente");

				Socket socketClient = serverSocket.accept();
				System.out.println("Cliente " + socketClient.getInetAddress().getHostAddress() + " conectado");

				ObjectOutputStream output = new ObjectOutputStream(socketClient.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(socketClient.getInputStream());
				message = (Message) input.readObject();

				switch (message.getOperation()) {
					case "lookup": {
						System.out.println("Dados enviados referente: " + message.getService());
						output.writeUTF(dataset.get(message.getService()));
						output.flush();
						output.close();
						input.close();
						socketClient.close();
						break;
					}
					case "registrar": {
						dataset.put(message.getService(), message.getAddress());
						System.out.println("Registro realizado com sucesso");
						output.writeUTF("Registro realizado com sucesso");
						output.flush();
						output.close();
						input.close();
						socketClient.close();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
