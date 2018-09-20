package de.openhpi.capstone1.counter.controller;

import de.openhpi.capstone1.counter.model.Paddle;

public class GameController implements Controller {

	Paddle paddle;

	public GameController(Paddle paddle) {
		this.paddle = paddle;
	}

	public void handleMouseDragEvent(int displayWidth, int mouseX) {
		paddle.move(displayWidth, mouseX);
	}
}
