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
		InitializeGameSettings();
	}

	// initializing some basic game settings
	public void InitializeGameSettings() {
		// Here are done some basic settings.
		// these settings could be loaded from a configuration file too.
		// playGroundWidth can vary from 120 to 1366, playGroundWidth can vary from 200
		// to 700
		// recommended settings are 600/400
		playGroundWidth = 600;
		playGroundHeight = 400;
		frameRate = 360;

	}

	// getBall returns the instance of the Paddle (game component) used in the game
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

	// getBall returns the instance of the Ball (game component) used in the game
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

	// getBricks returns an array of brick (game components) containing all bricks
	public Brick[] getBricks() {
		List<Brick> returnList = new ArrayList<Brick>();
		Brick[] returnArray = new Brick[1];
		allComponents.stream().filter(comp -> comp.getGameComponentType() == GameComponentType.BRICK)
				.forEach(b -> returnList.add((Brick) b));
		return returnList.toArray(returnArray);
	}

	// getScore returns the instance of the score (game component) used in the game
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

	// getWelcomeScreen returns the instance of the welcome screen (game component)
	// used in the game
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

	// getLevelCounter returns the instance of the level counter (game component)
	// used in the game
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

	// getPlayGroundWidth returns the width of the applicaton screen
	public int getPlayGroundWidth() {
		return playGroundWidth;
	}

	// getPlayGroundHeight returns the height of the applicaton screen
	public int getPlayGroundHeight() {
		return playGroundHeight;
	}

	// getFrameRate returns the FrameRate used (the frequency processing (re-)Draws
	public int getFrameRate() {
		return frameRate;
	}

	// addGameComponent adds anew instance of a abstractGameComponent to the Model
	public void addGameComponent(AbstractGameComponent abstractGameComponent) {
		if (!allComponents.contains(abstractGameComponent))
			allComponents.add(abstractGameComponent);
	}

	// getGameComponents() provides a copy of the all components list (components
	// contained
	// still are references to the original objects
	public List<AbstractGameComponent> getGameComponents() {
		List<AbstractGameComponent> returnList = new ArrayList<AbstractGameComponent>();
		allComponents.forEach(component -> returnList.add(component));
		return returnList;
	}

	// removeAllBricks deletes all Bricks contained in the Model respectively in the
	// allComponents list
	public void removeAllBricks() {
		List<AbstractGameComponent> deletionList = new ArrayList<AbstractGameComponent>();
		allComponents.stream().filter(comp -> comp.getGameComponentType() == GameComponentType.BRICK)
				.forEach(deletionList::add);
		deletionList.forEach(comp -> allComponents.remove(comp));
		deletionList = null;
	}

}
