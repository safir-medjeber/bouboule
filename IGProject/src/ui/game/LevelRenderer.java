package ui.game;

import game.Enemy;
import game.GameObject;
import game.Level;
import game.LoadLevel;
import game.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;

public class LevelRenderer extends GameState {

	private Level level;
	private int tileSize = 32;
	private BufferedImage background;
	private Graphics2D bg;

	public LevelRenderer(GameStateManager gsm) {
		super(gsm);

		level = LoadLevel.get("test");
		setDoubleBuffered(true);
		camera.setBounds(0, level.getWidth() * tileSize, 0, level.getHeight()
				* tileSize);
		// background = GraphicsEnvironment.getLocalGraphicsEnvironment()
		// .getDefaultScreenDevice().getDefaultConfiguration()
		// .createCompatibleImage(2000, 2000, Transparency.OPAQUE);
		background = GraphicsEnvironment
				.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice()
				.getDefaultConfiguration()
				.createCompatibleImage(Game.WIDTH, Game.HEIGHT,
						Transparency.OPAQUE);

	}

	@Override
	public void init() {
	}

	@Override
	public void render(Graphics g) {
		if (g == null)
			return;
		camera.setPosition(level.getCharacter().getX(), level.getCharacter()
				.getY());
		float offsetX = -camera.getX() + Game.WIDTH / 2;
		float offsetY = -camera.getY() + Game.HEIGHT / 2;

		Graphics2D g2d = (Graphics2D) g;

		bg = (Graphics2D) background.getGraphics();
		bg.setPaint(Color.BLACK);
		bg.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		bg.translate(offsetX, offsetY);

		bg.setPaint(Color.BLUE);
		for (GameObject object : level.getTiles()) 
			object.draw(this);
		for (GameObject object : level.getEnemies()) 
			object.draw(this);

		level.getCharacter().draw(this);

		g2d.drawImage(background, 0, 0, null);
		// g2d.drawImage(background.getScaledInstance(Game.WIDTH, Game.HEIGHT,
		// Image.SCALE_SMOOTH), 0, 0, null);
	}

	public void drawCharacter(GameObject go) {
		bg.setPaint(Color.WHITE);
		bg.fillRect(go.getX(), go.getY(), 32, 32);
	}

	public void drawTile(GameObject go) {
		bg.setPaint(Color.BLUE);
		bg.drawRect(go.getX(), go.getY(), 32, 32);
	}

	public void drawCake(GameObject go) {
		bg.setPaint(Color.YELLOW);
		bg.fillRect(go.getX(), go.getY(), 32, 32);
	}

	public void drawEnemy(GameObject go) {
		bg.setPaint(((Enemy) go).getEnemyColor());
		bg.fillRect(go.getX(), go.getY(), 32, 32);
	}

	@Override
	public void update() {
		level.update();
	}

	@Override
	public void handleInput() {
	}

}
