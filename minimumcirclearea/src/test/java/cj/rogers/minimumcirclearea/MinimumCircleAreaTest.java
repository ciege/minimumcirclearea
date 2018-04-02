/**
 * 
 */
package cj.rogers.minimumcirclearea;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*; 

import cj.rogers.minimumcirclearea.data.Circle;
import cj.rogers.minimumcirclearea.data.Point2D;

/**
 * @author CJ
 *
 */
public class MinimumCircleAreaTest {

	/**
	 * Test method for {@link cj.rogers.minimumcirclearea.MinimumCircleArea#improveCircle(cj.rogers.minimumcirclearea.data.Circle, java.util.List)}.
	 */
	@Test
	public void testImproveCircle() {
		List<Point2D> pointList = Arrays.asList(new Point2D(6,0),new Point2D(4,0),new Point2D(5,0));
		MinimumCircleArea mca = new MinimumCircleArea();
		assertTrue(mca.improveCircle(new Circle(new Point2D(0, 0), 6), pointList).equals(new Circle(new Point2D(1, 0), 5)));
		assertTrue(mca.improveCircle(new Circle(new Point2D(1, 0), 5), pointList).equals(new Circle(new Point2D(2, 0), 4)));
		assertTrue(mca.improveCircle(new Circle(new Point2D(2, 0), 4), pointList).equals(new Circle(new Point2D(3, 0), 3)));
		assertTrue(mca.improveCircle(new Circle(new Point2D(3, 0), 3), pointList).equals(new Circle(new Point2D(4, 0), 2)));
		assertTrue(mca.improveCircle(new Circle(new Point2D(4, 0), 2), pointList).equals(new Circle(new Point2D(5, 0), 1)));
		assertTrue(mca.improveCircle(new Circle(new Point2D(5, 0), 1), pointList).equals(new Circle(new Point2D(5, 0), 1)));
	}
	/**
	 * Test method for {@link cj.rogers.minimumcirclearea.MinimumCircleArea#optimalCircle(cj.rogers.minimumcirclearea.data.Circle, java.util.List)}.
	 */
	@Test
	public void testOptimalCircle() {
		List<Point2D> pointList = Arrays.asList(new Point2D(6,0),new Point2D(4,0),new Point2D(5,0));
		MinimumCircleArea mca = new MinimumCircleArea();
		assertTrue(mca.optimalCircle(new Circle(new Point2D(0, 0), 6), pointList).equals(new Circle(new Point2D(5, 0), 1)));
	}

}
