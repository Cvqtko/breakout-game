package de.openhpi.capstone1.counter.starter;

import de.openhpi.capstone1.counter.builder.GUIComponent;
import de.openhpi.capstone1.counter.builder.InteractiveComponent;
import de.openhpi.capstone1.counter.builder.InteractiveGameBuilder;
import processing.core.PApplet;

public class TheApp extends PApplet {
	InteractiveComponent interactiveComponent;

	@Override
	public void settings() {
		size(600, 400);
	}

	@Override
	public void setup() { // setup() runs once
		frameRate(30);
		InteractiveGameBuilder builder = new InteractiveGameBuilder();
		GUIComponent.construct(this, builder);
		interactiveCounter = builder.getComponent();
	}

	@Override
	public void draw() { // draw() loops forever, until stopped
		background(204);
		interactiveCounter.update();
	}

	@Override
	public void mouseDragged() {
		interactiveCounter.handleMouseDragEvent(width, mouseX);
	}

}
