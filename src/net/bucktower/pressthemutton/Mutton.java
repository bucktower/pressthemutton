package net.bucktower.pressthemutton;

public class Mutton {
	int myXPos;
	int myYPos;
	double myXVel;
	double myYVel;
	int width = PressTheMutton.myWidth;
	int height = PressTheMutton.myHeight;
	int cataWidth = PressTheMutton.cataWidth;
	int cataHeight = PressTheMutton.cataHeight;
	public boolean isAlive = true;
	
	  Mutton(int mouseX, int mouseY)
	  {
	    myXPos = mouseX;
	    myYPos = mouseY;
	    myXVel = (PressTheMutton.cataMargin+PressTheMutton.cataWidth)\-mouseX);
	    myYVel = (PressTheMutton.cataHeight-(height-mouseY));
	  }
	  
	  void setPos(float inX, float inY)
	  {
	    myXPos = (int) inX;
	    myYPos = (int) inY;
	  }
	  
	  void update(double deltaT)
	  {
	    // MOVE!
	    myXPos += (int)(myXVel * deltaT);
	    myYPos += (int) (myYVel * deltaT);
	    
	    //LEFT
	    if (myXPos <= cataWidth)
	    {
	       myXVel *= -1;
	    }
	    //RIGHT
	    if (myXPos >= width-cataWidth)
	    {
	       myXVel *= -1;
	    }
	    //TOP
	    if (myYPos <= cataHeight)
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
	    myYVel = myYVel + (33*deltaT);
	    
	    System.out.println("xvel: "+myXVel);
	    System.out.println("yvel: "+myYVel);
	    
	  }
	  
	  public int getXPos(){
		  return myXPos;
	  }
	  
	  public int getYPos(){
		  return myYPos;
	  }
}
