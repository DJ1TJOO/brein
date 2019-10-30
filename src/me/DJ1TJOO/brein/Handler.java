package me.DJ1TJOO.brein;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import me.DJ1TJOO.brein.eye.EyeCel;

public class Handler {

	private List<EyeCel> eye = new ArrayList<>();
	
	public void tick() {
		for (EyeCel eyeCel : eye) {
			eyeCel.tick();
		}
	}

	public void draw(Graphics g) {
		for (EyeCel eyeCel : eye) {
			eyeCel.draw(g);
		}
	}

	public List<EyeCel> getEye() {
		return eye;
	}

	public void setEye(List<EyeCel> eye) {
		this.eye = eye;
	}
}
