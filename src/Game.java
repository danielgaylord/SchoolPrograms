import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import static java.lang.Thread.currentThread;

class Game extends JFrame {
	private int[][] board;
	private static Point actor;
	
	Game(int size)
    {
    	board = new int[size][size];
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			if (i == 0 || j == 0 || i == (board.length - 1) || j == (board[i].length - 1)) {
    				board[i][j] = 1;
    			} else {
    				board[i][j] = 0;
    			}
    		}
    	}
    	actor = new Point(size / 2, size / 2);
    	
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setResizable(false);
        this.setFocusTraversalKeysEnabled(false);
        this.setSize(525, 550);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    Game() {
    	new Game(20);
    }
    
    static void pauseSecs(double seconds) {
    	try {
			currentThread();
			Thread.sleep((int)(seconds * 1000));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	void moveRight() {
		actor.translate(1, 0);
		//Game.pauseSecs(.5);
		repaint();
	}
		
	public void paint(Graphics graphics) {
		int size = 25;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) { // Floor
					graphics.setColor(new Color(185, 185, 185));
			        graphics.fillRect((i * size) + i + 1, (j * size) + j + 1, size, size);
			        graphics.setColor(new Color(175, 175, 175));
			        graphics.drawRect((i * size) + i + 1, (j * size) + j + 1, size, size);
				}  
				if (board[i][j] == 1) { // Impassable blocks
					graphics.setColor(Color.gray);
			        graphics.fillRect((i * size) + i + 1, (j * size) + j + 1, size, size);
			        graphics.setColor(Color.black);
			        graphics.drawRect((i * size) + i + 1, (j * size) + j + 1, size, size);
				}		
			}
		}

		graphics.setColor(Color.green);
        graphics.fillOval((actor.x * size) + actor.x + 1, (actor.y * size) + actor.y + 1, size, size);
        graphics.setColor(Color.black);
        graphics.drawOval((actor.x * size) + actor.x + 1, (actor.y * size) + actor.y + 1, size, size);
	}
}