package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.AbstractGameComponent;
import processing.core.PApplet;

public abstract class AbstractView {
	protected PApplet display;

	public AbstractView(PApplet display) {
		this.display = display;
	}

	public abstract void renderComponent(AbstractGameComponent gameComponent);
}
