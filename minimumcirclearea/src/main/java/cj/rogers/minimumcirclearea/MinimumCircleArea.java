/**
 * 
 */
package cj.rogers.minimumcirclearea;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

import cj.rogers.minimumcirclearea.data.Circle;
import cj.rogers.minimumcirclearea.data.Point2D;

/**
 * @author CJ
 *
 */
public class MinimumCircleArea {

	Function<Double, Integer> roundUp = d -> (d % 1 == 0) ? (int) (d / 1) : (int) (d / 1 + 1);

	Function<Point2D, List<Point2D>> calcAdjacentPoints = p -> Arrays.asList(new Point2D(p.getX() - 1, p.getY() + 1),
			new Point2D(p.getX(), p.getY() + 1), new Point2D(p.getX() + 1, p.getY() + 1),
			new Point2D(p.getX() - 1, p.getY()), new Point2D(p.getX() + 1, p.getY()),
			new Point2D(p.getX() - 1, p.getY() - 1), new Point2D(p.getX(), p.getY() - 1),
			new Point2D(p.getX() + 1, p.getY() - 1));

	BiFunction<Point2D, Point2D, Integer> calcDistance = (startPoint, endPoint) -> roundUp
			.apply(sqrt(pow(endPoint.getX() - startPoint.getX(), 2) + pow(endPoint.getY() - startPoint.getY(), 2)));

	BiFunction<Point2D, List<Point2D>, Optional<Integer>> maxDistance = (center, pointList) -> pointList.stream()
			.map(p -> calcDistance.apply(center, p)).max(Integer::compareTo);

	BiPredicate<Circle, Point2D> isPointInclosed = (c, p) -> (c.getRadius() >= calcDistance.apply(c.getCenter(), p));

	public Circle improveCircle(Circle circle, List<Point2D> pointList) {
		List<Point2D> inclosedPointList = pointList.stream().filter(p -> isPointInclosed.test(circle, p))
				.collect(toList());

		List<Circle> adjacentCircleList = calcAdjacentPoints.apply(circle.getCenter()).stream()
				.map(p -> new Circle(p, maxDistance.apply(p, inclosedPointList).orElse(circle.getRadius())))
				.collect(toList());

		Circle smallestAdjacentCircle = adjacentCircleList.stream()
				.filter(c -> inclosedPointList.stream().allMatch(p -> isPointInclosed.test(c, p)))
				.min(Circle::compareTo).orElse(circle);

		return smallestAdjacentCircle.compareTo(circle) < 0 ? smallestAdjacentCircle : circle;
	}

	public Circle optimalCircle(Circle circle, List<Point2D> pointList) {
		Circle givenCircle = circle;
		Circle returnCircle = null;
		while (!givenCircle.equals(returnCircle)) {
			if (returnCircle != null) {
				givenCircle = returnCircle;
			}
			returnCircle = improveCircle(givenCircle, pointList);
		}

		return returnCircle;
	}

}
