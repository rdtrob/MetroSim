/**
 * Created by robert on 11/26hub/14.
 * * * * * *
 * Wanted to give a go at writing a multi-threaded simulator but after reading the
 * documentation mentioned below I've realised it would take much longer to end
 * up with anything remotely functional.
 * * * * * *
 * <p/>
 * * * * * *
 * Advanced Shortest Paths Algorithms on a Massively-Multithreaded Architecture
 * by Joseph R. Crobak , Jonathan W. Berry , Kamesh Madduri , David A. Bader
 * * * * * *
 * <p/>
 * * * * * *
 * Early Experiences on Accelerating Dijkstra’s Algorithm Using Transactional Memory ∗
 * by Nikos Anastopoulos, Konstantinos Nikas, Georgios Goumas and Nectarios Koziris
 * * * * * *
 */

public class Threads {
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private static class MessageLoopTest
            implements Runnable {
        public void run() {
            String importantInfo[] = {
                    "\"Hope\" is the thing with feathers",
                    "That perches in the soul",
                    "And sings the tune without the words",
                    "And never stops at all,",
                    "-Emily Dickinson"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("Closed before completion");
            }
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Error: %s should be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoopTest());
        t.start();

        threadMessage("Waiting for thread to finish");
        while (t.isAlive()) {
            threadMessage("Still waiting");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }
        threadMessage("Finished");
    }
}
