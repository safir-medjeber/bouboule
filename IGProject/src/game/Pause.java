package game;

public class Pause extends GameLoopEvent {

	public Pause(Level level) {
		super(level);
	}

	@Override
	void apply() {
		level.pause();
	}

}
