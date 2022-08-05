package game;

import javax.swing.JOptionPane;

public class UserInterface {
	/** Visar en dialogruta med texten msg. */
	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	/**
	* Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
	* användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
	* returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
	*/
	public static int askForInt(String msg) {
		String input = JOptionPane.showInputDialog(null, msg);
		if(input == null) {
			// Tryckte på avbryt
			return -2;
		}
		else{
			try {  
				// Ta reda på om det är en int eller inte
			    int num = Integer.parseInt(input);  
			    return num;
			} 
			catch(NumberFormatException e){  
			    return -1;  
			}  
		}
	}
}
