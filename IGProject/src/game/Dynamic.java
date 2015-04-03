package game;

public abstract class Dynamic extends Entity {

	void move(int dir, int distance) {
		if ((dir & Direction.North) == Direction.North)
			y -= distance;
		if ((dir & Direction.South) == Direction.South)
			y += distance;
		if ((dir & Direction.East) == Direction.East)
			x += distance;
		if ((dir & Direction.West) == Direction.West)
			x -= distance;


	}

}
