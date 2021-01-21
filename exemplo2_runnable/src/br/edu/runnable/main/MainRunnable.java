package br.edu.runnable.main;

import br.edu.runnable.MyRunnable;

public class MainRunnable {

	public static void main(String[] args) {
		Thread myRunnable1 = new Thread(new MyRunnable());
		Thread myRunnable2 = new Thread(new MyRunnable());

		myRunnable1.start();
		myRunnable2.start();
	}
}
