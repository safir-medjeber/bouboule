package game;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import controler.Input;

public class Level {

	private PhysicalWorld world;
	
	private Character character;
	private List<Enemy> enemies;
	private List<Tile> tiles;
	
	private int width, height;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		
		world = new PhysicalWorld(width, height);
		
		tiles = new LinkedList<Tile>();
		enemies = new LinkedList<Enemy>();
	}

	public Character getCharacter() {
		return character;
	}

	public boolean isFinished() {
		return false;
	}

	public void update() {
		handleInput();
		world.update();
		for (Enemy enemy : enemies)
			enemy.strategicMove(character);

	}

	public void handleInput() {
		Input.update();
		int dir = handleMove();
		character.move(dir, 2);
	}

	private int handleMove() {
		int dir = Direction.None;
		if (Input.up())
			dir = dir | Direction.North;
		if (Input.down())
			dir = dir | Direction.South;
		if (Input.left())
			dir = dir | Direction.West;
		if (Input.right())
			dir = dir | Direction.East;
		return dir;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addCake(int x, int y){
		
	}
	
	public void addTile(int x, int y) {
		Body body = new Body(x, y, 32, 32);
		body.type = BodyType.STATIC;
		world.addBody(body);
		tiles.add(new Tile(body));
	}

	public void addEnemy(int x, int y, Color c) {
		Body body = new Body(x, y, 32, 32);
		body.type = BodyType.DYNAMIC;
		world.addBody(body);
		enemies.add(new Enemy(body, c));
	}
	
	public List<Tile> getTiles(){
		return tiles;
	}

	public void setCharacter(int x, int y) {
		Body body = new Body(x, y, 32, 32);
		body.type = BodyType.DYNAMIC;
		world.addBody(body);
		character = new Character(body);
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

}
