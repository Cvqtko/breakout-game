package de.openhpi.capstone1.counter.model;

public class BrickFactory {
//	Brick[] bricks = new Brick[9];
//
//	public Brick[] getBricks() {
//		int counter = 0;
//		for (int i = 0; i < bricks.length; i++) {
//
//			bricks[i] = new Brick(35 + counter, 50, 50, 20, true);
//			counter += 60;
//		}
//		return bricks;
//	}
	 Brick[] bricks = new Brick[27];
	
	 public Brick[] getBricks() {
	 int counter = 0;
	 int row = 0;
	 for (int i = 0; i < bricks.length; i++) {
	 if (i % 9 == 0) {
	 row += 30;
	 counter = 0;
	 }
	 bricks[i] = new Brick(35 + counter, 10 + row, 50, 20, true);
	 counter += 60;
	
	 }
	
	 return bricks;
	 }
}
