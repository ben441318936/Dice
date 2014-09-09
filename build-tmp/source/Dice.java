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

int dieX = 25;
int dieY = 25;
int c1 = 0;
int c2 = 0;
float numOfDice = 0;
float diceResult1 = 0;
float diceResult2 = 0;
float diceResult3 = 0;
float diceResult4 = 0;
float diceResult5 = 0;
float diceResult6 = 0;
public void setup()
{
	size(500,500);
	background(0);
	noLoop();
}
public void draw()
{
	//frameRate(3);
	background(0);
	c1 = 0;
	c2 = 0;
	dieX = 25;
	dieY = 25;
	numOfDice = 0;
	diceResult1 = 0;
	diceResult2 = 0;
	diceResult3 = 0;
	diceResult4 = 0;
	diceResult5 = 0;
	diceResult6 = 0;
	for(int n=0;n<20;n++)
	{
		
		if(c1<5)
		{
			dieX = 25+(100*c1);
			c1++;
		}
		else 
		{
			c1 = 1;
			c2++;
			dieX = 25;
			dieY = 25+(100*c2);
		}
		Die bob = new Die(dieX, dieY);
		bob.roll();
		bob.show();	
		numOfDice++;
	}
	fill(255,255,0);
	textAlign(CENTER);
	text("Total Number of Dice = " + (int)(numOfDice), 250, 410);
	text("Sum of Results = " + (int)((diceResult1*1)+(diceResult2*2)+(diceResult3*3)+(diceResult4*4)+(diceResult5*5)+(diceResult6*6)), 250, 425);
	text((int)(diceResult1/numOfDice*100),127,450);
	text((int)(diceResult2/numOfDice*100),127,460);
	text((int)(diceResult3/numOfDice*100),127,470);
	text((int)(diceResult4/numOfDice*100),339,450);
	text((int)(diceResult5/numOfDice*100),339,460);
	text((int)(diceResult6/numOfDice*100),339,470);
	textAlign(LEFT);
	text("1 = ", 100, 450);
	text("percent", 137,450);
	text("2 = ", 100, 460);
	text("percent", 137,460);
	text("3 = ", 100, 470);
	text("percent", 137,470);
	text("4 = ", 312, 450);
	text("percent", 349,450);
	text("5 = ", 312, 460);
	text("percent", 349,460);
	text("6 = ", 312, 470);
	text("percent", 349,470);
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
		number = (int)(Math.random()*6+1);
	}
	public void show()
	{
		fill(255);
		rect(myX,myY,50,50);
		fill((int)(Math.random()*254+1),(int)(Math.random()*254+1),(int)(Math.random()*254+1));
		if (number == 1)
		{
			diceResult1++;
			ellipse(myX+25, myY+25, 10, 10);
		}
		else if (number == 2)
		{
			diceResult2++;
			ellipse(myX+12, myY+25, 10, 10);
			ellipse(myX+38, myY+25, 10, 10);
		}
		else if (number == 3)
		{
			diceResult3++;
			ellipse(myX+25, myY+12, 10, 10);
			ellipse(myX+12, myY+38, 10, 10);
			ellipse(myX+38, myY+38, 10, 10);
		}
		else if (number == 4)
		{
			diceResult4++;
			ellipse(myX+12, myY+12, 10, 10);
			ellipse(myX+12, myY+38, 10, 10);
			ellipse(myX+38, myY+12, 10, 10);
			ellipse(myX+38, myY+38, 10, 10);
		}
		else if (number == 5)
		{
			diceResult5++;
			ellipse(myX+25, myY+25, 10, 10);
			ellipse(myX+12, myY+12, 10, 10);
			ellipse(myX+12, myY+38, 10, 10);
			ellipse(myX+38, myY+12, 10, 10);
			ellipse(myX+38, myY+38, 10, 10);
		}
		else 
		{
			diceResult6++;
			ellipse(myX+12, myY+12, 10, 10);
			ellipse(myX+12, myY+25, 10, 10);
			ellipse(myX+12, myY+38, 10, 10);
			ellipse(myX+38, myY+12, 10, 10);
			ellipse(myX+38, myY+25, 10, 10);
			ellipse(myX+38, myY+38, 10, 10);
		}
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
