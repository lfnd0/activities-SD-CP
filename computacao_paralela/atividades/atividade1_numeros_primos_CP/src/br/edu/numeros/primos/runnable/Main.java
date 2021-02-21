package br.edu.numeros.primos.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		NumerosPrimosRunnable numerosPrimosThread0 = new NumerosPrimosRunnable(2, 100000);
		NumerosPrimosRunnable numerosPrimosThread1 = new NumerosPrimosRunnable(100001, 200000);
		NumerosPrimosRunnable numerosPrimosThread2 = new NumerosPrimosRunnable(200001, 300000);
		NumerosPrimosRunnable numerosPrimosThread3 = new NumerosPrimosRunnable(300001, 400000);
		NumerosPrimosRunnable numerosPrimosThread4 = new NumerosPrimosRunnable(4000001, 500000);
		NumerosPrimosRunnable numerosPrimosThread5 = new NumerosPrimosRunnable(500001, 600000);
		NumerosPrimosRunnable numerosPrimosThread6 = new NumerosPrimosRunnable(600001, 700000);
		NumerosPrimosRunnable numerosPrimosThread7 = new NumerosPrimosRunnable(700001, 800001);
		NumerosPrimosRunnable numerosPrimosThread8 = new NumerosPrimosRunnable(800001, 900000);
		NumerosPrimosRunnable numerosPrimosThread9 = new NumerosPrimosRunnable(900001, 1000000);

		long tempoInicial = System.currentTimeMillis();
		
		ExecutorService threadExecutorService = Executors.newFixedThreadPool(10);
		
		System.out.println("Números primos:");
		
		threadExecutorService.execute(numerosPrimosThread0);
		threadExecutorService.execute(numerosPrimosThread1);
		threadExecutorService.execute(numerosPrimosThread2);
		threadExecutorService.execute(numerosPrimosThread3);
		threadExecutorService.execute(numerosPrimosThread4);
		threadExecutorService.execute(numerosPrimosThread5);
		threadExecutorService.execute(numerosPrimosThread6);
		threadExecutorService.execute(numerosPrimosThread7);
		threadExecutorService.execute(numerosPrimosThread8);
		threadExecutorService.execute(numerosPrimosThread9);

		threadExecutorService.shutdown();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Tempo = " + (System.currentTimeMillis() - tempoInicial) + "ms");
		}));
	}
}
