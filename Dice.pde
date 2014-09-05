void setup()
{
	size(500,500);
	background(0);
	noLoop();
}
void draw()
{
	for(int x=0;x<2;x++)
	{
		Die bob = new Die(100+(100*x),100+(100*x));
		bob.roll();
		bob.show();	
	}
}
void mousePressed()
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
	void roll()
	{
		number = (int)(Math.random()*6+1); //your code here
	}
	void show()
	{
		fill(255);
		rect(myX-25,myY-25,50,50); //your code here
		fill(0);
		textSize(20);
		textAlign(CENTER,CENTER);
		text(number,myX,myY);
	}
}
