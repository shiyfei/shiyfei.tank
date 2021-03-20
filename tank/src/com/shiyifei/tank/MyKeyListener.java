package com.shiyifei.tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {

	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;
	private Tank myTank = new Tank();

	public MyKeyListener(Tank myTank) {
		this.myTank = myTank;
	}

	// 按键的时候调用
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("222");
//		x += 200;
		// 调用paint方法
//		repaint();
		// 获取按键的code
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		}
		setMainTankDir();
	}

	// 松开键的时候调用
	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("3333");
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		}
		setMainTankDir();
	}

	private void setMainTankDir() {
		if (!bL && !bU && !bR && !bD) {
			this.myTank.setMoving(false);
		} else {
			this.myTank.setMoving(true);
		}
		if (bL)
			myTank.setDir(Dir.LEFT);
		if (bU)
			myTank.setDir(Dir.UP);
		if (bR)
			myTank.setDir(Dir.RIGHT);
		if (bD)
			myTank.setDir(Dir.DOWN);
	}
}
