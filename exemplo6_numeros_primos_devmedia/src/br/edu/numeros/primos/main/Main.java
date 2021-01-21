package br.edu.numeros.primos.main;

import java.util.ArrayList;
import java.util.Collection;

import br.edu.numeros.primos.NumerosPrimos;

public class Main {

	public static void main(String[] args) {
		// Armazena o tempo inicial
		long ti = System.currentTimeMillis();

		// Armazena a quantidade de núcleos de processamento disponíveis
		int numThreads = Runtime.getRuntime().availableProcessors();

		// Intervalo de busca predeterminado
		int valorInicial = 2;
		int valorFinal = 1000000;

		// Lista para armazenar os numeros primos encontrados pelas threads
		Collection<Long> primos = new ArrayList<>();

		// Lista de threads
		Collection<Thread> threads = new ArrayList<>();

		int trabalho = valorFinal / valorInicial;

		// Cria threads conforme a quantidade de núcleos
		for (int i = 1; i <= numThreads; i++) {

			// O atributo 'trab' é a quantidade de valores que cada thread irá calcular
			int trab = Math.round(trabalho / numThreads);

			// Calcula o valor inicial e final do intervalo de cada thread
			int fim = trab * i;
			int ini = (fim - trab) + 1;

			// Cria a thread passando como parâmetro um objeto da classe 'NumerosPrimos'
			Thread thread = new Thread(new NumerosPrimos(ini, fim, primos));

			// Define um nome para a thread
			thread.setName("Thread-" + i);
			threads.add(thread);
		}

		// Percorre as threads criadas iniciando-as
		for (Thread th : threads) {
			th.start();
		}

		// Aguarda todas as threads finalizarem o processamento
		for (Thread th : threads) {
			try {
				th.join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		// Imprime os números primos encontrados por todas as threads
		for (Long primo : primos) {
			System.out.println(primo);
		}

		// Calcula e imprime o tempo total gasto
		System.out.println("Tempo = " + (System.currentTimeMillis() - ti));
	}
}
