package de.openhpi.capstone1.counter.model;

import processing.core.PApplet;

public class Ball extends AbstractGameComponent {

	private float velocityX = 10;
	private float velocityY = 10;
	public int ballRadius;

	public Ball(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible);
		this.ballRadius = width / 2;
		this.centerX = xPos;
		this.centerY = yPos;
	}

	public void move() {
		xPos += velocityX;
		yPos += velocityY;
		this.centerX = xPos + ballRadius;
		this.centerY = yPos + ballRadius;
	}

	public void checkForCollisionWithDisplay(PApplet display) {
		if (xPos <= ballRadius || xPos > display.width - this.width) {
			velocityX *= -1; // Change ball movement direction
		}
		if (yPos <= ballRadius) {
			velocityY *= -1; // Change ball movement direction
		}
		// if ball goes below the display height and hasn't hit the paddle - stop the
		// game
		if (yPos > display.height) {
			display.noLoop();
			// velocityY *= -1;
		}
	}

	public void checkForCollisionWithPaddle(Paddle paddle) {

		if (yPos + this.ballRadius >= paddle.yPos) {
			if (Math.abs(paddle.getCenterX() - this.centerX) < paddle.getWidth() / 2 + this.width / 2) {
				velocityY *= -1;
			}
		}
	}

	public void checkForCollisionWithBrick(Brick brick) {
		if (brick.getVisible()) {
			if (Math.sqrt(Math.pow((brick.getCenterX() - xPos), 2) + Math.pow((brick.getCenterY() - yPos), 2)) < 20) {
				brick.setVisible(false);
				System.out.println("Distance between brick and ball centers = " + Math
						.sqrt(Math.pow((brick.getCenterX() - xPos), 2) + Math.pow((brick.getCenterY() - yPos), 2)));
				velocityX *= -1;
			}
		}
	}
}