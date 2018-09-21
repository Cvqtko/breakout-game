package de.openhpi.capstone1.counter.model;

public class Brick extends AbstractGameComponent {

	private int hitCounter;
	private int color;

	public Brick(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible);
		this.setCenterX(xPos + width / 2);
		this.setCenterY(yPos + height / 2);
		this.hitCounter = 0;
		this.color = 0;

	}

	public void hasBeenHit() {
		hitCounter++;
		if (hitCounter > 1) {
			this.setVisible(false);
		}
		this.color = 112;
	}

	public int getColor() {
		return color;
	}

}
