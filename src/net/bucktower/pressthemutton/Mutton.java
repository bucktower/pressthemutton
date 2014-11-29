package net.bucktower.pressthemutton;

public class Mutton {
	//TODO: create variables for x, y, size, color, and velocities
	  
	  
	  
	   // constructor 
	   Mutton(int spawnX,int spawnY)
	   {
	     // TODO: give the variables for this class random values. 
	     int xCoord = spawnX - PressTheMutton.sheepWidth;
	     int yCoord = spawnY - PressTheMutton.sheepHeight;
	   }
	   
	   void update(float dT)
	   {
	      // NOTE: For best (i.e., non-crashing) results, do these in order!
	      
	      // TODO: Check whether the location of the dot is off-screen  
	      //      - if so, put it back onscreeen and give it a random velocity.
	      //               Also, change its color to white.
		   
	      
	      // TODO: Find the color of the pixel in the ImageEditor under the center of the dot.
	      // Hint: depending on how you've named your variables, this might look like:
	      // color c = source.colorAt((int)myXPos,(int)myYPos);	      
	       
		   
	      if (yellowDistance < 60)
	      {
	         //TODO: change this dot's color to yellow.
	         
	         //TODO: change the velocity so that this dot goes due north. 
	        
	      }
	     
	      // TODO: Now change the x and y positions, based on the velocity and dT.
	   
	 
	 
	 }
	 
	 // TODO:  write the drawSelf() method.
	 void drawSelf(){
		 
	 }
}
