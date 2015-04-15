package ui.config;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

	private Image img;

	public Background(ImageIcon img) {
		this.img = img.getImage();
	}

	public void paintComponent(Graphics g) {
		/* // Texture
		 * int iw = img.getWidth(this); int ih = img.getHeight(this);
		 * 
		 * for (int x = 0; x < getWidth(); x += iw) for (int y = 0; y <
		 * getHeight(); y += ih) g.drawImage(img, x, y, iw, ih, this);
		 */
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

	}
}