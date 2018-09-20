package de.openhpi.capstone1.counter.model;

public class Brick extends AbstractGameComponent {

	public Brick(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible);
		this.setCenterX(xPos + width / 2);
		this.setCenterY(yPos + height / 2);

	}

}
