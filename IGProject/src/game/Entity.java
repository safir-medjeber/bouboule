package game;

import java.awt.Rectangle;

public abstract class Entity {
	
	protected int x, y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	protected void setX(int x) {
		this.x = x;
	}
	
	protected void setY(int y) {
		this.y = y;
	}
	
	abstract public Rectangle getBounds();
		
	public boolean collision(Entity entity) {
		return getBounds().intersects(entity.getBounds());
	}

}
