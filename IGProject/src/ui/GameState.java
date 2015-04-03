package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameState extends JPanel {
	
    private GameStateManager gsm;

	protected GameState(GameStateManager gsm){
    	this.gsm = gsm;
    }
    
    public abstract void handleInput();

    public abstract void update();

	public abstract void render(Graphics g);
}
