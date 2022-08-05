package game;

import java.util.Random;

public class GoodComputer extends Player {

	public GoodComputer(String s) {
		super(s);
	}

	public int takePins(Board b) {
		int numLeft = b.getNoPins();
		if(numLeft == 1 || numLeft == 2) {
			b.takePins(numLeft);
			return numLeft;
		}
		if(numLeft % 3 != 0) {
			b.takePins(numLeft % 3);
			return numLeft % 3;
		}
		Random rand = new Random();
		
		int pins = rand.nextInt(2) + 1;
		
		b.takePins(pins);
		
		return pins;
	}

}
