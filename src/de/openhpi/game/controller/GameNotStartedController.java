package de.openhpi.game.controller;

import de.openhpi.game.model.*;

import de.openhpi.game.view.*;

public class GameNotStartedController implements Controller {

	long collisionWithPaddleDetected;
	Model model;
	AbstractView view;

	public GameNotStartedController(Model model, AbstractView view) {
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
			ball.setVelocityX(model.getLevelCounter().getLevel());
			ball.setVelocityY(-model.getLevelCounter().getLevel());
			WelcomeScreen welcomeScreen = model.getWelcomeScreen();
			welcomeScreen.setText("");
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

	@Override
	public boolean checkHasLevelEnded() {
		return false;
	}
}
