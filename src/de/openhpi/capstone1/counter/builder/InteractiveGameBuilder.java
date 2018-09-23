package de.openhpi.capstone1.counter.builder;

import de.openhpi.capstone1.counter.model.Model;
import de.openhpi.capstone1.counter.view.View;
import processing.core.PApplet;

public class InteractiveGameBuilder implements Builder {

	InteractiveGame iGame;
	Model model;
	View view;
	
	public InteractiveGameBuilder(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	@Override
	public void buildComponent() {
		iGame = new InteractiveGame(model, view);
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
