package de.openhpi.capstone1.counter.model;

public class Paddle extends AbstractGameComponent {

	public Paddle(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible);
	}

	public void move(int displayWidth, int mouseX) {
		if (mouseX < 0) {
			xPos = 0;
		} else if (mouseX > displayWidth - width) {
			xPos = displayWidth - width;
		} else {
			xPos = mouseX;
		}
		this.centerX = xPos + width / 2;
	}

}
