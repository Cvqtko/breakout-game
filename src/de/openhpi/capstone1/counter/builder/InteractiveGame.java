package de.openhpi.capstone1.counter.builder;

import java.util.List;

import de.openhpi.capstone1.counter.controller.Controller;
import de.openhpi.capstone1.counter.controller.GameControllerStrategy;
import de.openhpi.capstone1.counter.model.*;
import de.openhpi.capstone1.counter.view.AbstractView;
import de.openhpi.capstone1.counter.view.BallView;
import de.openhpi.capstone1.counter.view.BrickView;
import de.openhpi.capstone1.counter.view.CounterView;
import de.openhpi.capstone1.counter.view.PaddleView;
import de.openhpi.capstone1.counter.view.View;
import processing.core.PApplet;

public class InteractiveGame extends InteractiveComponent {
	Controller gameControllerStrategy;
	//Ball ball;
	//Paddle paddle;
	Brick[] bricks;
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
		/*
		 paddle = new Paddle(0, display.height - 20, 100, 10, true);
		ball = new Ball((int) (paddle.getCenterX()), (int) (paddle.getyPos() - paddle.getHeight()), 20, 20, true);

		brickFactory = new BrickFactory();
		bricks = brickFactory.getBricks();
		counter = new Counter(10, 30, 100, 30, true);
		this.display = display;
		*/
		
		//Creating the components and adding them as AbstractComponent to the model
		//the paddle
		//paddle = new Paddle(0, model.getPlayGroundHeight() - 20, 100, 10, true);
		model.addGameComponent(new Paddle(0, model.getPlayGroundHeight() - 20, 100, 10, true));
		//the ball
		//ball = new Ball((int) (paddle.getCenterX()), (int) (paddle.getyPos() - paddle.getHeight()), 20, 20, true);
		model.addGameComponent(new Ball((int) (model.getPaddle().getCenterX()), (int) (model.getPaddle().getyPos() - model.getPaddle().getHeight()), 20, 20, true));
		
		
	 
		// the brick rows
		//brickFactory = new BrickFactory();
		//bricks = brickFactory.getBricks();
		//for(AbstractGameComponent brick : bricks)
		for(AbstractGameComponent brick : (new BrickFactory()).getBricks())
			model.addGameComponent(brick);
		
		// the counter
		counter = new Counter(10, 30, 100, 30, true);
	    model.addGameComponent(counter);		
		this.display = display;

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
/*		for (AbstractView view : views) {
			view.update();
		}*/
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
