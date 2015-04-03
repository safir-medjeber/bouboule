package ui;
import java.awt.Graphics;
import java.util.Stack;

import ui.game.LevelRenderer;

public class GameStateManager {

	private static final int GAME = 0;

	private Game game;

	private Stack<GameState> gameStates;

	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(GAME);
	}

	public void update() {
		gameStates.peek().update();
	}

	public void render(Graphics g) {
		gameStates.peek().render(g);
	}

	public Game game() {
		return game;
	}

	private GameState getState(int state) {
		switch (state) {
		case GAME:
			return new LevelRenderer(this);
		}
		return null;
	}

	public void setState(int state) {
		popState();
		pushState(state);
	}

	public void pushState(int state) {
		gameStates.push(getState(state));
	}

	public void popState() {
		GameState g = gameStates.pop();
		// g.dispose();
	}

}
