package controler;

import game.Level;
import game.Levels;
import ui.GameStateManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelTransitionListener implements ActionListener {

    private GameStateManager gsm;

    public LevelTransitionListener(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Win.move")){
            Levels.next();
            gsm.setState(GameStateManager.GAME);
        }

    }
}