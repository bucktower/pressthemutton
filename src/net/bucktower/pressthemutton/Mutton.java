package net.bucktower.pressthemutton;

public class Mutton {
	double myXPos;
	double myYPos;
	double myXVel;
	double myYVel;
	int width = PressTheMutton.myWidth;
	int height = PressTheMutton.myHeight;
	int cataWidth = PressTheMutton.cataWidth;
	int cataHeight = PressTheMutton.cataHeight;
	int muttonWidth = PressTheMutton.sheepWidth;
	
	public boolean isAlive = true;
	
	  Mutton(int mouseX, int mouseY)
	  {
	    myXPos = mouseX;
	    myYPos = mouseY;
	    myXVel = (PressTheMutton.cataMargin+PressTheMutton.cataWidth)-mouseX;
	    myYVel = ((height-mouseY)-PressTheMutton.cataHeight);
	  }
	  
	  void setPos(float inX, float inY)
	  {
	    myXPos = inX;
	    myYPos = inY;
	  }
	  
	  void update(double deltaT)
	  {
	    // MOVE!
	    myXPos += (myXVel * deltaT);
	    myYPos += (myYVel * deltaT);
	    
	    //LEFT
	    if (myXPos <= 0)
	    {
	       myXVel *= -1;
	    }
	    //RIGHT
	    if (myXPos >= width)
	    {
	       myXVel *= -1;
	    }
	    //TOP
	    if (myYPos <= 0)
	    {
	       myYVel *= -1;
	    }
	    //BOTTOM
	    if (myYPos >= height)
	    {
	      //myYVel *= -1;
	      //PressTheMutton.muttonsToRemove.add(this);
	    	isAlive = false;
	    }
	    
	    //Gravity
	    myYVel = myYVel + (99*deltaT);
	    
	    //System.out.println("xvel: "+myXVel);
	    //System.out.println("yvel: "+myYVel);
	    
	  }
	  
	  public double getXPos(){
		  return myXPos;
	  }
	  
	  public double getYPos(){
		  return myYPos;
	  }
}
