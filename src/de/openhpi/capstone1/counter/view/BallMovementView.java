package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.Paddle;
import processing.core.PApplet;

public class BallMovementView extends AbstractView {
	protected Ball ball;
	protected Paddle paddle;
	protected Brick brick;

	public BallMovementView(PApplet display, Ball ball, Paddle paddle, Brick brick) {
		super(display);
		this.ball = ball;
		this.paddle = paddle;
		this.brick = brick;
	}

	@Override
	public void update() {
		ball.move();
		display.fill(244, 79, 65);
		display.ellipse(ball.getxPos(), ball.getyPos(), ball.ballRadius * 2, ball.ballRadius * 2);
		ball.checkForCollisionWithBrick(brick);
		ball.checkForCollisionWithPaddle(paddle);
		ball.checkForCollisionWithDisplay(display);

	}

}