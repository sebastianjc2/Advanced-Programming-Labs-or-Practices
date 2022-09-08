import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Flake {
	Point2D start;
	Point2D end;

	public Flake(Point2D start, Point2D end) {
		this.start = start;
		this.end = end;
	}

	public Point2D getStart() {
		return start;
	}

	public Point2D getEnd() {
		return end;
	}

	public void setStart(Point2D start) {
		this.start = start;
	}

	public void setEnd(Point2D end) {
		this.end = end;
	}

	public Point2D getA() {
		return start;
	}

	public Line2D getLine2D() {
		return new Line2D.Double(start, end);
	}

	public Point2D getB() {
		double x = (end.getX()-start.getX())/3.0 + start.getX();
		double y = (end.getY()-start.getY())/3.0 + start.getY();
		return new Point2D.Double(x, y);
	}

	public Point2D getC() {
		Point2D v1 = this.getB();
		Point2D v2 = new Point2D.Double((end.getX()-start.getX())/3.0, (end.getY()-start.getY())/3.0);
		v2 = this.rotate(v2, Math.toRadians(-60.0));
		return new Point2D.Double(v1.getX()+v2.getX(), v1.getY()+v2.getY());
	}

	public Point2D getD() {
		double x = 2.0*(end.getX()-start.getX())/3.0 + start.getX();
		double y = 2.0*(end.getY()-start.getY())/3.0 + start.getY();
		return new Point2D.Double(x, y);
	}

	public Point2D getE() {
		return end;
	}
	public Point2D rotate(Point2D v, double theta) {
		double x = v.getX()*Math.cos(theta) - v.getY()*Math.sin(theta);
		double y = v.getX()*Math.sin(theta) + v.getY()*Math.cos(theta);
		return new Point2D.Double(x, y);
	}
}