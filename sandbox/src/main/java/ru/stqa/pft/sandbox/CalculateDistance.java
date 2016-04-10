package ru.stqa.pft.sandbox;

/**
 * Created by Sergei on 10.04.2016.
 */
public class CalculateDistance {

    public static void main(String[] args) {
        Point calculate = new Point(10, 12, 25, 30);
        System.out.println("Расстояние между двумя точками равно " + calculate.distance());
    }
}

