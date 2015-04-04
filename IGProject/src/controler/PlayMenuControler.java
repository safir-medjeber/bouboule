package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenuControler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Menu.Game.New"))
			System.out.println("New");
		else if (e.getActionCommand().equals("Menu.Game.Restart"))
			System.out.println("Restart");
		else if (e.getActionCommand().equals("Menu.Game.Pause"))
			System.out.println("Pause");
		else if (e.getActionCommand().equals("Menu.Game.Resume"))
			System.out.println("Resume");
		else if (e.getActionCommand().equals("Menu.Game.Save"))
			System.out.println("Save");
		else if (e.getActionCommand().equals("Menu.Game.Load"))
			System.out.println("Load");
		else if (e.getActionCommand().equals("Menu.Game.Exit"))
			System.out.println("Exit");
	}
}
