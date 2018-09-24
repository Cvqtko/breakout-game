package de.openhpi.game.view;

import de.openhpi.game.model.AbstractGameComponent;
import processing.core.PApplet;

public class PlayGroundView extends AbstractView {

	public PlayGroundView(PApplet display) {
		super(display);
		// TODO Auto-generated constructor stub
	}

	public void renderComponent(AbstractGameComponent gameComponent) {
		// TODO Auto-generated method stub

	}

	public int getWidth() {
		return display.width;
	}

	public int getHeight() {
		return display.width;
	}

	public void endGame() {
		display.noLoop();
	}
}
