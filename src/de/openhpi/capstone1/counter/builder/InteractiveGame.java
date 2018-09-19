package de.openhpi.capstone1.counter.builder;

import de.openhpi.capstone1.counter.controller.Controller;
import de.openhpi.capstone1.counter.controller.GameController;
import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Paddle;
import de.openhpi.capstone1.counter.view.AbstractView;
import de.openhpi.capstone1.counter.view.BallMovementView;
import de.openhpi.capstone1.counter.view.PaddleMovementView;
import processing.core.PApplet;

public class InteractiveGame extends InteractiveComponent {
	Controller gameController;
	Ball ball;
	Paddle paddle;

	public InteractiveGame() {
	}

	public void addModel(PApplet display) {
		paddle = new Paddle();
		ball = new Ball(50, 50, display);
		gameController = new GameController(paddle);
	}

	public void createViews(PApplet display) {
		views = new AbstractView[2];
		views[0] = new PaddleMovementView(display, paddle);
		views[1] = new BallMovementView(display, ball, paddle);
	}

	public void addController() {
		gameController = new GameController(paddle);
	}

	@Override
	public void handleMouseDragEvent(int width, int mouseX) {
		gameController.handleMouseDragEvent(width, mouseX);
	}
}
