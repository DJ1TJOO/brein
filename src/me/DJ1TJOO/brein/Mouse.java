package me.DJ1TJOO.brein;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import me.DJ1TJOO.brein.eye.EyeCel;

public class Mouse extends MouseAdapter {

	private Handler handler;
	
	public Mouse(Handler handler) {
		this.handler = handler;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		for (EyeCel eyeCel : handler.getEye()) {
			if(isMouseIn(mx, my, eyeCel.getX(), eyeCel.getY(), eyeCel.getWidth(), eyeCel.getHeight())) {
				eyeCel.setOn(!eyeCel.isOn());
			}
		}
	}
	
	public boolean isMouseIn(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
