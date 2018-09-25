package de.openhpi.game.builder;

import processing.core.PApplet;

public interface Builder {
	public void buildComponent();
	public void buildModel(); 
	public void buildController();
	
	public InteractiveComponent getComponent();
}
