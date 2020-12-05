package br.edu.ufal.main;

import java.util.Arrays;
import java.util.List;

import br.edu.ufal.model.Chef;
import br.edu.ufal.model.Garcon;
import br.edu.ufal.model.ListaPedidos;

public class Main {

	public static void main(String[] args) {
		List<String> garcons = Arrays.asList("Gabriel", "Victor", "Willian");
		List<String> chefs = Arrays.asList("Erick Jacquin", "Henrique Fogaca", "Paola Carosella");

		ListaPedidos listaPedidos = new ListaPedidos();

		for (String garcon : garcons) {
			new Thread(new Garcon(listaPedidos, garcon)).start();
		}

		for (String chef : chefs) {
			new Thread(new Chef(listaPedidos, chef)).start();
		}
	}
}
