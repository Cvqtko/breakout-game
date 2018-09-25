package de.openhpi.game.builder;

public class GUIComponent {
	private GUIComponent() {}
	
	public static void construct(Builder builder) {
		builder.buildComponent();
		builder.buildModel();
		builder.buildController();
	}
}
