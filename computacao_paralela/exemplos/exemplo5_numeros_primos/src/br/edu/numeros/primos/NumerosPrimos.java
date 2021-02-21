package br.edu.numeros.primos;

public class NumerosPrimos {

	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		boolean flag;

		System.out.println("Números primos:");
		System.out.println("2");

		for (int i = 3; i < 1000000; i++) {
			flag = false;
			for (int j = 2; (j * j <= i); j++)
				if (i % j == 0) {
					flag = true;
					break;
				}
			if (!flag)
				System.out.println(i);
		}

		System.out.println("Tempo = " + (System.currentTimeMillis() - t) + "ms");
	}
}
