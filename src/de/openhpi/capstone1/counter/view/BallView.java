package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Ball;
import processing.core.PApplet;

public class BallView extends AbstractView {
	protected Ball ball;

	public BallView(PApplet display, Ball ball) {
		super(display);
		this.ball = ball;

	}

	@Override
	public void update() {
		display.fill(display.color(ball.getColorR(), ball.getColorG(), ball.getColorB()));
		display.ellipse(ball.getCenterX(), ball.getCenterY(), ball.getWidth(), ball.getHeight());
	}

}