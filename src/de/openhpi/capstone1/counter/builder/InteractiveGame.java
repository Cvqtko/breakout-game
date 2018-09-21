package de.openhpi.capstone1.counter.builder;

import de.openhpi.capstone1.counter.controller.Controller;
import de.openhpi.capstone1.counter.controller.GameController;
import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.Paddle;
import de.openhpi.capstone1.counter.view.AbstractView;
import de.openhpi.capstone1.counter.view.BallView;
import de.openhpi.capstone1.counter.view.BrickView;
import de.openhpi.capstone1.counter.view.PaddleView;
import processing.core.PApplet;

public class InteractiveGame extends InteractiveComponent {
	Controller gameController;
	Ball ball;
	Paddle paddle;
	Brick brick;
	PApplet display;

	public InteractiveGame() {
	}

	public void addModel(PApplet display) {
		paddle = new Paddle(0, display.height - 20, 100, 10, true);
		ball = new Ball(20, 20, 20, 20, true);
		brick = new Brick(170, 100, 220, 40, true);
		gameController = new GameController(ball, paddle, brick, display);
		this.display = display;
	}

	public void createViews(PApplet display) {
		views = new AbstractView[3];
		views[0] = new PaddleView(display, paddle);
		views[1] = new BallView(display, ball);
		views[2] = new BrickView(display, brick);
	}

	public void addController() {
		gameController = new GameController(ball, paddle, brick, display);
	}

	@Override
	public void handleMouseDragEvent(int mouseX) {
		gameController.handleMouseDragEvent(mouseX);
	}

	public void checkForCollisions() {
		gameController.checkForCollisions();
	}

	@Override
	public void update() {
		this.ball.move();

		for (AbstractView view : views) {
			view.update();
		}
		checkForCollisions();
	}

}
