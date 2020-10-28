package com.company;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var nThreads = 1000;
        var nIterations = 100000000;

        var monteCarlo = new ParallelMonteCarloPi(nThreads, nIterations);

        var startTime = System.currentTimeMillis();
        var result = monteCarlo.estimatePi();
        var endTime = System.currentTimeMillis();

        System.out.println("PI is " + result);
        System.out.println("THREADS " + nThreads);
        System.out.println("ITERATIONS " + nIterations);
        System.out.println("Time " + (endTime - startTime) + " ms");
    }
}
