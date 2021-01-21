package br.edu.thread.sleep;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 4; i++) {
			long randomSleep = (long) ((Math.random() * 10) + 1) * 1000;
			long start = System.currentTimeMillis();

			Thread.sleep(randomSleep);

			System.out.println("A thread-" + i +" dormiu por: " + (((System.currentTimeMillis() - start) / 1000) % 60) + "s");

		}
	}
}
