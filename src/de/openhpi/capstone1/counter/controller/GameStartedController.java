package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.AbstractGameComponent;
import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.Counter;
import de.openhpi.capstone1.counter.model.Model;
import de.openhpi.capstone1.counter.model.Paddle;
import de.openhpi.capstone1.counter.view.View;
import processing.core.PApplet;

public class GameStartedController implements Controller {

	//Paddle paddle;
	//Ball ball;
	//Brick[] bricks;
	//PApplet display;
	//Counter counter;
	long collisionWithPaddleDetected;
	Model model;
	View view;

	public GameStartedController(Model model, View view /*, PApplet display */) {

		this.model = model;
		this.view = view;
		collisionWithPaddleDetected = 0;
	}

	public void handleMouseDragEvent(int mouseX) {
		model.getPaddle().move(model.getPlayGroundWidth(), mouseX);
	}

	@Override
	public void handleKetPressedEvent(int keyCode) {
		if (keyCode == 37) {
			model.getPaddle().moveLeft();
		} else if (keyCode == 39) {
			model.getPaddle().moveRight(model.getPlayGroundWidth());

		}
	}

	@Override
	public void checkForCollisions() {
		long currentTimeMillis = System.currentTimeMillis();
		checkForCollisionBallAndDisplay();

		for (Brick brick : model.getBricks()) {
			if (brick.getVisible()) {
				if (ballRectCollision(brick)) {
					model.getCounter().updateCount(brick.getPoints());
					brick.hasBeenHit();
				}
			}
		}

		if (currentTimeMillis - collisionWithPaddleDetected > 100) {
			if (ballRectCollision(model.getPaddle())) {
				this.collisionWithPaddleDetected = System.currentTimeMillis();
			}
		}
	}

	private void checkForCollisionBallAndDisplay() {
		// using a local variable ball, to keep the statements shorter
		Ball ball = model.getBall();
		if (ball.getxPos() <= 0 || ball.getxPos() + ball.getWidth() >= model.getPlayGroundWidth()) {

			ball.setVelocityX(ball.getVelocityX() * -1); // Change ball movement direction
		}
		if (ball.getyPos() <= 0) {
			ball.setVelocityY(ball.getVelocityY() * -1); // Change ball movement direction
		}
		// if ball goes below the display height stop the game
		if (ball.getyPos() > model.getPlayGroundHeight()) {
			//display.noLoop();
			view.stopLooping();
		}
	}

	// Checks for collision between a Circle and a Rectangle
	// used for checking ball collisions only, as a ball is always part of a collision
	boolean ballRectCollision(/*Ball ball,*/ AbstractGameComponent rect) {
		// using a local variable ball, to keep the statements shorter
		Ball ball = model.getBall();
		float cx = ball.getCenterX();
		float cy = ball.getCenterY();
		float radius = model.getBall().getRadius();
		float rx = rect.getxPos();
		float ry = rect.getyPos();
		float rw = rect.getWidth();
		float rh = rect.getHeight();

		// temporary variables to set edges for testing
		float testX = cx;
		float testY = cy;

		// which edge is closest?
		if (cx < rx)
			testX = rx; // compare left edge
		else if (cx > rx + rw)
			testX = rx + rw; // right edge
		if (cy < ry)
			testY = ry; // top edge
		else if (cy > ry + rh)
			testY = ry + rh; // bottom edge

		// get distance from closest edges
		float distX = cx - testX;
		float distY = cy - testY;
		float distance = (float) Math.sqrt((distX * distX) + (distY * distY));

		// if the distance is less than the radius, we have a collision!
		if (distance <= radius) {
			if ((testX == rx && testY == ry) || (testX == rx + rw && testY == ry) || (testX == rx && testY == ry + rh)
					|| (testX == rx + rw && testY == ry + rh)) {
				ball.setVelocityX(ball.getVelocityX() * -1);
			}
			ball.setVelocityY(ball.getVelocityY() * -1);
			return true;
		}
		return false;
	}

}
