package mountain;

import java.util.HashMap;
import java.util.Map;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class BigMountain extends Fractal {
	
	private Point p1;
	private Point p2;
	private Point p3;
	private double dev;
	private Map<Side, Point> map;
	
	public BigMountain(int x1, int y1, int x2, int y2, int x3, int y3, double dev) {
		super();
		
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x3, y3);
		this.dev = dev;
		this.map = new HashMap<Side, Point>();
	}
	
	public void increaseDev() {
		dev *= 2;
		print(dev);
	}
	
	public void decreaseDev() {
		dev /= 2;
		print(dev);
	}
	
	@Override
	public String getTitle() {
		return "Bergsmassiv";
	}

	@Override
	public void draw(TurtleGraphics g) {
		triangle(g, order, p1, p2, p3);
	}
	
	public void triangle(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3) {
		if (order == 0){
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		}
		else {
			
			Side[] sides = new Side[]{
					new Side(p1, p2),
					new Side(p2, p3),
					new Side(p3, p1)};
			
			Point[] middlePoints = new Point[3];
			int count = 0;
			
			for(Side s: sides) {
				Point newP;
				if(map.containsKey(s)){
					newP = map.get(s);
					map.remove(s);
				}
				else {
					newP = new Point(s.getP1().getX() + (s.getP2().getX()-s.getP1().getX()) / 2, s.getP1().getY() + (s.getP2().getY()-s.getP1().getY()) / 2 + (int) RandomUtilities.randFunc(dev));
					map.put(s, newP);
				}
				middlePoints[count] = newP;
				count++;
			}
			
			// Gör triangeln i "mitten"
			triangle(turtle, order-1, middlePoints[0], middlePoints[1], middlePoints[2]);
			
			// Gör triangeln nere vänster
			triangle(turtle, order-1, p1, middlePoints[0], middlePoints[2]);
			
			// Gör triangel uppe
			triangle(turtle, order-1, p2, middlePoints[1], middlePoints[0]);
			
			// Gör triangel nere höger
			triangle(turtle, order-1, p3, middlePoints[2], middlePoints[1]);
		}
	}
	
	public static void print(Object message) {
		System.out.println(message);
	}
}