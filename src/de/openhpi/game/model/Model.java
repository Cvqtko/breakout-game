package de.openhpi.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Model {

	private int playGroundWidth;
	private int playGroundHeight;
	private int frameRate;
	private List<AbstractGameComponent> allComponents;

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
		frameRate = 200;

	}

	public Paddle getPaddle() {
		Optional<AbstractGameComponent> agc = allComponents.stream()
				.filter(comp -> comp.getGameComponentType() == GameComponentType.PADDLE).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof Paddle) // just to be on the very safe side
				return (Paddle) agc.get();
			else
				return null;
		else
			return null;
	}

	public Ball getBall() {
		Optional<AbstractGameComponent> agc = allComponents.stream()
				.filter(comp -> comp.getGameComponentType() == GameComponentType.BALL).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof Ball) // just to be on the very safe side
				return (Ball) agc.get();
			else
				return null;
		else
			return null;
	}

	public Brick[] getBricks() {
		List<Brick> returnList = new ArrayList<Brick>();
		Brick[] returnArray = new Brick[1];
		allComponents.stream().filter(comp -> comp.getGameComponentType() == GameComponentType.BRICK)
				.forEach(b -> returnList.add((Brick) b));
		return returnList.toArray(returnArray);
	}

	public Score getScore() {
		Optional<AbstractGameComponent> agc = allComponents.stream()
				.filter(comp -> comp.getGameComponentType() == GameComponentType.SCORE).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof Score) // just to be on the very safe side
				return (Score) agc.get();
			else
				return null;
		else
			return null;
	}

	public WelcomeScreen getWelcomeScreen() {
		Optional<AbstractGameComponent> agc = allComponents.stream()
				.filter(comp -> comp.getGameComponentType() == GameComponentType.WELCOME_SCREEN).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof WelcomeScreen) // just to be on the very safe side
				return (WelcomeScreen) agc.get();
			else
				return null;
		else
			return null;
	}

	public LevelCounter getLevelCounter() {
		Optional<AbstractGameComponent> agc = allComponents.stream()
				.filter(comp -> comp.getGameComponentType() == GameComponentType.LEVEL_COUNTER).findFirst();
		if (agc.isPresent())
			if (agc.get() instanceof LevelCounter) // just to be on the very safe side
				return (LevelCounter) agc.get();
			else
				return null;
		else
			return null;
	}

	public int getPlayGroundWidth() {
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

	public List<AbstractGameComponent> getGameComponents() {
		List<AbstractGameComponent> returnList = new ArrayList<AbstractGameComponent>();
		allComponents.forEach(component -> returnList.add(component));
		return returnList;
	}

}
