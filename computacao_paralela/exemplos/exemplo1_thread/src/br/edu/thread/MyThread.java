package br.edu.thread;

public class MyThread extends Thread {

	public void run() {
		System.out.println("ID: " + Thread.currentThread().getId());
		System.out.println("Nome: " + Thread.currentThread().getName());
		System.out.println("Prioridade: " + Thread.currentThread().getPriority());
		System.out.println("Estado: " + Thread.currentThread().getState());
	}
}
