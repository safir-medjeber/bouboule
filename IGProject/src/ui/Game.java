package ui;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controler.GameControler;


public class Game extends JFrame {

    static final int FPS = 25;
  	static final int SKIP_TICKS = 1000 / FPS;

    long next_game_tick = System.currentTimeMillis();

    long sleep_time = 0;

	private GameStateManager gsm;

	public Game() {
		gsm = new GameStateManager(this);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(new GameControler());
		while (true) {
			repaint();
	        next_game_tick += SKIP_TICKS;
	        sleep_time = next_game_tick - System.currentTimeMillis();
	        if( sleep_time >= 0 ) {
				try {
					Thread.sleep(sleep_time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else {
	            // Shit, we are running behind!
	        }
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		gsm.update();
		gsm.render(g);
	}

	public static void main(String[] args) {
		new Game();

	}
	
}
