package de.openhpi.capstone1.counter.model;

import processing.core.PApplet;

public class Ball extends AbstractGameComponent {

	private int velocityX = 10;
	private int velocityY = 10;
	public int radius;

	public Ball(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible);
		this.radius = width / 2;

	}

	public void move() {
		this.setxPos(this.getxPos() + this.velocityX);
		this.setyPos(this.getyPos() + this.velocityY);
		this.setCenterX(this.getxPos());
		this.setCenterY(this.getyPos());
	}

	public void checkForCollisionWithDisplay(PApplet display) {
		if (this.getxPos() <= this.radius || this.getxPos() > display.width - this.getWidth()) {
			velocityX *= -1; // Change ball movement direction
		}
		if (this.getyPos() <= radius) {
			velocityY *= -1; // Change ball movement direction
		}
		// if ball goes below the display height and hasn't hit the paddle - stop the
		// game
		if (this.getyPos() > display.height - this.getHeight()) {
			display.noLoop();
			// velocityY *= -1;
		}
	}

	public void checkForCollisionWithPaddle(Paddle paddle) {
		float verCx = paddle.getCenterX() + paddle.getWidth() / 2;
		float verCy = paddle.getCenterY() - paddle.getHeight() / 2;
		float verDx = paddle.getCenterX() - paddle.getWidth() / 2;
		float verDy = paddle.getCenterY() - paddle.getHeight() / 2;

		if (this.getCenterX() >= paddle.getCenterX() - paddle.getWidth() / 2
				&& this.getCenterX() <= paddle.getCenterX() + paddle.getWidth() / 2) {
			if (Math.abs(this.getCenterY() - paddle.getCenterY()) <= this.getHeight() / 2 + paddle.getHeight() / 2) {
				velocityY *= -1;
				// brick.setVisible(false);
			}
		} else if (Math.pow((this.getCenterX() - verCx), 2) + Math.pow((this.getCenterY() - verCy), 2) < Math
				.pow(this.radius, 2)) {
			// System.out.println("Paddle vertex collision vith vertex C");
			if (velocityX < 0 && velocityY > 0) {
				velocityX *= -1;
				velocityY *= -1;
			} else if (velocityX > 0 && velocityY > 0) {
				velocityY *= -1;
			}
		} else if (Math.pow((this.getCenterX() - verDx), 2) + Math.pow((this.getCenterY() - verDy), 2) < Math
				.pow(this.radius, 2)) {
			// System.out.println("Paddle vertex collision vith vertex D");
			if (velocityX > 0 && velocityY > 0) {
				velocityX *= -1;
				velocityY *= -1;
			} else if (velocityX < 0 && velocityY > 0) {
				velocityY *= -1;
			}

		}

	}

	public void checkForCollisionWithBrick(Brick brick) {

		float verAx = brick.getCenterX() - brick.getWidth() / 2;
		float verAy = brick.getCenterY() + brick.getHeight() / 2;
		float verBx = brick.getCenterX() + brick.getWidth() / 2;
		float verBy = brick.getCenterY() + brick.getHeight() / 2;
		float verCx = brick.getCenterX() + brick.getWidth() / 2;
		float verCy = brick.getCenterY() - brick.getHeight() / 2;
		float verDx = brick.getCenterX() - brick.getWidth() / 2;
		float verDy = brick.getCenterY() - brick.getHeight() / 2;

		if (Math.pow((this.getCenterX() - verAx), 2) + Math.pow((this.getCenterY() - verAy), 2) < Math.pow(this.radius,
				2)) {
			// System.out.println("vertex collision vith vertex A");
			if (velocityX > 0 && velocityY < 0) {
				velocityX *= -1;
				velocityY *= -1;
			} else if (velocityX > 0 && velocityY > 0) {
				velocityX *= -1;
			} else {
				velocityY *= -1;
			}

		} else if (Math.pow((this.getCenterX() - verBx), 2) + Math.pow((this.getCenterY() - verBy), 2) < Math
				.pow(this.radius, 2)) {
			// System.out.println("vertex collision vith vertex B");
			if (velocityX < 0 && velocityY < 0) {
				velocityX *= -1;
				velocityY *= -1;
			} else if (velocityX < 0 && velocityY > 0) {
				velocityX *= -1;
			} else {
				velocityY *= -1;
			}

		} else if (Math.pow((this.getCenterX() - verCx), 2) + Math.pow((this.getCenterY() - verCy), 2) < Math
				.pow(this.radius, 2)) {
			// System.out.println("vertex collision vith vertex C");
			if (velocityX < 0 && velocityY > 0) {
				velocityX *= -1;
				velocityY *= -1;
			} else if (velocityX < 0 && velocityY < 0) {
				velocityX *= -1;
			} else {
				velocityY *= -1;
			}

		} else if (Math.pow((this.getCenterX() - verDx), 2) + Math.pow((this.getCenterY() - verDy), 2) < Math
				.pow(this.radius, 2)) {
			// System.out.println("vertex collision vith vertex D");
			if (velocityX > 0 && velocityY > 0) {
				velocityX *= -1;
				velocityY *= -1;
			} else if (velocityX > 0 && velocityY < 0) {
				velocityX *= -1;
			} else {
				velocityY *= -1;
			}

		} else if (this.getCenterX() >= brick.getCenterX() - brick.getWidth() / 2
				&& this.getCenterX() <= brick.getCenterX() + brick.getWidth() / 2) {
			if (Math.abs(this.getCenterY() - brick.getCenterY()) <= this.getHeight() / 2 + brick.getHeight() / 2) {
				// System.out.println("up/down colision " + (this.getCenterY() -
				// brick.getCenterY()));
				velocityY *= -1;
				// brick.setVisible(false);
			}
		} else if (this.getCenterY() >= brick.getCenterY() - brick.getHeight() / 2
				&& this.getCenterY() <= brick.getCenterY() + brick.getHeight() / 2) {
			if (Math.abs(this.getCenterX() - brick.getCenterX()) <= this.getWidth() / 2 + brick.getWidth() / 2) {
				// System.out.println("left/right colision " + (this.getCenterX() -
				// brick.getCenterX()));
				velocityX *= -1;
				// brick.setVisible(false);
			}

		}

	}
}