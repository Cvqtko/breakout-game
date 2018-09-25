package de.openhpi.game;

public abstract class InteractiveComponent {

	public abstract void handleMouseDragEvent(int mouseX);

	public abstract void checkForCollisions();

	public abstract void update();

	public abstract void handleKeyPressedEvent(int keyCode);
}
