package controler;

import game.Direction;

import java.awt.event.KeyEvent;

public class Input {
	public static boolean[] keys = new boolean[KeyEvent.KEY_LAST];

	public static int update() {
		int dir = Direction.None;

		if (keys[KeysOption.getUp()])
			dir = dir | Direction.North;
		if (keys[KeysOption.getDown()])
			dir = dir | Direction.South;
		if (keys[KeysOption.getLeft()])
			dir = dir | Direction.West;
		if (keys[KeysOption.getRight()])
			dir = dir | Direction.East;

		return dir;
	}

}
