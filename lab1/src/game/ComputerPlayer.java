package game;

import java.util.Random;


public class ComputerPlayer extends Player{
	public ComputerPlayer(String s) {
		super(s);
	}
	
	public int takePins(Board b) {
		Random rand = new Random();
		
		int pins = rand.nextInt(2) + 1;
		
		if (b.getNoPins() < pins) {
			pins--;
		}
		b.takePins(pins);	
	
		return pins;
	}
}
