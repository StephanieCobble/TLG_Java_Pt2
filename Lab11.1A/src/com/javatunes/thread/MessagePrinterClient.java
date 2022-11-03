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
        MessagePrinter printer2 = new MessagePrinter("Violets are blue", 5, 1500);
        MessagePrinter printer3 = new MessagePrinter("Sugar is sweet", 2, 900);
        MessagePrinter printer4 = new MessagePrinter("And so are you");

        printer1.start(); // if using run: Message Printer: Roses are red & only one at a time:
        //print1
        //print1
        //print1...
        printer2.start();
        printer3.start();
        printer4.start();
    }
}