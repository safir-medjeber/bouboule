package ui;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import ui.config.Background;
import ui.game.Camera;
import utils.AssetsManager;

public abstract class GameState extends JPanel {

	protected static final boolean debug = true;
	
	protected GameStateManager gsm;
	protected Game game;
	protected Camera camera;

	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		this.game = gsm.game();
		this.camera = game.getCamera();
		init();
	}

	public abstract void handleInput();

	public abstract void update(float dt);

	public abstract void init();

	protected static void position(GridBagConstraints gbc, int x, int y, int a,
			int b) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = a;
		gbc.gridwidth = b;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // fin de la ligne
	}

	protected void addBackground(GridBagConstraints gbc, String s) {
		Background wallpaper = new Background(AssetsManager.getTexture(s));
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(wallpaper, gbc);
	}

	public void onBack() {
	}
	public void back() {
	}

	public void resized(int width, int height) {
		
	}


}
