package de.openhpi.game.model;

public class LevelCounter extends AbstractGameComponent {
	int level;

	public LevelCounter(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible, GameComponentType.LEVEL_COUNTER);
		// TODO Auto-generated constructor stub
		this.level = 1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}