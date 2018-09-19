package de.openhpi.capstone1.counter.builder;

import processing.core.PApplet;

public interface Builder {
	public void buildComponent();
	public void buildModel(PApplet display); 
	public void buildView(PApplet applet);
	public void buildController();
	
	public InteractiveComponent getComponent();
}
