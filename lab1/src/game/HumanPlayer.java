package game;

public class HumanPlayer extends Player{
	public HumanPlayer(String s) {
		super(s);
	}

	public int takePins(Board b) {
		int pins;
		boolean valid = false;
		do {
			pins = UserInterface.askForInt("Ange antal stickor du vill ta");
			
			if(pins == -2) {
				System.exit(0);
			}
			else if (pins == -1) {
				UserInterface.printMessage("Ange ett giltigt heltal!");
			}
			else if(pins > 2) {
				UserInterface.printMessage("Du får ta max 2!");
			}
			else if(pins > b.getNoPins()) {
				UserInterface.printMessage("Du finns endast en sticka kvar!");
			}
			else {
				b.takePins(pins);
				valid = true;
			}
		}while(!valid);
		
		return pins;
	}
}
