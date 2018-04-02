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
	 * Test method for {@link cj.rogers.minimumcirclearea.MinimumCircleArea#minimumCircleArea(cj.rogers.minimumcirclearea.data.Circle, java.util.List)}.
	 */
	@Test
	public void testMinimumCircleArea() {
		List<Point2D> pointList = Arrays.asList(new Point2D(6,0),new Point2D(4,0),new Point2D(5,0));
		MinimumCircleArea mca = new MinimumCircleArea();
		assertTrue(mca.minimumCircleArea(new Circle(new Point2D(0, 0), 6), pointList).equals(new Circle(new Point2D(1, 0), 5)));
		assertTrue(mca.minimumCircleArea(new Circle(new Point2D(1, 0), 5), pointList).equals(new Circle(new Point2D(2, 0), 4)));
		assertTrue(mca.minimumCircleArea(new Circle(new Point2D(2, 0), 4), pointList).equals(new Circle(new Point2D(3, 0), 3)));
		assertTrue(mca.minimumCircleArea(new Circle(new Point2D(3, 0), 3), pointList).equals(new Circle(new Point2D(4, 0), 2)));
		assertTrue(mca.minimumCircleArea(new Circle(new Point2D(4, 0), 2), pointList).equals(new Circle(new Point2D(5, 0), 1)));
		assertTrue(mca.minimumCircleArea(new Circle(new Point2D(5, 0), 1), pointList).equals(new Circle(new Point2D(5, 0), 1)));
	}

}
