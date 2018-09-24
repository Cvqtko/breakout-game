package de.openhpi.game.view;

import de.openhpi.game.model.AbstractGameComponent;
import processing.core.PApplet;

public abstract class AbstractView {
	protected PApplet display;

	public AbstractView(PApplet display) {
		this.display = display;
	}

	public abstract void renderComponent(AbstractGameComponent gameComponent);
}
