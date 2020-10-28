package com.company;

import java.util.Random;

public class PointsCounterThread extends Thread {
    private int numberPointsCircle;
    private final int numberPointsSquare;

    public PointsCounterThread(int pointsAmount) {
        super();
        this.numberPointsCircle = 0;
        this.numberPointsSquare = pointsAmount;
    }

    public int getNumberPointsCircle() {
        return numberPointsCircle;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started!");
        final var random = new Random();

        for (int i = 0; i < numberPointsSquare; ++i) {
            var distance = Math.pow(random.nextDouble(), 2) + Math.pow(random.nextDouble(), 2);
            if (distance <= 1)
                numberPointsCircle++;
        }
        System.out.println(this.getName() + " finished!");
    }
}
