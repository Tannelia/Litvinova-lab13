package ru.spb.herzen.second;

/**
 * Created by pawheel on 30.06.16.
 */
public class CounterSynchronized extends Thread {
    synchronized public void run(){
        for(Integer i=1; i<=100; i++){
            System.out.println(i + " - thread: " + this.getName());
        }
    }
}
