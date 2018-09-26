package de.openhpi.game.controller;

import de.openhpi.game.model.*;

public class GameNotStartedController implements Controller {

	private static final int KEY_LEFT = 37;
	private static final int KEY_RIGHT = 39;
	private static final int KEY_SPACE = 32;
	
	private Model model;

	public GameNotStartedController(Model model) {
		this.model = model;
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

		if (keyCode == KEY_SPACE) {
			ball.setVelocityX(model.getLevelCounter().getLevel());
			ball.setVelocityY(-model.getLevelCounter().getLevel());
			WelcomeScreen welcomeScreen = model.getWelcomeScreen();
			welcomeScreen.setText("");
		} else if (keyCode == KEY_LEFT) {
			paddle.moveLeft();
			ball.setxPos((int) paddle.getCenterX() - ball.getWidth() / 2);
			ball.setyPos(paddle.getyPos() - ball.getHeight());
		} else if (keyCode == KEY_RIGHT) {
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
