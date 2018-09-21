package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;

public class PaddleView extends AbstractView {
	protected Paddle paddle;

	public PaddleView(PApplet display, Paddle paddle) {
		super(display);
		this.paddle = paddle;
	}

	@Override
	public void update() {
		float x = paddle.getxPos();
		int y = paddle.getyPos();
		int paddleWidth = paddle.getWidth();
		int paddleHeight = paddle.getHeight();

		display.background(204);
		display.fill(0);
		display.rect(x, y, paddleWidth, paddleHeight);
	}
}