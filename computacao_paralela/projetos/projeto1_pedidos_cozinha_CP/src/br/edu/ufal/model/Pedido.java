package br.edu.ufal.model;

import java.util.Arrays;
import java.util.List;

public class Pedido {
	static int sequence = 1;
	int id;
	String prato;
	List<String> cardapio = Arrays.asList("Ravioli", "Canape", "Filet mignon", "Crepe", "Panacotta", "Mousse", "Vieira",
			"Empanada", "Spaguetti");

	private void nomearPrato() {
		int n = (int) (Math.random() * cardapio.size());
		this.prato = cardapio.get(n);
	}

	public Pedido() {
		nomearPrato();
		this.id = sequence++;
	}

	public String getPrato() {
		return prato;
	}

	public void setPrato(String prato) {
		this.prato = prato;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "(N. " + this.id + "; " + this.prato + ")";
	}
}
