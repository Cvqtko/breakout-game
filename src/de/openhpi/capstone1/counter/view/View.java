package de.openhpi.capstone1.counter.view;

import java.util.List;

import de.openhpi.capstone1.counter.model.*;
import processing.core.PApplet;

public class View extends AbstractView {

	public View(PApplet display) {
		super(display);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	public void UpdateComponents(List<AbstractGameComponent> components) {
		
		components.forEach(gameComponent->renderComponent(gameComponent));
		;
		
	}
	
	private void renderComponent(AbstractGameComponent gameComponent) {
		display.background(204);
		switch (gameComponent.getGameComponentType()) {
		case BALL:
			display.fill(244, 79, 65);
			display.ellipse(gameComponent.getxPos(), gameComponent.getyPos(), gameComponent.getWidth(), gameComponent.getHeight());
			break;
		case BRICK:
			if (gameComponent.getVisible()) {
				//display.fill(brick.getColor());
				display.fill(display.color(gameComponent.getColorR(), gameComponent.getColorG(), gameComponent.getColorB()));
				display.rect(gameComponent.getxPos(), gameComponent.getyPos(), gameComponent.getWidth(), gameComponent.getHeight());
			}
			break;
		case PADDLE:
			display.fill(0);
			display.rect(gameComponent.getxPos(), gameComponent.getyPos(), gameComponent.getWidth(), gameComponent.getHeight());
	        break;
		case COUNTER:
			display.fill(0);
			display.textSize(32);
			display.text("Still a Dummy!" + "", gameComponent.getxPos(), gameComponent.getyPos());
			break;
		default: // if another component type should occur, just do nothing as currently not supported
			break;
		}

	}

}
