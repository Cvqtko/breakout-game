package de.openhpi.game.starter;

import de.openhpi.game.BreakOutGame;
import de.openhpi.game.controller.Controller;
import de.openhpi.game.controller.GameControllerStrategy;
import de.openhpi.game.model.Model;
import de.openhpi.game.view.*;
import processing.core.PApplet;

public class TheApp extends PApplet {
	BreakOutGame breakOutGame;
	Model theModel;
	AbstractView theView;
    Controller theController;
    
	@Override
	public void settings() {
		//initializing the model
		theModel = new Model();
		//initializing the view including a reference to the "PApplet" component of processing library
		theView = new View(this);
		//initializing the controller
		theController  = new GameControllerStrategy(theModel, theView);
		
		size(theModel.getPlayGroundWidth(), theModel.getPlayGroundHeight());

	}

	@Override
	public void setup() {
		// setup() runs once
		frameRate(theModel.getFrameRate());
		// initializing the break-out game itself
		breakOutGame = new BreakOutGame(theModel, theView, theController);
		//adding some game components (ball, paddle bricks...) to the play
		breakOutGame.addGameComponentsToModel();

	}

	@Override
	public void draw() {
		// draw() loops forever, until stopped
		background(204);
		//interactiveComponent.update();
		breakOutGame.update();
	}

	@Override
	public void mouseDragged() {

		breakOutGame.handleMouseDragEvent(mouseX);		
	}

	@Override
	public void keyPressed() {

		breakOutGame.handleKeyPressedEvent(keyCode);
	}
}
