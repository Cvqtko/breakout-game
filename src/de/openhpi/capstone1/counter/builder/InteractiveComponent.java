package de.openhpi.capstone1.counter.builder;

import de.openhpi.capstone1.counter.view.AbstractView;

public abstract class InteractiveComponent {
	protected AbstractView[] views;

	public abstract void handleMouseDragEvent(int mouseX);

	public abstract void checkForCollisions();

	public abstract void update();

	public abstract void handleKetPressedEvent(int keyCode);
}
