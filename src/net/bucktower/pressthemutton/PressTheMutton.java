package net.bucktower.pressthemutton;

import processing.core.PApplet;


public class PressTheMutton extends PApplet {

	int cataMargin = 150;
	int cataHeight = 200;
	int cataWidth = 30;
	
	public void setup() {
		noStroke();
		
		background(45,150,169);
		size(1280,600);
	}

	public void draw() {
		refreshCata();
	}
	
	private void refreshCata(){
		fill(130,60,10);
		rect(cataMargin,height-cataHeight,cataWidth,cataHeight);
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { net.bucktower.pressthemutton.PressTheMutton.class.getName() });
	}
}
