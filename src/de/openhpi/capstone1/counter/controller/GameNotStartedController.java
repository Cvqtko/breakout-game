package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.Counter;
import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;

public class GameNotStartedController implements Controller {

	Paddle paddle;
	Ball ball;
	Brick[] bricks;
	PApplet display;
	Counter counter;
	long collisionWithPaddleDetected;

	public GameNotStartedController(Ball ball, Paddle paddle, Brick[] bricks, Counter counter, PApplet display) {
		this.ball = ball;
		this.paddle = paddle;
		this.bricks = bricks;
		this.display = display;
		this.counter = counter;
		collisionWithPaddleDetected = 0;
	}

	public void handleMouseDragEvent(int mouseX) {
		paddle.move(display.width, mouseX);
		ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
		ball.setyPos(paddle.getyPos() - ball.getHeight());

	}

	@Override
	public void handleKetPressedEvent(int keyCode) {
		if (keyCode == 32) {
			ball.setVelocityX(1);
			ball.setVelocityY(-1);
		} else if (keyCode == 37) {
			paddle.moveLeft();
			ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
			ball.setyPos(paddle.getyPos() - ball.getHeight());
		} else if (keyCode == 39) {
			paddle.moveRight(display.width);
			ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
			ball.setyPos(paddle.getyPos() - ball.getHeight());
		}

	}

	@Override
	public void checkForCollisions() {

	}
}
