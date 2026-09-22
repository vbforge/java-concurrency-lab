package com.vladproduction.trylock;


public class TryLockDemo {
    public static void main(String[] args) throws InterruptedException {

        ShopperLock customer1 = new ShopperLock("Customer#1");
        ShopperLock customer2 = new ShopperLock("Customer#2");

        long startTime = System.currentTimeMillis();

        customer1.start();
        customer2.start();

        customer1.join();
        customer2.join();

        long endTime = System.currentTimeMillis();

        System.out.println("Time elapsed: " + (float)(endTime - startTime)/1000 + " seconds");

        //case 1: used pencil.lock();
        //Time elapsed: 6.624 seconds

        //case 2: used
        //Time elapsed: 2.663 seconds
    }
}


