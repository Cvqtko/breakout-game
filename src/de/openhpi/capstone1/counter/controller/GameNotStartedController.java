package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.*;
import de.openhpi.capstone1.counter.view.View;
import processing.core.PApplet;

public class GameNotStartedController implements Controller {

	long collisionWithPaddleDetected;
	Model model;
	View view;

	public GameNotStartedController(Model model, View view /* , PApplet display */) {
		this.model = model;
		this.view = view;
		collisionWithPaddleDetected = 0;
	}

	public void handleMouseDragEvent(int mouseX) {
		// using local paddle and ball vars to keep the statements shorter
		Paddle paddle = model.getPaddle();
		Ball ball = model.getBall();

		paddle.move(model.getPlayGroundWidth(), mouseX);
		ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
		ball.setyPos(paddle.getyPos() - ball.getHeight());

	}

	@Override
	public void handleKetPressedEvent(int keyCode) {
		// using local paddle and ball vars to keep the statements shorter
		Paddle paddle = model.getPaddle();
		Ball ball = model.getBall();

		if (keyCode == 32) {
			ball.setVelocityX(2);
			ball.setVelocityY(-2);
		} else if (keyCode == 37) {
			paddle.moveLeft();
			ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
			ball.setyPos(paddle.getyPos() - ball.getHeight());
		} else if (keyCode == 39) {
			paddle.moveRight(model.getPlayGroundWidth());
			ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
			ball.setyPos(paddle.getyPos() - ball.getHeight());
		}

	}

	@Override
	public void checkForCollisions() {
	}
}
