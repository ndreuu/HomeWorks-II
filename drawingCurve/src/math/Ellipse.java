package math;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class Ellipse extends Curve {
	private double a;
	private double b;

	public Ellipse(double a, double b, Canvas canvas) {
		super(canvas);
		this.a = a;
		this.b = b;
		//super.name = "Ellipse";
	}

	@Override
	public ArrayList<Double> valueY(double x) {
		ArrayList<Double> values = new ArrayList<>();
		double y = Math.sqrt((1 - (x*x) / (a*a)) * (b*b));
		if (y == 0) {
			values.add((double) 0);
			return values;
		}
		values.add(y);
		values.add(-y);
		return values;
	}

	@Override
	public String toString() {
		return "x²/" + a + "² + " + "y²/" + b + "² = " + 1d;
	}
}