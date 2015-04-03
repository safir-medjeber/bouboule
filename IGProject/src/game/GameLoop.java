package game;

public class GameLoop {

	private Level level;
	
	public GameLoop(Level level) {
		this.level = level;
	}
	
	public void start(){
		while(!level.isFinished()){
			step();
		}
	}
	
	private void step() {
		
	}
}
