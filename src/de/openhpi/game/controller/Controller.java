package de.openhpi.game.controller;

public interface Controller {
	void handleMouseDragEvent(int mouseX);

	void handleKetPressedEvent(int keyCode);

	void checkForCollisions();

	boolean checkHasLevelEnded();
}
