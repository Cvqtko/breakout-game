package de.openhpi.game.controller;

import de.openhpi.game.model.*;
import de.openhpi.game.view.*;

public class GameControllerStrategy implements Controller {
	private Controller gameStartedController;
	private Controller gameNotStartedController;
	private boolean isSpaceClicked = false;  // if true, the ball is in play

	public GameControllerStrategy(Model model, AbstractView view) {
		this.gameStartedController = new GameStartedController(model, view);
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

	@Override
	public boolean checkHasLevelEnded() {
		if (gameStartedController.checkHasLevelEnded()) {
			isSpaceClicked = false;
		}
		return gameStartedController.checkHasLevelEnded();
	}

}
