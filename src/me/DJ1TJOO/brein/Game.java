package me.DJ1TJOO.brein;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import me.DJ1TJOO.brein.eye.EyeCel;

public class Game extends Canvas implements KeyListener, Runnable {

	private static final long serialVersionUID = 4309126679962647551L;

	// thread
	private Thread thread;
	private boolean running;
	
	private static int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	private Handler handler;

	private int width = 245, height = 245;
	
	public Game() {
		super();
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	public void run() {
		
		handler = new Handler();
		
		Mouse adapter = new Mouse(handler);
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				handler.getEye().add(new EyeCel().setX(i * 45 + 10).setY(j * 45 + 10).setHeight(40).setWidth(40).setOn(true));
			}
		}

		running = true;
		
		long start;
		long elapsed;
		long wait;

		// Gameloop
		while (running) {
			start = System.nanoTime();	
			tick();
			draw();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0)
			{
				wait = 5;
			}			
			try 
			{
				Thread.sleep(wait);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

	}
	
	private void tick() {
		handler.tick();
	}

	private void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(new Color(51, 171, 249));
		g.fillRect(0, 0, width, height);
		
		//////////////////////////////////

		//g2d.translate(-gamepanel.getCamera().getX(), -gamepanel.getCamera().getY());

		handler.draw(g);
		
		//g2d.translate(gamepanel.getCamera().getX(), gamepanel.getCamera().getY());
		
		//////////////////////////////////
		g.dispose();
		bs.show();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
