package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Counter;
import processing.core.PApplet;

public class CounterView extends AbstractView {
	Counter counter;

	public CounterView(PApplet display, Counter counter) {
		super(display);
		this.counter = counter;
	}

	@Override
	public void update() {
		display.fill(0);
		display.textSize(32);
		display.text(counter.getCount() + "", counter.getxPos(), counter.getyPos());
	}
}
