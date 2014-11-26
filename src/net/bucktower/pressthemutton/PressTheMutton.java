package net.bucktower.pressthemutton;

import processing.core.PApplet;


public class PressTheMutton extends PApplet {

	int cataMargin;
	int cataHeight;
	int cataWidth;
	
	public void setup() {
		background(0);
		size(1280,600);
	}

	public void draw() {
		refreshCata();
	}
	
	private void refreshCata(){
		
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { net.bucktower.pressthemutton.PressTheMutton.class.getName() });
	}
}
