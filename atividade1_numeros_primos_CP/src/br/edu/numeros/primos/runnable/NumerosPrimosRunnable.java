package br.edu.numeros.primos.runnable;

public class NumerosPrimosRunnable implements Runnable {

	private int valorMinimo;
	private int valorMaximo;
	private boolean isPrimo;

	public NumerosPrimosRunnable(int valorMinimo, int valorMaximo) {
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}

	@Override
	public void run() {
		for (int i = valorMinimo; i < valorMaximo; i++) {
			isPrimo = false;
			for (int j = 2; (j * j <= i); j++)
				if (i % j == 0) {
					isPrimo = true;
					break;
				}
			if (!isPrimo)
				System.out.println(i);
		}
	}
}
