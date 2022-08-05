package fractal;

import koch.Koch;
import mountain.BigMountain;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new BigMountain(400, 500, 100, 500, 300, 167, 50);
		fractals[1] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}
}
