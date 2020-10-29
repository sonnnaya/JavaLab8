package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ParallelMonteCarloPi {
    private final PointsCounterThread pointsCounter;
    private final ThreadPoolExecutor executor;

    public ParallelMonteCarloPi(int nThreads, int nIterations) {
        this.pointsCounter = new PointsCounterThread(nIterations / nThreads);
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(nThreads);
    }

    public Double estimatePi() throws InterruptedException {
        for (int i = 0; i < executor.getMaximumPoolSize(); ++i)
            executor.execute(pointsCounter);
        executor.shutdown();
        executor.awaitTermination(24L, TimeUnit.HOURS);

        var nPointsCircle = pointsCounter.getNPointsCircle();
        var nPointsSquare = pointsCounter.getNPointsSquare();

        return 4 * Double.valueOf(nPointsCircle) / nPointsSquare;
    }
}
