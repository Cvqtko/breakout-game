package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.Counter;
import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;

public class GameControllerStrategy implements Controller {
	private Controller gameStartedController;
	private Controller gameNotStartedController;
	private boolean isSpaceClicked = false;
	

	public GameControllerStrategy(Ball ball, Paddle paddle, Brick[] bricks, Counter counter, PApplet display) {
		this.gameStartedController = new GameStartedController(ball, paddle, bricks, counter, display);
		this.gameNotStartedController = new GameNotStartedController(ball, paddle, bricks, counter, display);
	}

	@Override
	public void handleMouseDragEvent(int mouseX) {
		if (!isSpaceClicked) {
			gameNotStartedController.handleMouseDragEvent(mouseX);
		} else {
			gameStartedController.handleMouseDragEvent(mouseX);
		}
	}

	@Override
	public void handleKetPressedEvent(int keyCode) {
		if (!isSpaceClicked) {
			gameNotStartedController.handleKetPressedEvent(keyCode);
		} else {
			gameStartedController.handleKetPressedEvent(keyCode);
		}
		if (keyCode == 32) {
			isSpaceClicked = true;
		}
	}

	@Override
	public void checkForCollisions() {
		gameStartedController.checkForCollisions();

	}
}
