package ru.stqa.pft.sandbox;

import static ru.stqa.pft.sandbox.Point.*;

/**
 * Created by Sergei on 10.04.2016.
 */
public class CalculateDistance {

    public static void main(String[] args) {
        Point p1 = new Point(5, 25);
        Point p2 = new Point(10, 15);
        System.out.println("Расстояние между двумя точками равно " + distance(p1, p2));
    }
}

