package de.openhpi.capstone1.counter.builder;

import de.openhpi.capstone1.counter.controller.Controller;
import de.openhpi.capstone1.counter.controller.GameControllerStrategy;
import de.openhpi.capstone1.counter.model.AbstractGameComponent;
import de.openhpi.capstone1.counter.model.Ball;
import de.openhpi.capstone1.counter.model.Brick;
import de.openhpi.capstone1.counter.model.BrickFactory;
import de.openhpi.capstone1.counter.model.Counter;
import de.openhpi.capstone1.counter.model.Model;
import de.openhpi.capstone1.counter.model.Paddle;
import de.openhpi.capstone1.counter.view.View;
import processing.core.PApplet;

public class InteractiveGame extends InteractiveComponent {
	Controller gameControllerStrategy;
	PApplet display;
	BrickFactory brickFactory;
	Counter counter;

	Model model;
	View view;

	public InteractiveGame(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void addModel(PApplet display) {
		model.addGameComponent(new Paddle(0, model.getPlayGroundHeight() - 20, 100, 10, true));
		model.addGameComponent(new Ball((int) (model.getPaddle().getCenterX()),
				(int) (model.getPaddle().getyPos() - model.getPaddle().getHeight()), 20, 20, true));

		for (AbstractGameComponent brick : (new BrickFactory()).getBricks(model.getPlayGroundWidth()))
			model.addGameComponent(brick);

		model.addGameComponent(new Counter(10, 30, 100, 30, true));

	}

	public void createViews(PApplet display) {

	}

	public void addController() {
		gameControllerStrategy = new GameControllerStrategy(model, view);
	}

	public void checkForCollisions() {
		gameControllerStrategy.checkForCollisions();
	}

	@Override
	public void update() {
		this.model.getBall().move();
		this.view.UpdateComponents(model.getGameComponents());
		checkForCollisions();
	}

	@Override
	public void handleMouseDragEvent(int mouseX) {
		gameControllerStrategy.handleMouseDragEvent(mouseX);
	}

	@Override
	public void handleKetPressedEvent(int keyCode) {
		gameControllerStrategy.handleKetPressedEvent(keyCode);

	}

}
