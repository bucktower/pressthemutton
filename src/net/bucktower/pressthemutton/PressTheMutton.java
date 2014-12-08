package net.bucktower.pressthemutton;

import java.util.ArrayList;

import processing.core.PApplet;


public class PressTheMutton extends PApplet {

	ArrayList<Mutton> theMuttons;
	int timeOfLastUpdate;
	ArrayList<Mutton> muttonsToAdd;
	ArrayList<Mutton> muttonsToRemove;
	
	static int myWidth = 1280;
	static int myHeight = 600;
	
	//catapult
	ImageEditor cata;
	static int cataMargin = 150;
	static int cataHeight;
	static int cataWidth;
	boolean shouldDrawString = false;
		
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
		background(45,150,169);
		SketchObject.setApp(this);	
		
		theMuttons = new ArrayList<Mutton>();
		muttonsToAdd = new ArrayList<Mutton>();
		muttonsToRemove = new ArrayList<Mutton>();
		timeOfLastUpdate = millis();

		grass = new ImageEditor("net/bucktower/pressthemutton/data/grasshd.png");
		cata = new ImageEditor("net/bucktower/pressthemutton/data/catahd.png");
		sheep = new ImageEditor("net/bucktower/pressthemutton/data/muttonhd.png");
		
		sheepHeight = sheep.height();
		sheepWidth = sheep.width();

		noStroke();
		
		size(myWidth,myHeight);
		
		//grass
		grass1X = (int)random(cataMargin+cata.width(),width-grass.width());
		grass2X = (int)random(cataMargin+cata.width(),width-grass.width());
		grass3X = (int)random(cataMargin+cata.width(),width-grass.width());
		
		drawGame(false);
		
		cataHeight = cata.height();
		cataWidth = cata.width();
	}

	public void draw() {
		drawGame(false);
	    updateAllMuttons();
	    addOrRemoveMuttons();
	    drawAllMuttons();
	}
	
	public void mousePressed(){
		shouldDrawString = true;
	}
	
	public void mouseDragged(){		
		shouldDrawString = true;
	}
	
	public void mouseReleased(){
		if(mouseX <= cataMargin+cataWidth && mouseY >= height-cataHeight){
			//the mutton man goes flying
			Mutton tempMutton = new Mutton(mouseX, mouseY);
		    muttonsToAdd.add(tempMutton);
		    drawGame(true);
		}
		shouldDrawString = false;
	}
	
	private void drawGame(boolean drawSheep){
		noStroke();
		background(45,150,169);
		//rect(0,0,width,height-cataHeight);
		//rect(cataMargin+cataWidth,height-cataHeight,width-cataMargin-cataWidth,height-cataHeight);
		drawGrass();
		drawCata();
		if(shouldDrawString){
			drawString();
			drawSheep(mouseX, mouseY);
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
	
	public void drawSheep(int refX, int refY){
		sheep.drawAt(refX-sheep.width()/2, refY-sheep.height()/2);
	}
	
	private void drawString(){
		if(mouseX < cataMargin+cata.width() && mouseY > height-cata.height()){
			stroke(255);
			line(cataMargin, height-cata.height(), mouseX, mouseY);
			line(cataMargin+cata.width(), height-cata.height(), mouseX, mouseY);
			noStroke();
		}
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { net.bucktower.pressthemutton.PressTheMutton.class.getName() });
	}
	
	// ****************************************UPDATE ALL ARROWS
	void updateAllMuttons()
	{
	  double deltaT = (millis()-timeOfLastUpdate)/1000.0;
	  timeOfLastUpdate = millis();
	  for (Mutton a:theMuttons)
	  {
	    a.update(deltaT);
	    if(a.isAlive == false){
	    	println("killing the mutton");
	    	muttonsToRemove.add(a);
	    }
	  }
	}
	// *************************************** ADD OR REMOVE ARROWS
	void addOrRemoveMuttons()
	{
	  for (Mutton a2a: muttonsToAdd)
	  {
	     theMuttons.add(a2a); 
	  }
	  muttonsToAdd.clear();
	  
	  for (Mutton a2r: muttonsToRemove)
	  {
	     theMuttons.remove(a2r); 
	  }
	  muttonsToRemove.clear();
	}

	// ****************************************DRAW ALL ARROWS
	void drawAllMuttons()
	{
	  for (Mutton a:theMuttons)
	  {
	    drawSheep((int)a.getXPos(),(int)a.getYPos());
	  }
	}
}
