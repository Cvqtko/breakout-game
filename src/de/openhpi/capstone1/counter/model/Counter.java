package de.openhpi.capstone1.counter.model;

public class Counter extends AbstractGameComponent {

	private int count = 0;

	public Counter(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible, GameComponentType.COUNTER);
		// TODO Auto-generated constructor stub
	}

	public void updateCount(int value) {
		this.count += value;
	}

	public int getCount() {
		return this.count;
	}
}
