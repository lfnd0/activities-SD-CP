package br.edu.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.edu.message.Message;
import br.edu.validator.CPF.CPFValidator;

public class Server {

	public static void sendRegistry(String str) {
		try {
			Message message = new Message(str);
			message.setAddress("localhost:8080");
			message.setService("validarCPF");
			Socket socketClient = new Socket("localhost", 8000);

			ObjectOutputStream output1 = new ObjectOutputStream(socketClient.getOutputStream());
			ObjectInputStream input1 = new ObjectInputStream(socketClient.getInputStream());
			output1.writeObject(message);
			output1.flush();
			String strReply = input1.readUTF();

			System.out.println("Mensagem recebida: " + strReply);

			input1.close();
			output1.close();
			socketClient.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ServerSocket serverSocket;

		try {
			sendRegistry("registrar");

			serverSocket = new ServerSocket(8080);
			System.out.println("Servidor conectado com sucesso na porta: " + 8080);

			while (true) {
				System.out.println("Servidor aguardando clientes");
				Socket socketClient = serverSocket.accept();
				System.out.println("Cliente " + socketClient.getInetAddress().getHostAddress() + " conectado");

				ObjectOutputStream output2 = new ObjectOutputStream(socketClient.getOutputStream());
				ObjectInputStream input2 = new ObjectInputStream(socketClient.getInputStream());
				String strCPF = input2.readUTF();

				try {
					if (CPFValidator.isValidCPF(strCPF)) {
						output2.writeUTF("O CPF " + CPFValidator.printCPF(strCPF) + " e valido");
						output2.flush();

						System.out.println("Fim da conexao");

						output2.close();
						input2.close();
						socketClient.close();
					} else {
						output2.writeUTF("O CPF " + CPFValidator.printCPF(strCPF) + " e invalido");
						output2.flush();

						System.out.println("Fim da conexao");

						output2.close();
						input2.close();
						socketClient.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
