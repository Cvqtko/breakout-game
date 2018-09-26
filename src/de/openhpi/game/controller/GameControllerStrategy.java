package de.openhpi.game.controller;

import de.openhpi.game.model.*;

public class GameControllerStrategy implements Controller {

	private static final int KEY_SPACE = 32;
	
	private Controller gameStartedController;
	private Controller gameNotStartedController;
	private boolean isSpaceClicked = false;  // if true, the ball is in play

	public GameControllerStrategy(Model model) {
		this.gameStartedController = new GameStartedController(model);
		this.gameNotStartedController = new GameNotStartedController(model);
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
		if (keyCode == KEY_SPACE) {
			isSpaceClicked = true;
		}
	}

	@Override
	public void checkForCollisions() {
		gameStartedController.checkForCollisions();
	}

	@Override
	public boolean checkHasLevelEnded() {
		if (gameStartedController.checkHasLevelEnded()) {
			isSpaceClicked = false;
		}
		return gameStartedController.checkHasLevelEnded();
	}

}
