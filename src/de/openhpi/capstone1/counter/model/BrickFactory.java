package de.openhpi.capstone1.counter.model;

public class BrickFactory {

	Brick[] bricks;

	public Brick[] getBricks(int playGroundWidth) {
		int spaceLeftRight = ((playGroundWidth - 60) % 60) / 2 + 35;
		int numberOfBricksPerRow = (playGroundWidth - 60) / 60;
		bricks = new Brick[numberOfBricksPerRow * 3];

		int counter = 0;
		int row = 0;
		for (int i = 0; i < bricks.length; i++) {
			if (i % numberOfBricksPerRow == 0) {
				row += 30;
				counter = 0;
			}
			bricks[i] = new Brick(spaceLeftRight + counter, 10 + row, 50, 20, true);
			counter += 60;

		}

		return bricks;
	}

}
