package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Brick;
import processing.core.PApplet;

public class BrickView extends AbstractView {

	protected Brick[] bricks;

	public BrickView(PApplet display, Brick[] bricks) {
		super(display);
		this.bricks = bricks;

	}

	@Override
	public void update() {
		for (Brick brick : bricks) {
			if (brick.getVisible()) {
				display.fill(display.color(brick.getColorR(), brick.getColorG(), brick.getColorB()));
				display.rect(brick.getxPos(), brick.getyPos(), brick.getWidth(), brick.getHeight());
			}
		}
	}

}