package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;

class Snake extends Game {
	static int counter = 0;
	private SnakeObject snakeObject;

  public Snake() {
    super("Snake!",800,600);
    this.setFocusable(true);
	this.requestFocus();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.blue);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.white);
    	brush.drawString("Counter is " + counter,10,10);
		snakeObject = new SnakeObject();
		snakeObject.paint(brush);
  }
  
	public static void main (String[] args) {
   		Snake a = new Snake();
		a.repaint();
  }
}