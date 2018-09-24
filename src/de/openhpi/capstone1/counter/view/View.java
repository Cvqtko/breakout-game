package de.openhpi.capstone1.counter.view;

import java.util.List;

import de.openhpi.capstone1.counter.model.*;
import processing.core.PApplet;

public class View extends AbstractView {

	public View(PApplet display) {
		super(display);
	}

	public void UpdateComponents(List<AbstractGameComponent> components) {
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
		case COUNTER:
			display.fill(0);
			display.textSize(32);
			display.text(((Counter) gameComponent).getCount(), gameComponent.getxPos(), gameComponent.getyPos());
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
