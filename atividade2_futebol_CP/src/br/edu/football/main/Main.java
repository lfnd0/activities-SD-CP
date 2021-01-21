package br.edu.football.main;

import java.util.Arrays;
import java.util.List;

import br.edu.football.Ball;
import br.edu.football.Player;

public class Main {

	public static void main(String[] args) {
		List<String> playersName = Arrays.asList("Adriano", "Brendo", "Carlos", "Daniel", "Elias", "Felipe", "Gustavo",
				"Heitor", "Ivo", "Juan");

		Ball brazuca = new Ball();

		for (String player : playersName) {
			new Thread(new Player(player, brazuca)).start();
		}
	}
}
