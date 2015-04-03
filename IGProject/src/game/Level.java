package game;

import controler.Input;

public class Level {
	
	private Character character;
	private Enemy[] enemies; 

	public Level() {
		character = new Character();
	}

	public void pause() {
		
	}

	public Character getCharacter() {
		return character;
	}

	public Enemy[] getEnemies() {
		return enemies;
	}

	public boolean isFinished() {
		return false;
	}

	public void update() {
		handleInput();
	}
	
	public void handleInput() {
		int dir = Input.update();
		character.move(dir, 1);
	}
}
