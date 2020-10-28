package com.company;

import java.util.Arrays;

public class ParallelMonteCarloPi {
    private final PointsCounterThread[] threads;
    private final int numberPointsSquare;

    public ParallelMonteCarloPi(int nThreads, int nPoints) {
        this.threads = new PointsCounterThread[nThreads];
        this.numberPointsSquare = nPoints * nThreads;
        for (int i = 0; i < nThreads; ++i)
            this.threads[i] = new PointsCounterThread(nPoints);
    }

    public Double estimatePi() {
        Arrays.stream(threads).forEach(Thread::start);
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        var totalNumberPointsCircle = Arrays.stream(threads).mapToInt(PointsCounterThread::getNumberPointsCircle).sum();
        System.out.println("total number = " + totalNumberPointsCircle);

        return 4 * Double.valueOf(totalNumberPointsCircle) / numberPointsSquare;
    }
}
