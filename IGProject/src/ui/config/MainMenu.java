package ui.config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import controler.MainMenuFocusListener;
import controler.MainMenuKeyListener;
import controler.MainMenuListener;
import ui.Game;
import ui.GameState;
import ui.GameStateManager;


public class MainMenu extends GameState {

	public static JButton play;
	public static JButton load;
	public static JButton instructions;
	public static JButton scores;

	MainMenuListener action;
	MainMenuKeyListener keyAction;
	MainMenuFocusListener focusAction;

	public MainMenu(GameStateManager gsm) {
		super(gsm);
		init();		
	}



	void init(){
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"),
				Game.WIDTH_SCREEN, Game.HEIGHT_SCREEN);
		action = new MainMenuListener(gsm);
		keyAction = new MainMenuKeyListener(gsm);
		focusAction	 = new MainMenuFocusListener();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		this.add(wallpaper, gbc);
	}	


	
	
	public void addButtonEvent(JButton btn){
		btn.addActionListener(action);
		btn.addFocusListener(focusAction);
		btn.addKeyListener(keyAction);

	}

	JPanel buttonContainer(){
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridLayout(4,0,25,25));
		play = new DecoratedButton("MainMenu.play",1);	
		load = new DecoratedButton("MainMenu.load",1);
		instructions = new DecoratedButton("MainMenu.instructions",1);
		scores = new DecoratedButton("MainMenu.score",1);

		addButtonEvent(play);
		addButtonEvent(load);
		addButtonEvent(instructions);
		addButtonEvent(scores);
		containerButton.add(play);
		containerButton.add(load);
		containerButton.add(instructions);
		containerButton.add(scores);

		containerButton.setPreferredSize(new Dimension(350, 260));
		containerButton.setMinimumSize(new Dimension(350, 260));
		containerButton.setSize(new Dimension(350, 260));
		containerButton.setOpaque(false);
		return containerButton;

	}





	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
