package me.DJ1TJOO.brein.v1;

import java.util.ArrayList;
import java.util.List;

import me.DJ1TJOO.brein.eye.EyeCel;

public class Cel {

	private List<EyeCel> locations = new ArrayList<>();
	private boolean on;
	
	public Cel tick() {
		boolean on = true;
		for (EyeCel eyeCel : locations) {
			if(!eyeCel.isOn()) {
				on = false;
			}
		}
		this.on = on;
		return this;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public List<EyeCel> getLocations() {
		return locations;
	}

	public Cel addLocations(EyeCel loc) {
		locations.add(loc);
		return this;
	}

	public Cel removeLocations(EyeCel loc) {
		locations.remove(loc);
		return this;
	}

	public void setLocations(List<EyeCel> locations) {
		this.locations = locations;
	}
	
}
