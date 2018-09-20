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
		if (this.getyPos() > display.height) {
			display.noLoop();
			// velocityY *= -1;
		}
	}

	public void checkForCollisionWithPaddle(Paddle paddle) {

		if (this.getyPos() + this.radius >= paddle.getyPos()) {
			if (Math.abs(paddle.getCenterX() - this.getCenterX()) < paddle.getWidth() / 2 + this.getWidth() / 2) {
				velocityY *= -1;
			}
		}
	}

	public void checkForCollisionWithBrick(Brick brick) {

		if (brick.getVisible()) {
			if (this.getCenterX() >= brick.getCenterX() - brick.getWidth() / 2
					&& this.getCenterX() <= brick.getCenterX() + brick.getWidth() / 2) {
				if (Math.abs(this.getCenterY() - brick.getCenterY()) <= this.getHeight() / 2 + brick.getHeight() / 2) {
					System.out.println("down colision " + (this.getCenterY() - brick.getCenterY()));
					velocityY *= -1;
					 brick.setVisible(false);
				}
			} else if (this.getCenterY() >= brick.getCenterY() - brick.getHeight() / 2
					&& this.getCenterY() <= brick.getCenterY() + brick.getHeight() / 2) {
				if (Math.abs(this.getCenterX() - brick.getCenterX()) <= this.getWidth() / 2 + brick.getWidth() / 2) {
					System.out.println("side colision " + (this.getCenterX() - brick.getCenterX()));
					velocityX *= -1;
					brick.setVisible(false);
				}

			} else if (Math.abs(brick.getCenterX() - this.getCenterX()) < this.getWidth() / 2 + brick.getWidth() / 2
					&& Math.abs(brick.getCenterY() - this.getCenterY()) < this.getHeight() + brick.getHeight() / 2) {
				velocityY *= -1;
				velocityX *= -1;
				brick.setVisible(false);
			}
		}
	}
}