package br.edu.runnable.counter.main;

import br.edu.runnable.counter.MyRunnableCounterSync;

public class MainRunnableCounterSync {

	public static void main(String[] args) {
		Thread myRunnableCounterSync1 = new Thread(new MyRunnableCounterSync(true));
		Thread myRunnableCounterSync2 = new Thread(new MyRunnableCounterSync(false));

		myRunnableCounterSync1.start();
		myRunnableCounterSync2.start();

		try {
			myRunnableCounterSync1.join();
			myRunnableCounterSync2.join();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.exit(0);
	}
}