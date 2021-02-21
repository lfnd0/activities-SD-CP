package br.edu.produtor;

import br.edu.consumidor.Pedido;
import br.edu.consumidor.Restaurante;

public class Chefe extends Thread {

	private Restaurante restaurante;
	private Garcom garcom;

	public Chefe(Restaurante r, Garcom g) {
		restaurante = r;
		garcom = g;
		start();
	}

	@Override
	public void run() {
		while (true) {
			if (restaurante.pedido == null) {
				restaurante.pedido = new Pedido();
				System.out.print("O chefe entregou o pedido: " + restaurante.pedido);
				synchronized (garcom) {
					garcom.notify();
				}
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
