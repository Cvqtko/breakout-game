package de.openhpi.capstone1.counter.model;

public class Ball extends AbstractGameComponent {

	private int velocityX = -5;
	private int velocityY = -5;
	private int radius;

	public Ball(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos - width / 2, yPos - width / 2, width, height, isVisible);
		this.radius = width / 2;

	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public void move() {
		this.setxPos(this.getxPos() + this.velocityX);
		this.setyPos(this.getyPos() + this.velocityY);
	}
}