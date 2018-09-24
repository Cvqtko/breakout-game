package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.*;
import de.openhpi.capstone1.counter.view.View;


public class GameControllerStrategy implements Controller {
	private Controller gameStartedController;
	private Controller gameNotStartedController;
	private boolean isSpaceClicked = false;
	

	public GameControllerStrategy(Model model, View view) {
		this.gameStartedController = new GameStartedController(model, view /*, display*/);
		this.gameNotStartedController = new GameNotStartedController(model, view);
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
