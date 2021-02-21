package br.edu.numeros.primos;

import java.util.Collection;

public class NumerosPrimos implements Runnable {

	private final int valorInicial;
	private final int valorFinal;
	private final Collection<Long> primos;

	public NumerosPrimos(int valorInicial, int valorFinal, Collection<Long> primos) {
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.primos = primos;
	}

	@Override
	public void run() {
		for (long ate = valorInicial; ate <= valorFinal; ate++) {
			int primo = 0;
			for (int i = 2; i < ate; i++) {
				if ((ate % i) == 0) {
					primo++;
					break;
				}
			}
			if (primo == 0) {
				synchronized (primos) {
					primos.add(ate);
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " terminou!");
	}
}
