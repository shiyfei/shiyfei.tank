package com.shiyifei.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	/**
	 * Frame窗口类的使用
	 */
	private static final long serialVersionUID = 1L;

	Tank myTank = new Tank(200, 200, Dir.DOWN, this, false);
	private Bullet b = new Bullet(300, 300, Dir.DOWN);

	public Bullet getB() {
		return b;
	}

	public void setB(Bullet b) {
		this.b = b;
	}

	Image offScreenImage = null;

	static final int GAME_WIDTH = 800, GAME_HEIGTH = 600;

	public TankFrame() {
		// 设置窗口大小
		this.setSize(GAME_WIDTH, GAME_HEIGTH);
		// 设置能否改变窗口大小
		this.setResizable(false);
		// 设置窗口标题
		this.setTitle("tank war");
		// 设置窗口显示
		this.setVisible(true);

		this.addKeyListener(new MyKeyListener(myTank));
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

	// 用双缓存方法解决闪烁问题(游戏引擎自动封装)
	// 将画面先画到内存里，画完之后再一下显示到屏幕上
	// 画面更新的时候会调用update方法
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			// 内存里面创建同样大小的图片
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGTH);
		}

		Graphics gOffScreen = offScreenImage.getGraphics();

		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.WHITE);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGTH);
		gOffScreen.setColor(c);

		this.paint(gOffScreen);
		// 将内存画好的画面显示到屏幕上
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g) {

		this.myTank.paint(g);
		if (this.myTank.isFiring()) {
			this.b.paint(g);
		}

	}

}
