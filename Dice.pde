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
void setup()
{
	size(500,500);
	background(0);
	noLoop();
}
void draw()
{
	background(0);
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
	text("Total Number of Dice = " + (int)(numOfDice), 250, 430);
	textAlign(LEFT);
	text("1 = " + ((int)(diceResult1/numOfDice*100)) + " percent", 100, 450);
	text("")
	text("2 = " + ((int)(diceResult2/numOfDice*100)) + " percent", 100, 460);
	text("3 = " + ((int)(diceResult3/numOfDice*100)) + " percent", 100, 470);
	text("4 = " + ((int)(diceResult4/numOfDice*100)) + " percent", 312, 450);
	text("5 = " + ((int)(diceResult5/numOfDice*100)) + " percent", 312, 460);
	text("6 = " + ((int)(diceResult6/numOfDice*100)) + " percent", 312, 470);
}
void mousePressed()
{
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
	void roll()
	{
		number = (int)(Math.random()*6+1); //your code here
	}
	void show()
	{
		fill(255);
		rect(myX,myY,50,50); //your code here
		fill(255,0,0);
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