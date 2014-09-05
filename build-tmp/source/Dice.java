import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

public void setup()
{
	size(500,500);
	background(0);
	noLoop();
}
public void draw()
{
	for(int x=0;x<2;x++)
	{
		Die bob = new Die(100+(100*x),100+(100*x));
		bob.roll();
		bob.show();	
	}
	
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int myX, myY, number; //variable declarations here
	Die(int x, int y) //constructor
	{
		myX = x; //variable initializations here
		myY = y;
	}
	public void roll()
	{
		number = (int)(Math.random()*6+1); //your code here
	}
	public void show()
	{
		fill(255);
		rect(myX-25,myY-25,50,50); //your code here
		fill(0);
		textSize(20);
		textAlign(CENTER,CENTER);
		text(number,myX,myY);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
