package de.openhpi.capstone1.counter.model;

import processing.core.PApplet;

public class Paddle {
	private float positionX = 0;
	private float centerX;

	public float getCenterX() {
		return centerX;
	}

	public void updatePosition(int width, float mouseX) {

		if (mouseX < 0) {
			this.positionX = 0;
		} else if (mouseX > width - 100) {
			this.positionX = width - 100;
		} else {
			this.positionX = mouseX;
		}
		this.centerX = positionX + 50;
	}

	public void move(PApplet display) {
		float x = (float) positionX;
		if (x > display.width - 100) {
			x = display.width - 100;
		} else if (x < 0) {
			x = 0;
		}
		display.background(204);
		display.fill(0);
		display.rect(x, display.height - 15, 100, 10);
	}
}
