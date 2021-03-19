package com.shiyifei.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	/**
	 * Frame窗口类的使用
	 */
	private static final long serialVersionUID = 1L;

	Tank myTank = new Tank(200,200,Dir.DOWN);

	public TankFrame() {
		// 设置窗口大小
		this.setSize(800, 600);
		// 设置能否改变窗口大小
		this.setResizable(false);
		// 设置窗口标题
		this.setTitle("tank war");
		// 设置窗口显示
		this.setVisible(true);

		this.addKeyListener(new MyKeyListener());
		// 添加监听器
		this.addWindowListener(new WindowAdapter() {
			@Override // 重写父类方法的注解
			// 窗口正在关闭触发监听器
			public void windowClosing(WindowEvent e) {
				// 系统退出
				System.exit(0);
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		// 填充一个矩形黑块
//		g.fillRect(200, 200, 50, 50);
//		System.out.println("11");
		
		myTank.paint(g);
		
		
//		x += 10;
//		y += 10;
	}

	class MyKeyListener extends KeyAdapter {

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		// 按键的时候调用
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("222");
//			x += 200;
			// 调用paint方法
//			repaint();
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

		private void setMainTankDir() {
			if (bL) myTank.setDir(Dir.LEFT);
			if (bU) myTank.setDir(Dir.UP);
			if (bR) myTank.setDir(Dir.RIGHT);
			if (bD) myTank.setDir(Dir.DOWN);
		}

		// 松开键的时候调用
		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("3333");
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
		}

	}
}
