package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.AbstractCircle;
import de.hska.iwi.ads.interfaces.Vector;

public class Circle extends AbstractCircle {

	public Circle(double radius) {
		super(null, radius);
	}

	public Circle(Vector middlePoint, double radius) {
		super(middlePoint, radius);
	}

	@Override
	public void scale(double factor) {
		if (factor < 0) {
			return;
		}
		radius *= factor;
	}

	@Override
	public double getDimension() {
		return super.getRadius();
	}

	@Override
	public double area() {
		return Math.pow(radius, 2) * Math.PI;
	}

}
