package com.company;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PointsCounterThread implements Runnable {
    private AtomicInteger nPointsCircle;
    private AtomicInteger nPointsSquare;
    private final int nThreadIteration;

    public PointsCounterThread(int nThreadIteration) {
        this.nPointsCircle = new AtomicInteger(0);
        this.nPointsSquare = new AtomicInteger(0);
        this.nThreadIteration = nThreadIteration;
    }

    public int getNPointsCircle() { return nPointsCircle.intValue(); }

    public int getNPointsSquare() { return nPointsSquare.intValue(); }

    public int calculatePointsCircle() {
        int nPointsCircleTemp = 0;
        final var random = new Random();

        for (int i = 0; i < nThreadIteration; ++i) {
            var distance = Math.pow(random.nextDouble(), 2) + Math.pow(random.nextDouble(), 2);
            if (distance <= 1)
                nPointsCircleTemp++;
        }

        return nPointsCircleTemp;
    }

    @Override
    public void run() {
        var nPointsCircleTemp = calculatePointsCircle();

        nPointsCircle.addAndGet(nPointsCircleTemp);
        nPointsSquare.addAndGet(nThreadIteration);
    }
}
