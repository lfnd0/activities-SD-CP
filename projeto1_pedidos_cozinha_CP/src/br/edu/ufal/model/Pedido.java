package br.edu.ufal.model;

import java.util.Arrays;
import java.util.List;

public class Pedido {
	static int sequence = 1;
	int id;
	String nome;
	List<String> cardapio = Arrays.asList("Ravioli", "Canape", "Filet mignon", "Crepe", "Panacotta", "Mousse", "Vieira",
			"Empanada", "Spaguetti");

	private void darNome() {
		int n = (int) (Math.random() * cardapio.size());
		this.nome = cardapio.get(n);
	}

	public Pedido() {
		darNome();
		this.id = sequence++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "(Pedido: " + this.id + "; Nome: " + this.nome + ")";
	}
}
