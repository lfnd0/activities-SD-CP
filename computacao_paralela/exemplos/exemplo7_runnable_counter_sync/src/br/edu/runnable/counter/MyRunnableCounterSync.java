package br.edu.runnable.counter;

public class MyRunnableCounterSync implements Runnable {
	private boolean ordem = true;

	public MyRunnableCounterSync(boolean ordem) {
		this.ordem = ordem;
	}

	@Override
	public void run() {
		try {
			if (ordem) {
				for (int i = 0; i <= 1000; i++) {
					System.out.println("ID: " + Thread.currentThread().getId() + " - Nome: "
							+ Thread.currentThread().getName() + " - Contagem crescente: " + i);
					Thread.sleep(2000);
				}
			} else {
				for (int i = 1000; i >= 0; i--) {
					System.out.println("ID: " + Thread.currentThread().getId() + " - Nome: "
							+ Thread.currentThread().getName() + " - Contagem decrescente: " + i);
					Thread.sleep(4000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}