package ru.spb.herzen.second;

public class CounterSynchronized extends Thread {
    synchronized public void run(){
        for(Integer i=1; i<=100; i++){
            System.out.println(i + " - thread: " + this.getName());
        }
    }
}
