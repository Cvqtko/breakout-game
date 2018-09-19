package de.openhpi.capstone1.counter.builder;

import de.openhpi.capstone1.counter.view.AbstractView;

public abstract class InteractiveComponent {
	public abstract void handleMouseDragEvent(int width, int mouseX);

	protected AbstractView[] views;

	public void update() {
		for (AbstractView view : views) {
			view.update();
		}
	}
}
