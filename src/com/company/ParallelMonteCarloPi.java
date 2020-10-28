package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMonteCarloPi {
    private final PointsCounterThread pointsCounter;
    private final ExecutorService executor;

    public ParallelMonteCarloPi(int nThreads, int nIterations) {
        this.pointsCounter = new PointsCounterThread(nIterations / nThreads);
        this.executor = Executors.newFixedThreadPool(nThreads);
    }

    public Double estimatePi() throws InterruptedException {
        executor.execute(pointsCounter);
        executor.shutdown();
        executor.awaitTermination(24L, TimeUnit.HOURS);

        var nPointsCircle = pointsCounter.getNPointsCircle();
        var nPointsSquare = pointsCounter.getNPointsSquare();

        return 4 * Double.valueOf(nPointsCircle) / nPointsSquare;
    }
}
