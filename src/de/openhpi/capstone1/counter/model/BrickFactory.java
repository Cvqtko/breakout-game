package de.openhpi.capstone1.counter.model;

public class BrickFactory {
	Brick[] bricks = new Brick[9];

	public Brick[] getBricks() {
		int counter = 0;
		// bricks[0] = new Brick(20, 50, 50, 20, true);
		// bricks[1] = new Brick(80, 50, 50, 20, true);
		// bricks[2] = new Brick(140, 50, 50, 20, true);
		// bricks[3] = new Brick(200, 50, 50, 20, true);
		for (int i = 0; i < bricks.length; i++) {

			bricks[i] = new Brick(35 + counter, 50, 50, 20, true);
			counter += 60;
		}
		return bricks;
	}
}
