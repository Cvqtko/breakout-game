package de.openhpi.capstone1.counter.model;

public abstract class AbstractGameComponent {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private GameComponentType gameComponentType;
	private boolean isVisible;
	protected int colorR;
	protected int colorG;
	protected int colorB;

	public AbstractGameComponent(int xPos, int yPos, int width, int height, boolean isVisible, GameComponentType gameComponentType) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.isVisible = isVisible;
		this.gameComponentType = gameComponentType;
		colorR = 250; colorG = 235; colorB = 215; //antiqueWhite;

	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getCenterX() {
		return this.xPos + width / 2;
	}

	public float getCenterY() {
		return this.yPos + height / 2;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public boolean getVisible() {
		return isVisible;
	}
	
	public GameComponentType getGameComponentType() {
		return gameComponentType;
	}

	public int getColorR() {
		return colorR;
	}
	
	public int getColorG() {
		return colorG;
	}
	
	public int getColorB() {
		return colorB;
	}	
}
