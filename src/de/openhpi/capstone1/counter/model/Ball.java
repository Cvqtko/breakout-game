package de.openhpi.capstone1.counter.model;

import processing.core.PApplet;
import processing.core.PImage;

public class Ball {
	private PImage img;
	private float velocityX = 10, velocityY = 10;
	private float x;
	private float y;
	private float centerX;
	private PApplet display;

	public Ball(float x, float y, PApplet display) {
		this.x = x;
		this.y = y;
		this.img = display.loadImage("ball.png");
		this.display = display;
	}

	public void move() {
		if (x < 10 || x > display.width - 24) {
			velocityX *= -1; // Change ball move direction
		}
		if (y < 10 || y > display.height - 45) {
			velocityY *= -1; // Change ball move direction
		}
		x += velocityX;
		y += velocityY;
		display.image(img, x, y);
	}

	public void checkForCollisionWithPaddle(Paddle paddle) {
		if (y > display.height - 45) {
			// Checks the distance between the paddle center and the ball center
			// The paddle width is 100 and the ball is 24
			System.out.println(
					"Distance between paddle and ball centers = " + Math.abs(paddle.getCenterX() - (x + img.width / 2)));
			if (Math.abs(paddle.getCenterX() - (x + img.width / 2)) > 62) {
				this.display.noLoop();
			}
		}
	}
}