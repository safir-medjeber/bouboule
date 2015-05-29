package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameStateManager;

public class WinListener implements ActionListener {

    private GameStateManager gsm;

    public WinListener(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Win.Menu")){
            gsm.popState();
        }

    }
}
