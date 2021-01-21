package br.edu.runnable.counter;

public class MyRunnableCounter implements Runnable {
	private boolean ordem = true;

	public MyRunnableCounter(boolean ordem) {
		this.ordem = ordem;
	}

	@Override
	public void run() {
		if (ordem) {
			for (int i = 0; i <= 1000; i++) {
				System.out.println("ID: " + Thread.currentThread().getId() + " - Nome: "
						+ Thread.currentThread().getName() + " - Contagem crescente: " + i);
			}
		} else {
			for (int i = 1000; i >= 0; i--) {
				System.out.println("ID: " + Thread.currentThread().getId() + " - Nome: "
						+ Thread.currentThread().getName() + " - Contagem decrescente: " + i);
			}

		}
	}
}
