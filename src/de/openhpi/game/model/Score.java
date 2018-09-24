package de.openhpi.game.model;

public class Score extends AbstractGameComponent {

	private int score = 0;

	public Score(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible, GameComponentType.SCORE);
		// TODO Auto-generated constructor stub
	}

	public void updateScore(int value) {
		this.score += value;
	}

	public int getScore() {
		return this.score;
	}
}
