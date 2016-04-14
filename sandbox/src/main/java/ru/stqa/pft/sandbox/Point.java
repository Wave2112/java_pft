package ru.stqa.pft.sandbox;

/**
 * Created by Sergei on 10.04.2016.
 */
public class Point {
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Point(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x1-p2.x1)*(p1.x1-p2.x1) + (p1.y1-p2.y1)*(p1.y1- p2.y1));
    }
}
