package de.openhpi.capstone1.counter.model;

public class Brick extends AbstractGameComponent {

	private int hitCounter;
	private int color;
	private int points;

	public Brick(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible);
		this.hitCounter = 0;
		this.color = 0;
		this.points = 10;
	}

	public void hasBeenHit() {
		hitCounter++;
		if (hitCounter > 1) {
			this.setVisible(false);
		}
		this.color = 112;
		this.points = 30;
	}

	public int getPoints() {
		return points;
	}

	public int getColor() {
		return color;
	}

}
