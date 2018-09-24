package de.openhpi.game.starter;

import de.openhpi.game.builder.GUIComponent;
import de.openhpi.game.builder.InteractiveComponent;
import de.openhpi.game.builder.InteractiveGameBuilder;
import de.openhpi.game.model.Model;
import de.openhpi.game.view.View;
import processing.core.PApplet;

public class TheApp extends PApplet {
	InteractiveComponent interactiveComponent;
	Model theModel;
	View theView;

	@Override
	public void settings() {
		theModel = new Model();
		theView = new View(this);
		size(theModel.getPlayGroundWidth(), theModel.getPlayGroundHeight());

		// size(1000, 600);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(theModel.getFrameRate());
		InteractiveGameBuilder builder = new InteractiveGameBuilder(theModel, theView);
		GUIComponent.construct(this, builder);
		interactiveComponent = builder.getComponent();
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		background(204);
		interactiveComponent.update();
	}

	@Override
	public void mouseDragged() {
		interactiveComponent.handleMouseDragEvent(mouseX);
	}

	@Override
	public void keyPressed() {
		interactiveComponent.handleKetPressedEvent(keyCode);
	}
}
