package br.edu.runnable;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("ID: " + Thread.currentThread().getId() + "\n" + "Nome: " + Thread.currentThread().getName()
				+ "\n" + "Prioridade: " + Thread.currentThread().getPriority() + "\n" + "Estado: "
				+ Thread.currentThread().getState());
	}
}
