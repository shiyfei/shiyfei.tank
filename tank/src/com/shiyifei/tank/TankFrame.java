package com.shiyifei.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	/**
	 * Frame窗口类的使用
	 */
	private static final long serialVersionUID = 1L;

	Tank myTank = new Tank(200, 200, Dir.DOWN);

	public TankFrame() {
		// 设置窗口大小
		this.setSize(800, 600);
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

	@Override
	public void paint(Graphics g) {
		// 填充一个矩形黑块
		myTank.paint(g);
	}

	
}
