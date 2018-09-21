package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;

public class GameController implements Controller {

	Paddle paddle;
	Ball ball;
	Brick brick;
	PApplet display;

	public GameController(Ball ball, Paddle paddle, Brick brick, PApplet display) {
		this.ball = ball;
		this.paddle = paddle;
		this.brick = brick;
		this.display = display;
	}

	public void handleMouseDragEvent(int mouseX) {
		paddle.move(display.width, mouseX);
		checkForColisionBallAndPaddle(ball, paddle);
	}

	@Override
	public void checkForCollisions() {
		checkForCollisionBallAndDisplay(ball, display);
		checkForCollisionBallAndBrick(ball, brick);
		checkForColisionBallAndPaddle(ball, paddle);
	}

	private void checkForCollisionBallAndDisplay(Ball ball, PApplet display) {
		if (ball.getxPos() <= ball.getRadius() || ball.getxPos() > display.width - ball.getWidth()) {

			ball.setVelocityX(ball.getVelocityX() * -1); // Change ball movement direction
		}
		if (ball.getyPos() <= ball.getRadius()) {
			ball.setVelocityY(ball.getVelocityY() * -1); // Change ball movement direction
		}
		// if ball goes below the display height and hasn't hit the paddle - stop the
		// game
		if (ball.getyPos() > display.height) {
			display.noLoop();
		}
	}

	private void checkForCollisionBallAndBrick(Ball ball, Brick brick) {
		float verAx = brick.getCenterX() - brick.getWidth() / 2;
		float verAy = brick.getCenterY() + brick.getHeight() / 2;
		float verBx = brick.getCenterX() + brick.getWidth() / 2;
		float verBy = brick.getCenterY() + brick.getHeight() / 2;
		float verCx = brick.getCenterX() + brick.getWidth() / 2;
		float verCy = brick.getCenterY() - brick.getHeight() / 2;
		float verDx = brick.getCenterX() - brick.getWidth() / 2;
		float verDy = brick.getCenterY() - brick.getHeight() / 2;

		if (Math.pow((ball.getCenterX() - verAx), 2) + Math.pow((ball.getCenterY() - verAy), 2) < Math
				.pow(ball.getRadius(), 2)) {

			if (ball.getVelocityX() > 0 && ball.getVelocityY() < 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
				ball.setVelocityY(ball.getVelocityY() * -1);

			} else if (ball.getVelocityX() > 0 && ball.getVelocityY() > 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
			} else {
				ball.setVelocityY(ball.getVelocityY() * -1);
			}

		} else if (Math.pow((ball.getCenterX() - verBx), 2) + Math.pow((ball.getCenterY() - verBy), 2) < Math
				.pow(ball.getRadius(), 2)) {
			if (ball.getVelocityX() < 0 && ball.getVelocityY() < 0) {

				ball.setVelocityX(ball.getVelocityX() * -1);
				ball.setVelocityY(ball.getVelocityY() * -1);

			} else if (ball.getVelocityX() < 0 && ball.getVelocityY() > 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
			} else {
				ball.setVelocityY(ball.getVelocityY() * -1);
			}

		} else if (Math.pow((ball.getCenterX() - verCx), 2) + Math.pow((ball.getCenterY() - verCy), 2) < Math
				.pow(ball.getRadius(), 2)) {
			if (ball.getVelocityX() < 0 && ball.getVelocityY() > 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
				ball.setVelocityY(ball.getVelocityY() * -1);

			} else if (ball.getVelocityX() < 0 && ball.getVelocityY() < 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
			} else {
				ball.setVelocityY(ball.getVelocityY() * -1);
			}

		} else if (Math.pow((ball.getCenterX() - verDx), 2) + Math.pow((ball.getCenterY() - verDy), 2) < Math
				.pow(ball.getRadius(), 2)) {
			// System.out.println("vertex collision vith vertex D");
			if (ball.getVelocityX() > 0 && ball.getVelocityY() > 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
				ball.setVelocityY(ball.getVelocityY() * -1);

			} else if (ball.getVelocityX() > 0 && ball.getVelocityY() < 0) {
				ball.setVelocityX(ball.getVelocityX() * -1);
			} else {
				ball.setVelocityY(ball.getVelocityY() * -1);
			}

		} else if (ball.getCenterX() >= brick.getCenterX() - brick.getWidth() / 2
				&& ball.getCenterX() <= brick.getCenterX() + brick.getWidth() / 2) {
			if (Math.abs(ball.getCenterY() - brick.getCenterY()) <= ball.getHeight() / 2 + brick.getHeight() / 2) {
				ball.setVelocityY(ball.getVelocityY() * -1);
				// brick.setVisible(false);
			}
		} else if (ball.getCenterY() >= brick.getCenterY() - brick.getHeight() / 2
				&& ball.getCenterY() <= brick.getCenterY() + brick.getHeight() / 2) {
			if (Math.abs(ball.getCenterX() - brick.getCenterX()) <= ball.getWidth() / 2 + brick.getWidth() / 2) {

				ball.setVelocityX(ball.getVelocityX() * -1);
				// brick.setVisible(false);
			}

		}

	}

	private void checkForColisionBallAndPaddle(Ball ball, Paddle paddle) {
		float verCx = paddle.getCenterX() + paddle.getWidth() / 2;
		float verCy = paddle.getCenterY() - paddle.getHeight() / 2;
		float verDx = paddle.getCenterX() - paddle.getWidth() / 2;
		float verDy = paddle.getCenterY() - paddle.getHeight() / 2;

		if (Math.pow((ball.getCenterX() - verCx), 2) + Math.pow((ball.getCenterY() - verCy), 2) < Math
				.pow(ball.getRadius(), 2)) {
			if (ball.getVelocityX() < 0 && ball.getVelocityY() > 0) {

				ball.setVelocityX(ball.getVelocityX() * -1);
				ball.setVelocityY(ball.getVelocityY() * -1);

			} else if (ball.getVelocityX() > 0 && ball.getVelocityY() > 0) {
				ball.setVelocityY(ball.getVelocityY() * -1);
			}
		} else if (Math.pow((ball.getCenterX() - verDx), 2) + Math.pow((ball.getCenterY() - verDy), 2) < Math
				.pow(ball.getRadius(), 2)) {

			if (ball.getVelocityX() > 0 && ball.getVelocityY() > 0) {

				ball.setVelocityX(ball.getVelocityX() * -1);
				ball.setVelocityY(ball.getVelocityY() * -1);

			} else if (ball.getVelocityX() < 0 && ball.getVelocityY() > 0) {
				ball.setVelocityY(ball.getVelocityY() * -1);
			}
		} else if (ball.getCenterX() >= paddle.getCenterX() - paddle.getWidth() / 2
				&& ball.getCenterX() <= paddle.getCenterX() + paddle.getWidth() / 2) {
			if (Math.abs(ball.getCenterY() - paddle.getCenterY()) <= ball.getHeight() / 2 + paddle.getHeight() / 2) {
				ball.setVelocityY(ball.getVelocityY() * -1);

			}
		} else if (ball.getCenterY() >= paddle.getCenterY() - paddle.getHeight() / 2
				&& ball.getCenterY() <= paddle.getCenterY() + paddle.getHeight() / 2) {
			if (Math.abs(ball.getCenterX() - paddle.getCenterX()) <= ball.getWidth() / 2 + paddle.getWidth() / 2) {

				ball.setVelocityX(ball.getVelocityX() * -1);

			}
		}
	}
}
