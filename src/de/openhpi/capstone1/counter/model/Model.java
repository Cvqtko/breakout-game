package de.openhpi.capstone1.counter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Model {
	
	private int playGroundWidth;
	private int playGroundHeight;
    private int frameRate;
	private List<AbstractGameComponent> allComponents;
	
	//private Paddle paddle;
	//private Ball ball;
	private Brick[] bricks;
	private Counter counter;
	
	
	public Model() {
		allComponents = new ArrayList<AbstractGameComponent>();
		// TODO Auto-generated constructor stub
		InitializeGameSettings();
	}
	
	public void InitializeGameSettings() {
		// Here are done some basic settings.
		// these settings could be loaded from a configuration file too.
		playGroundWidth = 600;
		playGroundHeight = 400;
		frameRate = 100;
		
		//paddle = null;
		//ball = null;
		counter = null;
		bricks = null;
	}
	
	//public getter and setter methods
	
	public Paddle getPaddle() {
		Optional<AbstractGameComponent> agc = allComponents.stream().filter(comp->comp.getGameComponentType()==GameComponentType.PADDLE).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof Paddle) //just to be on the very safe side
				return (Paddle)agc.get();
			else
				return null;
		else 
			return null;
	}
	
	public Ball getBall() {
		Optional<AbstractGameComponent> agc = allComponents.stream().filter(comp->comp.getGameComponentType()==GameComponentType.BALL).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof Ball) //just to be on the very safe side
				return (Ball)agc.get();
			else
				return null;
		else 
			return null;
	}

	
	public Brick[] getBricks() {
		return bricks;
	}
	public void setBricks(Brick[] bricks) {
		this.bricks = bricks;
	}
	
	
	public Counter getCounter() {
		return counter;
	}
	public void setCounter(Counter counter) {
		this.counter = counter;	
	}
	
	
	public int getPlaygroundWidth() {
		return playGroundWidth;
	}
	
	public int getPlayGroundHeight() {
		return playGroundHeight;
	}

	public int getFrameRate() {
		return frameRate;
	}	
	
	public void addGameComponent(AbstractGameComponent abstractGameComponent) {
		if (!allComponents.contains(abstractGameComponent))
			allComponents.add(abstractGameComponent);
	}
	
	public List<AbstractGameComponent> getGameComponents(){
		List<AbstractGameComponent> returnList = new  ArrayList<AbstractGameComponent>();
		allComponents.forEach(component->returnList.add(component));
		return returnList;
	}

}
