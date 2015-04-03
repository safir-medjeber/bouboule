package game;

import java.awt.Rectangle;

public class Cake extends Static {
	
	private static final int DIAMETER = 30;

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), DIAMETER, DIAMETER);
	}

}
