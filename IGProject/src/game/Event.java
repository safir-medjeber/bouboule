package game;

public abstract class Event {
	Level level;
	
	public Event(Level level) {
		this.level = level;
	}

	abstract void apply();
}
