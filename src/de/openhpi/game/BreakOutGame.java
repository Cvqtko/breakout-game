package de.openhpi.game;

import de.openhpi.game.controller.Controller;
import de.openhpi.game.controller.GameControllerStrategy;
import de.openhpi.game.model.*;
import de.openhpi.game.view.View;

public class BreakOutGame extends InteractiveComponent {
	Controller gameControllerStrategy;
	Model model;
	View view;


	public BreakOutGame(Model model, View view, Controller controller) {
		this.model = model;
		this.view = view;
		this.gameControllerStrategy = controller;
	}
    
	//adding the inventory to the game
	//all compounds needed are added to the model here
	public void addGameComponentsToModel() {
		//adding a paddle
		model.addGameComponent(
				new Paddle(0, model.getPlayGroundHeight() - 20, model.getPlayGroundWidth() / 6, 10, true));
		
		//adding a ball and placing it on top of the paddle
		model.addGameComponent(new Ball((int) (model.getPaddle().getCenterX()),
				(int) (model.getPaddle().getyPos() - model.getPaddle().getHeight()), 20, 20, true));
        
		//producing some bricks (number of bricks depends on the playground width
		for (AbstractGameComponent brick : BrickFactory.getBricks(model.getPlayGroundWidth()))
			model.addGameComponent(brick);
		
		//adding Score, level counter and welcome screen
		model.addGameComponent(new Score(10, 20, 100, 30, true));
		model.addGameComponent(new LevelCounter(model.getPlayGroundWidth() - 60, 20, 0, 0, true));
		model.addGameComponent(new WelcomeScreen(230, model.getPlayGroundHeight() / 2, 0, 0, true));
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

	//Resetting the playground and initializing a new round
	private void startNewLevel() {
		LevelCounter levelCounter = model.getLevelCounter();
		levelCounter.setLevel(levelCounter.getLevel() + 1);

		WelcomeScreen welcomeScreen = model.getWelcomeScreen();
		welcomeScreen.setText("Congratulations! \n" + "        Level " + levelCounter.getLevel());
		Ball ball = model.getBall();
		ball.setxPos((int) model.getPaddle().getCenterX() - ball.getWidth() / 2);
		ball.setyPos((int) (model.getPaddle().getyPos() - model.getPaddle().getHeight() * 2));
		ball.setVelocityX(0);
		ball.setVelocityY(0);

		//remove the 'old bricks' from the model
		model.removeAllBricks();
		//add a new set of bricks for the next level
		for (AbstractGameComponent brick : BrickFactory.getBricks(model.getPlayGroundWidth()))
			model.addGameComponent(brick);
	}

	@Override
	public void handleMouseDragEvent(int mouseX) {
		gameControllerStrategy.handleMouseDragEvent(mouseX);
	}

	@Override
	public void handleKeyPressedEvent(int keyCode) {
		gameControllerStrategy.handleKetPressedEvent(keyCode);

	}

}
