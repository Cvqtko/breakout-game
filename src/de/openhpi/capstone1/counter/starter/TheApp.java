package de.openhpi.capstone1.counter.starter;

import de.openhpi.capstone1.counter.builder.GUIComponent;
import de.openhpi.capstone1.counter.builder.InteractiveComponent;
import de.openhpi.capstone1.counter.builder.InteractiveGameBuilder;
import processing.core.PApplet;

public class TheApp extends PApplet {
	InteractiveComponent interactiveComponent;

	@Override
	public void settings() {
		size(1024, 600);
//		size(600, 400);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		InteractiveGameBuilder builder = new InteractiveGameBuilder();
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

}
