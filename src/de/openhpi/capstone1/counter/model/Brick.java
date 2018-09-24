package de.openhpi.capstone1.counter.model;

import java.util.concurrent.ThreadLocalRandom;

public class Brick extends AbstractGameComponent {

	private int hitCounter;
	private int points;
	private int hitsToTake;
	private int minHits = 0;
	private int maxHits = 2;

	public Brick(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible, GameComponentType.BRICK);
		this.hitCounter = 0;

		this.points = 10;
		hitsToTake = ThreadLocalRandom.current().nextInt(minHits, maxHits + 1);
		switch (hitsToTake) {
		case 0: // Red
			colorR = 139;
			colorG = 0;
			colorB = 0;
			break;
		case 1: // Blue 0, 191, 255
			colorR = 0;
			colorG = 0;
			colorB = 139;
			break;
		case 2: // green 85, 107, 47 / 143, 188, 139
			colorR = 0;
			colorG = 100;
			colorB = 0;
			break;
		}
	}

	public void hasBeenHit() {
		hitCounter++;
		if (hitCounter > hitsToTake) {
			this.setVisible(false);
		}
		switch (hitsToTake) {
		case 1: // lighter blue
			colorR = 0;
			colorG = 191;
			colorB = 255;
			break;
		case 2:
			if (hitCounter == 1) // lighter green
			{
				colorR = 0;
				colorG = 145;
				colorB = 0;
			} else // much more lighter green
			{
				colorR = 0;
				colorG = 190;
				colorB = 0;
			}
			break;
		}
		this.points = 30;
	}

	public int getPoints() {
		return points;
	}

}
