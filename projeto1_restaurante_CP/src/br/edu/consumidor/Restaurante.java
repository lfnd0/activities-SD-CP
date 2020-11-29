package br.edu.consumidor;

import br.edu.produtor.Chefe;
import br.edu.produtor.Garcom;

public class Restaurante {

	public Pedido pedido;

	public Restaurante() {
		pedido = null;
	}

	public static void main(String[] args) {
		Restaurante r = new Restaurante();
		Garcom g = new Garcom(r);
		Chefe c = new Chefe(r, g);
	}
}
