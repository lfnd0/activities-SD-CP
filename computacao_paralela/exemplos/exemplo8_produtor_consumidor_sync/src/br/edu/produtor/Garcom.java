package br.edu.produtor;

import br.edu.consumidor.Restaurante;

public class Garcom extends Thread {

	private Restaurante restaurante;

	public Garcom(Restaurante r) {
		restaurante = r;
		start();
	}

	@Override
	public void run() {
		while (true) {
			while (restaurante.pedido == null) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				System.out.println("O garcom recebeu o pedido: " + restaurante.pedido);
				restaurante.pedido = null;
			}
		}
	}
}
