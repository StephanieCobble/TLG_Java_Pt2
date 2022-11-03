/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class RepeatingPrinterTest {

    public static void main(String[] args) {
//        Thread thd1 = new Thread(new RepeatingPrinter()); // RepeatingPrinter IS-A Runnable
//        thd1.start();

        // initialize the 'printer' reference variable with a block lambda
        // hint: you can copy / paste the *contents* of RepeatingPrinter's run() method
        // note: change the sysout to show "block-lambda"
        Runnable printer = () -> {
            while (true) {
                System.out.println("Block Lambda - RepeatingPrinter.run");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        };

        // create another Thread, passing in the 'printer' reference as its Runnable - then start it
//        Thread thd2 = new Thread(printer); // printer IS-A Runnable (as a lambda)
        Thread thd2 = new Thread(() -> {
            while (true) {
                System.out.println("Block Lambda - RepeatingPrinter.run");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }); // printer IS-A Runnable (as a lambda)
        thd2.start();
    }
}