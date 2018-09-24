package de.openhpi.capstone1.counter.builder;

import processing.core.PApplet;

public class GUIComponent {
	private GUIComponent() {}
	
	public static void construct(PApplet display, Builder builder) {
		builder.buildComponent();
		builder.buildModel(display);
		builder.buildView(display);
		builder.buildController();
	}
}
