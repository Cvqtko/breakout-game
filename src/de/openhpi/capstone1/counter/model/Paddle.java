package de.openhpi.capstone1.counter.model;

public class Paddle extends AbstractGameComponent {

	public Paddle(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible, GameComponentType.PADDLE);
	}

	public void move(int displayWidth, int mouseX) {
		if (mouseX < 0) {
			this.setxPos(0);
		} else if (mouseX > displayWidth - this.getWidth()) {
			this.setxPos(displayWidth - this.getWidth());
		} else {
			this.setxPos(mouseX);
		}
	}

	public void moveLeft() {
		if (this.getxPos() - this.getWidth() / 2 < 0) {
			this.setxPos(0);
		} else {
			this.setxPos(this.getxPos() - this.getWidth() / 2);
		}
	}

	public void moveRight(int displayWidth) {
		if (this.getxPos() + this.getWidth() + this.getWidth() / 2 > displayWidth) {
			this.setxPos(displayWidth - this.getWidth());
		} else {
			this.setxPos(this.getxPos() + this.getWidth() / 2);
		}
	}
}
