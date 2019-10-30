package me.DJ1TJOO.brein.eye;

import java.awt.Color;
import java.awt.Graphics;

public class EyeCel {
	private int x,y, width, height;
	private boolean on;
	
	public Integer getX() {
		return this.x;
	}
	
	public Integer getY() {
		return this.y;
	}
	
	public Boolean isOn() {
		return this.on;
	}
  
	public EyeCel tick() {
		return this;
	}

	public EyeCel draw(Graphics g) {
		if(isOn()) {
			g.setColor(Color.WHITE);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillRect(x, y, width, height);
		return this;
	}

	public EyeCel setX(int x) {
		this.x = x;
		return this;
	}

	public EyeCel setY(int y) {
		this.y = y;
		return this;
	}

	public EyeCel setOn(boolean on) {
		this.on = on;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public EyeCel setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public EyeCel setHeight(int height) {
		this.height = height;
		return this;
	}
}
