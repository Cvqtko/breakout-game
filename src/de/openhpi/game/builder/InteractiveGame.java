package de.openhpi.game.builder;

import de.openhpi.game.controller.Controller;
import de.openhpi.game.controller.GameControllerStrategy;
import de.openhpi.game.model.AbstractGameComponent;
import de.openhpi.game.model.Ball;
import de.openhpi.game.model.BrickFactory;
import de.openhpi.game.model.LevelCounter;
import de.openhpi.game.model.Model;
import de.openhpi.game.model.Paddle;
import de.openhpi.game.model.Score;
import de.openhpi.game.model.WelcomeScreen;
import de.openhpi.game.view.View;
import processing.core.PApplet;

public class InteractiveGame extends InteractiveComponent {
	Controller gameControllerStrategy;
	PApplet display;
	BrickFactory brickFactory;
	Score counter;

	Model model;
	View view;

	public InteractiveGame(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void addModel(PApplet display) {
		model.addGameComponent(
				new Paddle(0, model.getPlayGroundHeight() - 20, model.getPlayGroundWidth() / 6, 10, true));
		model.addGameComponent(new Ball((int) (model.getPaddle().getCenterX()),
				(int) (model.getPaddle().getyPos() - model.getPaddle().getHeight()), 20, 20, true));

		for (AbstractGameComponent brick : (new BrickFactory()).getBricks(model.getPlayGroundWidth()))
			model.addGameComponent(brick);

		model.addGameComponent(new Score(10, 20, 100, 30, true));
		model.addGameComponent(new LevelCounter(model.getPlayGroundWidth() - 60, 20, 0, 0, true));
		model.addGameComponent(new WelcomeScreen(230, model.getPlayGroundHeight() / 2, 0, 0, true));
	}

	public void createViews(PApplet display) {

	}

	public void addController() {
		gameControllerStrategy = new GameControllerStrategy(model, view);
	}

	public void checkForCollisions() {
		gameControllerStrategy.checkForCollisions();
	}

	public boolean checkHasLevelEnded() {
		return gameControllerStrategy.checkHasLevelEnded();
	}

	@Override
	public void update() {
		this.model.getBall().move();
		this.view.UpdateComponents(model.getGameComponents());
		checkForCollisions();
		if (checkHasLevelEnded()) {
			startNewLevel();
		}

	}

	public void startNewLevel() {
		LevelCounter levelCounter = model.getLevelCounter();
		levelCounter.setLevel(levelCounter.getLevel() + 1);

		WelcomeScreen welcomeScreen = model.getWelcomeScreen();
		welcomeScreen.setText("Congratulations! \n" + "        Level " + levelCounter.getLevel());
		Ball ball = model.getBall();
		ball.setxPos((int) model.getPaddle().getCenterX() - ball.getWidth() / 2);
		ball.setyPos((int) (model.getPaddle().getyPos() - model.getPaddle().getHeight() * 2));
		ball.setVelocityX(0);
		ball.setVelocityY(0);

		for (AbstractGameComponent brick : (new BrickFactory()).getBricks(model.getPlayGroundWidth()))
			model.addGameComponent(brick);
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
