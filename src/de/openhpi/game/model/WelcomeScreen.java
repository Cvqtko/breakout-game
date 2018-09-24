package de.openhpi.game.model;

public class WelcomeScreen extends AbstractGameComponent {
	String text;

	public WelcomeScreen(int xPos, int yPos, int width, int height, boolean isVisible) {
		super(xPos, yPos, width, height, isVisible, GameComponentType.WELCOME_SCREEN);
		// TODO Auto-generated constructor stub
		this.text = "   Level starts";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
