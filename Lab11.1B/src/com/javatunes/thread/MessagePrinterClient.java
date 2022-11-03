/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

    public static void main(String[] args) {
        // create four instances of your thread subclass and start them up
        // rose are red...
        MessagePrinter printer1 = new MessagePrinter("Roses are red", 3, 2500);
        Thread thread1 = new Thread(printer1, "Message Printer 1");

        MessagePrinter printer2 = new MessagePrinter("Violets are blue", 5, 1500);
        Thread thread2 = new Thread(printer2, "Message Printer 2");

        MessagePrinter printer3 = new MessagePrinter("Sugar is sweet", 2, 900);
        Thread thread3 = new Thread(printer3, "Message Printer 3");

        MessagePrinter printer4 = new MessagePrinter("And so are you");
        Thread thread4 = new Thread(printer4, "Message Printer 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}