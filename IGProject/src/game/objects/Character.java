package game.objects;

import game.Beatable;
import game.Weapon;
import game.physics.Body;

import java.awt.image.BufferedImage;

import utils.AssetsManager;

public class Character extends Dynamic implements Beatable {

	private final static float characterSpeed = 5;
	
	private Weapon weapon;
	private float life;

	private boolean invinsible;
	private float invinsibleTime = 1f;
	private float invinsibleTiming = .5f;

	private float slowDownTime = 1f;
	private float slowDownTiming = 1f;

	public Character(Body body) {
		super(body, characterSpeed);
		BufferedImage[] img = AssetsManager.getSprites("character", 4);
		setAnimation(img, 1000 / 12f);
		weapon = Weapon.Pistol;
		life = 100;
	}

	@Override
	public void hit(float pow) {
		if (!invinsible) {
			life -= pow;
			invinsibleTime = 0;
			invinsible = true;
		}
	}

	public void slowDown(float speed) {
		slowDownTime = 0;
		this.speed = speed; 
	}

	@Override
	public boolean isDead() {
		return life < 0;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public void update(float dt) {
		super.update(dt);
		if (invinsibleTime < invinsibleTiming) {
			invinsibleTime += dt / 1000;
			if (invinsibleTime > invinsibleTiming)
				invinsible = false;
		}

		if (slowDownTime < slowDownTiming) {
			slowDownTime += dt / 1000;
			if (slowDownTime > slowDownTiming)
				speed = characterSpeed;
		}
	}
}
