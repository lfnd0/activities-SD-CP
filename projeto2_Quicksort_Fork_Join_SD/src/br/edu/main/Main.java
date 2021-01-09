package br.edu.main;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import br.edu.algoritmo.QuicksortRecursiveAction;

public class Main {

	public static void main(String[] args) {

		int[] lista = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
		System.out.println("Lista desordenada = " + Arrays.toString(lista));

		QuicksortRecursiveAction quicksort = new QuicksortRecursiveAction(lista);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(quicksort);

		pool.shutdown();

		System.out.println("Lista ordenada = " + Arrays.toString(lista));
	}
}