package game;

public class Board {
	private int noPins;
	
	public void setUp(int pins) {
		noPins = pins;
	}
	
	public void takePins(int num) {
		noPins -= num;
	}
	
	public int getNoPins() {
		return noPins;
	}
}
