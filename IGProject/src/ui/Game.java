package ui;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ui.config.MainMenu;
import controler.GameControler;
import controler.PlayMenuControler;

public class Game extends JFrame {

	
	public static int HEIGHT = 400;
	public static int WIDTH = 600;
	static final int FPS = 25;
	static final int SKIP_TICKS = 1000 / FPS;

	long next_game_tick = System.currentTimeMillis();

	long sleep_time = 0;

	private GameStateManager gsm;
	private ResourceBundle config;

	
	
	
	void getSizeFrame(){
		WIDTH = this.getWidth();
		System.out.println("x"+WIDTH);
		System.out.println("y"+HEIGHT);
		HEIGHT = this.getHeight();

	}
	
	
	public Game() {
		gsm = new GameStateManager(this);

		config = ResourceBundle.getBundle("config");
		
		setTitle(config.getString("Title"));
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenuBar();
		
		pack();
		
		addKeyListener(new GameControler());
		while (true) {
			repaint();
			next_game_tick += SKIP_TICKS;
			sleep_time = next_game_tick - System.currentTimeMillis();
			if (sleep_time >= 0) {
				try {
					Thread.sleep(sleep_time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// Shit, we are running behind!
			}
		}
	}
	
	private void resolution(JMenu menu, ButtonGroup buttonGroup, String label, String action){
		JRadioButtonMenuItem item = new JRadioButtonMenuItem(label);
		item.setActionCommand(action);
		buttonGroup.add(item);
		menu.add(item);
	}

	private JMenuItem createItem(String res, KeyStroke accelerator, ActionListener listener) {
		JMenuItem item = new JMenuItem(config.getString(res));
		item.setAccelerator(accelerator);
		item.addActionListener(listener);
		item.setActionCommand(res);
		return item;
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		ActionListener controler = new PlayMenuControler();
		
		JMenu menu = new JMenu(config.getString("Menu.Game"));
		menuBar.add(menu);
		menu.add(createItem("Menu.Game.New", KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK), controler));
		menu.add(createItem("Menu.Game.Restart", null, controler));
		menu.add(createItem("Menu.Game.Pause", KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), controler));
		menu.addSeparator();
		menu.add(createItem("Menu.Game.Save", KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK), controler));
		menu.add(createItem("Menu.Game.Load", KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK), controler));
		menu.addSeparator();
		menu.add(createItem("Menu.Game.Exit", KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK), controler));

		menu = new JMenu(config.getString("Menu.Config"));
		menuBar.add(menu);
		menu.add(createItem("Menu.Config.Keys", null, null));
		menu.add(createItem("Menu.Config.Sound", null, null));
		

		JMenu display = new JMenu(config.getString("Menu.Config.Display")); 
		ButtonGroup buttonGroup = new ButtonGroup();
		resolution(display, buttonGroup, "640 * 360", "360");
		resolution(display, buttonGroup, "1280 * 720", "720");
		resolution(display, buttonGroup, "1920 * 1080", "1080");
		menu.add(display);
		
		menu = new JMenu(config.getString("Menu.Help"));
		menu.add(createItem("Menu.Help.Instruction", null, null));
		menu.add(createItem("Menu.Help.About", null, null));
		menuBar.add(menu);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		gsm.update();
		gsm.render(g);
	}

	public static void main(String[] args) {
		//new Game();
		JFrame f = new JFrame();
		MainMenu m = new MainMenu();
		
		
		f.getContentPane().add(m);
		f.pack();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
