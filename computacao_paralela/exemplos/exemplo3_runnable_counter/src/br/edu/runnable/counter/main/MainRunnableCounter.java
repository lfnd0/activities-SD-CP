package br.edu.runnable.counter.main;

import br.edu.runnable.counter.MyRunnableCounter;

public class MainRunnableCounter {

	public static void main(String[] args) {
		Thread myRunnableCounter1 = new Thread(new MyRunnableCounter(true));
		Thread myRunnableCounter2 = new Thread(new MyRunnableCounter(false));

		myRunnableCounter1.start();
		myRunnableCounter2.start();
	}
}
