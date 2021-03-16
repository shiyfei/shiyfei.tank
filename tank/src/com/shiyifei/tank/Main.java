package com.shiyifei.tank;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();

		while (true) {
			// 主线程等50ms
			Thread.sleep(50);
			tf.repaint();
		}
	}
}
