package game;

/*
CLASS: Snake
DESCRIPTION: Extending Game, Snake is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

class Snake extends Game {
    static int counter = 0;
    private static SnakeObject snake;
    private Fruit apple;
    private static int score = 0;
    private Timer timer;

    public Snake() {
        super("Snake!", 500, 500);
        this.setFocusable(true);
        this.requestFocus();
        snake = new SnakeObject();
        this.addKeyListener(snake);
        apple = new Fruit();
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                snake.move();
                snake.appleCollision(apple);
                repaint();
            }
        });
        timer.start();
    }

    public static void increaseScore() {
        score++;
    }

    public void paint(Graphics brush) {
        drawCheckeredBackground(brush);
        counter++;
        brush.setColor(Color.BLUE);
        brush.drawString("Counter is " + counter, 10, 10);
        brush.setColor(Color.GREEN);
        snake.paint(brush);
        apple.paint(brush);
    }

    private void drawCheckeredBackground(Graphics g) {
        boolean isBlack = false;
        int width = getWidth();
        int height = getHeight();
        int squareSize = 25;

        for (int y = 0; y < height; y += squareSize) {
            isBlack = !isBlack;

            for (int x = 0; x < width; x += squareSize) {
                if (isBlack) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x, y, squareSize, squareSize);

                isBlack = !isBlack;
            }
        }
    }

    public void update(Graphics brush) {
        if (!snake.isGameOver()) {
            super.update(brush);
        } else {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        Snake a = new Snake();
        a.repaint();
    }
}