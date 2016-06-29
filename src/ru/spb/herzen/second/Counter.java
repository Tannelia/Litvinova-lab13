package ru.spb.herzen.second;

public class Counter extends Thread {
    public void run(){
        for(Integer i=1; i<=100; i++){
            System.out.println(i + " - thread: " + this.getName());
        }
    }
}