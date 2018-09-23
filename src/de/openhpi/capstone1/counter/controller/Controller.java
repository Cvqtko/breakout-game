package de.openhpi.capstone1.counter.controller;

public interface Controller {
	void handleMouseDragEvent(int mouseX);

	void handleKetPressedEvent(int keyCode);

	void checkForCollisions();
}
