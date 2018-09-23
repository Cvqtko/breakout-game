package de.openhpi.capstone1.counter.view;

import processing.core.PApplet;

public class PlayGroundView extends AbstractView {

	public PlayGroundView(PApplet display) {
		super(display);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
    public int getWidth()
    {
    	return display.width;
    }
    
    public int getHeight()
    {
    	return display.width;
    }
    
    public void endLooping() {
    	display.noLoop();
    }
}
