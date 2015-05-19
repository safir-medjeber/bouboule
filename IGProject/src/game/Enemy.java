package game;


public abstract class Enemy extends Dynamic implements Beatable {

	protected float life;
	
	public Enemy(Body body) {
		super(body);
	}

	public abstract void strategicMove(Character character);

	public  abstract int determineDirection(Character character);

	@Override
	public void hit(float pow) {
		life -= pow;
	}
	
	@Override
	public boolean isDead() {
		return life < 0;
	}
}
