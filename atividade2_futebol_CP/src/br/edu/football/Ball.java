package br.edu.football;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ball extends Thread {
	Lock lock = new ReentrantLock();
	String playerName = "";

	public void getBall(String player) {
		playerName = player;
		lock.lock();
	}

	public void dropBall() {
		playerName = "";
		lock.unlock();
	}
}
