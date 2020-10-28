package com.company;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started!");
        var monteCarlo = new ParallelMonteCarloPi(10, 10000000);
        var result = monteCarlo.estimatePi();
        System.out.println(result.toString());

        System.out.println("Main thread finished!");
//    	var thread =  new PointsCounterThread(10000);
//    	thread.setName("Thread 1");
//    	thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(thread.getNumberPointsCircle());
//		System.out.println(thread.getNumberPointsSquare());
//		System.out.println("Main thread finished");
    }
}
