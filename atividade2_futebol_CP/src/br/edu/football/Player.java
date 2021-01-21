package br.edu.football;

public class Player implements Runnable {
	Ball ball;
	String playerName;
	boolean match = true;

	public Player(String player, Ball ball) {
		playerName = player;
		this.ball = ball;
	}

	public void playingBall() {
		ball.getBall(playerName);
	}

	public void droppingBall() {
		ball.dropBall();
	}

	@Override
	public void run() {
		try {
			while (match) {
				System.out.println(playerName + " camisa-" + Thread.currentThread().getId() + " disputa a bola");

				playingBall();
				System.out.println(playerName + " camisa-" + Thread.currentThread().getId() + " tem a bola");

				long time = (long) ((Math.random() * 3) + 1) * 1000;
				Thread.sleep(time);
				System.out.println(playerName + " camisa-" + Thread.currentThread().getId() + " esteve "
						+ (time / 1000) % 60 + "s com a bola");

				droppingBall();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
