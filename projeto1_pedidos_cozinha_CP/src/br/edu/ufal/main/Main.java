package br.edu.ufal.main;

import java.util.Arrays;
import java.util.List;

import br.edu.ufal.model.Chefe;
import br.edu.ufal.model.Garcom;
import br.edu.ufal.model.ListaPedidos;

public class Main {

	public static void main(String[] args) {
		List<String> garcons = Arrays.asList("Hugo", "Natan", "Willian");
		List<String> chefes = Arrays.asList("Erick Jacquin", "Henrique Fogaca", "Paola Carosella");

		ListaPedidos lista = new ListaPedidos();

		for (String garcon : garcons) {
			new Thread(new Garcom(lista, garcon)).start();
		}

		for (String chefe : chefes) {
			new Thread(new Chefe(lista, chefe)).start();
		}
	}
}
