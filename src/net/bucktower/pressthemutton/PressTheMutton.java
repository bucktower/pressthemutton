package net.bucktower.pressthemutton;

import processing.core.PApplet;


public class PressTheMutton extends PApplet {

	//catapult
	ImageEditor cata;
	int cataMargin = 150;
		
	//grass
	ImageEditor grass;
	int grass1X;
	int grass2X;
	int grass3X;
	
	//sheep
	ImageEditor sheep;
	public static int sheepHeight;
	public static int sheepWidth;

	public void setup() {
		SketchObject.setApp(this);	

		grass = new ImageEditor("net/bucktower/pressthemutton/data/grasshd.png");
		cata = new ImageEditor("net/bucktower/pressthemutton/data/catahd.png");
		sheep = new ImageEditor("net/bucktower/pressthemutton/data/muttonhd.png");
		
		sheepHeight = sheep.height();
		sheepWidth = sheep.width();

		noStroke();
		
		size(1280,600);
		
		//grass
		grass1X = (int)random(cataMargin+cata.width(),width-grass.width());
		grass2X = (int)random(cataMargin+cata.width(),width-grass.width());
		grass3X = (int)random(cataMargin+cata.width(),width-grass.width());
		
		drawGame(false);
	}

	public void draw() {
	}
	
	public void mousePressed(){
		if(mouseX < cataMargin+cata.width() && mouseY > height-cata.height()){
			drawGame(true);
		}
	}
	
	public void mouseDragged(){
		if(mouseX < cataMargin+cata.width() && mouseY > height-cata.height()){
			drawGame(true);
		}
	}
	
	public void mouseReleased(){
		//the mutton man goes flying
	}
	
	private void drawGame(boolean drawSheep){
		background(45,150,169);
		drawGrass();
		drawCata();
		
		if(drawSheep){
			drawString();
			drawSheep();
		}
	}
	
	private void drawCata(){
		cata.drawAt(cataMargin, height-cata.height());
	}
	
	private void drawGrass(){
		grass.drawAt(grass1X,height-grass.height());
		grass.drawAt(grass2X,height-grass.height());
		grass.drawAt(grass3X,height-grass.height());
	}
	
	private void drawSheep(){
		sheep.drawAt(mouseX-sheep.width()/2, mouseY-sheep.height()/2);
	}
	
	private void drawString(){
		stroke(255);
		line(cataMargin, height-cata.height(), mouseX, mouseY);
		line(cataMargin+cata.width(), height-cata.height(), mouseX, mouseY);
		noStroke();
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { net.bucktower.pressthemutton.PressTheMutton.class.getName() });
	}
}
