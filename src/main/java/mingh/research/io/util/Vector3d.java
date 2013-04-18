package mingh.research.io.util;

public class Vector3d {
	
	private String atom;
	
	private double x;
	
	private double y;
	
	private double z;
	
	public Vector3d() {
		atom = "";
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	
	public Vector3d(String atom, double x, double y, double z) {
		this.atom = atom;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String getAtom() {
		return atom;
	}

	public void setAtom(String atom) {
		this.atom = atom;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

		
	@Override
	public String toString() {
		//format geometry and force as comma separated strings 
		return atom + "\t" + x + "\t" + y + "\t" + z;
	}

	public double length() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
}
