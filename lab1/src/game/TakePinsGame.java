package game;

import javax.swing.JOptionPane;

public class TakePinsGame {
	public static void main(String[] args) {
		Board b = new Board();
		b.setUp(23);
		Player h = new HumanPlayer("Spelare");
		Player c = new GoodComputer("Dator");
		Player winner = null;
		
		boolean gameOver = false;

		UserInterface.printMessage("Antal stickor: " + b.getNoPins());

		while(!gameOver) {
			c.takePins(b);
			UserInterface.printMessage("Antal stickor kvar: " + b.getNoPins());

			if(b.getNoPins() == 0) {
				gameOver = true;
				winner = c;
				break;
			}
			h.takePins(b);
			if(b.getNoPins() == 0) {
				gameOver = true;
				winner = h;
			}
		}
		UserInterface.printMessage(winner.getUserId() + " vann");
	}
}
