package de.openhpi.capstone1.counter.builder;

import processing.core.PApplet;

public class InteractiveGameBuilder implements Builder {

	InteractiveGame iGame;
	
	@Override
	public void buildComponent() {
		iGame = new InteractiveGame();
	}

	@Override
	public void buildModel(PApplet display) {
		iGame.addModel(display);
	}

	@Override
	public void buildView(PApplet display) {
		iGame.createViews(display);
	}

	@Override
	public void buildController() {
		iGame.addController();
	}

	@Override
	public InteractiveComponent getComponent() {
		return iGame;
	}

}
