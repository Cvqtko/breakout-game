package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Brick;
import processing.core.PApplet;

public class BrickView extends AbstractView {

	protected Brick brick;

	public BrickView(PApplet display, Brick brick) {
		super(display);
		this.brick = brick;

	}

	@Override
	public void update() {
		if (brick.getVisible()) {
			display.fill(0);
			display.rect(brick.getxPos(), brick.getyPos(), brick.getWidth(), brick.getHeight());
		}
	}
}