package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        var nThreads = getString("Enter number of threads: ");
        var nThreads = 10;
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

    public static int getString(String message) {
        var in = new Scanner(System.in);
        System.out.print(message + "\n");
        return in.nextInt();
    }
}
