package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;
import processing.core.PImage;

public class BallMovementView extends AbstractView {
	PImage img;
	protected Ball ball;
	protected Paddle paddle;

	public BallMovementView(PApplet display, Ball ball, Paddle paddle) {
		super(display);
		this.ball = ball;
		this.paddle = paddle;
		// this.img = display.loadImage("ball.png");

	}

	@Override
	public void update() {
		ball.move();
		ball.checkForCollisionWithPaddle(paddle);
	}

}