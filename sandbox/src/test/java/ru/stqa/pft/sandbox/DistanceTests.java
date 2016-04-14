package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Sergei on 14.04.2016.
 */
public class DistanceTests {
    /**
     * Тесты метода вычисления расстояния между двумя точками
     */
    @Test
    public void testDistance1() {
        Point p1 = new Point(22, 33);
        Point p2 = new Point(10, 17);
        assertEquals(Point.distance(p1, p2), 20.0, "Ошибка вычисления расстояния между точками");
    }

    @Test
    public void testDistance2() {
        Point p1 = new Point(10, 7);
        Point p2 = new Point(1, 50);
        assertEquals(Point.distance(p1, p2), 43.93176527297759, "Ошибка вычисления расстояния между точками");
    }

}
