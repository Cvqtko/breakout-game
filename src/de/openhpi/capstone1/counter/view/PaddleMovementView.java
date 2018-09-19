package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;

public class PaddleMovementView extends AbstractView {
	protected Paddle paddle;

	public PaddleMovementView(PApplet display, Paddle paddle) {
		super(display);
		this.paddle = paddle;
	}

	@Override
	public void update() {
		paddle.move(display);

	}
}