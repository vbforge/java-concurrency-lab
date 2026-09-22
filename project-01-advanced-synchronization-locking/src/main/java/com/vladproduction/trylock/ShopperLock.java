package com.vladproduction.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShopperLock extends Thread {

    private int itemsToAdd = 0;
    private static int itemsOnNotepad = 0;
    private static final Lock pencil = new ReentrantLock();

    public ShopperLock(String name) {
        this.setName(name);
    }

    /** ---case 1 (lock)--- */
    /*@Override
    public void run() {
        while (itemsOnNotepad <= 20) {
            if(itemsToAdd > 0){ //add items to shared notepad
                try{
                    pencil.lock();
                    itemsOnNotepad += itemsToAdd;
                    System.out.println(this.getName() + " added " + itemsToAdd + " item(s) to notepad");
                    itemsToAdd = 0;
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    pencil.unlock();
                }
            }else { //look for other things to buy
                try{
                    Thread.sleep(100);
                    itemsToAdd++;
                    System.out.println(this.getName() + " found something to buy");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }*/


    /** ---case 2 (tryLock)--- */
    @Override
    public void run() {
        while (itemsOnNotepad <= 20) {
            if((itemsToAdd > 0) && pencil.tryLock()){ //add items to shared notepad
                try{
                    itemsOnNotepad += itemsToAdd;
                    System.out.println(this.getName() + " added " + itemsToAdd + " item(s) to notepad");
                    itemsToAdd = 0;
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    pencil.unlock();
                }
            }else { //look for other things to buy
                try{
                    Thread.sleep(100);
                    itemsToAdd++;
                    System.out.println(this.getName() + " found something to buy");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }

}