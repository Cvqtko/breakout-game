package de.openhpi.game.builder;

import de.openhpi.game.model.Model;
import de.openhpi.game.view.View;
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
	public void buildModel() {
		iGame.addGameComponentsToModel();
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
