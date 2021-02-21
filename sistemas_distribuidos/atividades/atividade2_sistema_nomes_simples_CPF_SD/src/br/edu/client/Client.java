package br.edu.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.edu.message.Message;

public class Client {

	public static String lookup(String str) {
		String address1 = "";
		Message message = new Message(str);
		message.setService("validarCPF");

		try {
			Socket socketClient1 = new Socket("localhost", 8000);

			ObjectOutputStream output1 = new ObjectOutputStream(socketClient1.getOutputStream());
			ObjectInputStream input1 = new ObjectInputStream(socketClient1.getInputStream());
			output1.writeObject(message);
			output1.flush();
			String strReply = input1.readUTF();
			address1 = strReply;

			System.out.println("Mensagem recebida: " + strReply);

			input1.close();
			output1.close();
			socketClient1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return address1;
	}

	public static void main(String[] args) {
		String address2 = lookup("lookup");
		String[] strs = address2.split("\\:");
		String address3 = strs[0];
		int port = Integer.parseInt(strs[1]);

		try {
			Socket socketClient2 = new Socket(address3, port);

			ObjectOutputStream output2 = new ObjectOutputStream(socketClient2.getOutputStream());
			ObjectInputStream input2 = new ObjectInputStream(socketClient2.getInputStream());

			/* Para consultar um novo CPF, basta alterar esta string com o CPF de sua preferência. */
			String str = "00000000000";

			output2.writeUTF(str);
			output2.flush();
			String strReply = input2.readUTF();

			System.out.println("Mensagem recebida: " + strReply);
			input2.close();
			output2.close();
			socketClient2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
