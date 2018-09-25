package de.openhpi.game.view;

import java.util.List;

import de.openhpi.game.model.AbstractGameComponent;
import de.openhpi.game.model.LevelCounter;
import de.openhpi.game.model.Score;
import de.openhpi.game.model.WelcomeScreen;
import processing.core.PApplet;

public class View extends AbstractView {

	public View(PApplet display) {
		super(display);
	}

	public void updateComponents(List<AbstractGameComponent> components) {
		display.background(204);
		components.forEach(gameComponent -> renderComponent(gameComponent));
	}

	public void renderComponent(AbstractGameComponent gameComponent) {

		switch (gameComponent.getGameComponentType()) {
		case BALL:
			display.fill(gameComponent.getColorR(), gameComponent.getColorG(), gameComponent.getColorB());
			display.ellipse(gameComponent.getCenterX(), gameComponent.getCenterY(), gameComponent.getWidth(),
					gameComponent.getHeight());
			break;
		case BRICK:
			if (gameComponent.getVisible()) {
				display.fill(gameComponent.getColorR(), gameComponent.getColorG(), gameComponent.getColorB());
				display.rect(gameComponent.getxPos(), gameComponent.getyPos(), gameComponent.getWidth(),
						gameComponent.getHeight());
			}
			break;
		case PADDLE:
			display.fill(0);
			display.rect(gameComponent.getxPos(), gameComponent.getyPos(), gameComponent.getWidth(),
					gameComponent.getHeight());
			break;
		case SCORE:
			display.fill(0);
			display.textSize(16);
			display.text(((Score) gameComponent).getScore(), gameComponent.getxPos(), gameComponent.getyPos());
			break;
		case LEVEL_COUNTER:
			display.fill(0);
			display.textSize(16);
			display.text("Level " + ((LevelCounter) gameComponent).getLevel(), gameComponent.getxPos(),
					gameComponent.getyPos());
			break;
		case WELCOME_SCREEN:
			display.fill(0, 102, 153);
			display.textSize(20);
			display.text(((WelcomeScreen) gameComponent).getText(), gameComponent.getxPos(), gameComponent.getyPos());
			break;
		default: // if another component type should occur, just do nothing as currently not
					// supported
			break;
		}

	}

	public void stopLooping() {
		display.noLoop();
	}

}
