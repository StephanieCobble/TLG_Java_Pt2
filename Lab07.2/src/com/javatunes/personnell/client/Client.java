package com.javatunes.personnell.client;

import com.javatunes.personnel.Employee;

class Client {
    public static void main(String[] args) {
        Employee emp = new Employee();
        long begin = System.nanoTime();
        System.out.println(begin);
        emp.work();
        emp.pay();
        long end = System.nanoTime();
        System.out.println(end);

        double elapsedMillis = (end-begin)/1_000_000.0;
        System.out.println(elapsedMillis);
    }
}