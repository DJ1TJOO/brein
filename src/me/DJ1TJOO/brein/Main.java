package me.DJ1TJOO.brein;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		JFrame window = new JFrame("Brein");
		Canvas canvas = new Game();
		canvas.setSize(500, 500);
		window.add(canvas);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

	
	
}
