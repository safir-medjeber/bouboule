package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import ui.game.LevelRenderer;

public class Tile extends Static {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	public Tile(int x, int y) {
		super(x * WIDTH, y * HEIGHT);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawSpriteTile(this);
	}


}
