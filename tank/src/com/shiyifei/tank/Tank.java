package com.shiyifei.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x, y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED = 5;
	private boolean moving = false;
	private boolean firing = false;
	private TankFrame tf;

	public Tank() {

	}

	public Tank(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public Tank(int x, int y, Dir dir, TankFrame tf, boolean firing) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.firing = firing;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
		g.setColor(c);
		this.move();

	}

	private void move() {
		if (!moving) {
			return;
		}
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
	}

	public void fire() {
		this.setFiring(true);
		this.tf.getBullets().add(new Bullet(this.x, this.y, this.dir, this.tf));
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public boolean isFiring() {
		return firing;
	}

	public void setFiring(boolean firing) {
		this.firing = firing;
	}
}
