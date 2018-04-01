/**
 * 
 */
package cj.rogers.minimumcirclearea.data;

/**
 * @author CJ
 *
 */
public class Circle implements Comparable<Circle> {
	final private Point2D center;
	final private int radius;
	final private int hashCode;

	/**
	 * @param center
	 * @param radius
	 */
	public Circle(Point2D center, int radius) {
		this.center = center;
		this.radius = radius;
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + radius;
		hashCode = result;
	}

	/**
	 * @return the center
	 */
	public Point2D getCenter() {
		return center;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hashCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (radius != other.radius)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [center=" + center.toString() + ", radius=" + radius + "]";
	}

	@Override
	public int compareTo(Circle o) {
		int returnValue = 0;
		if (this.getRadius() < o.getRadius())
			returnValue = -1;
		else if (this.getRadius() > o.getRadius())
			returnValue = 1;
		return returnValue;
	}
}
