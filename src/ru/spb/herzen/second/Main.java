package ru.spb.herzen.second;

public class Main {
    public static void main(String[] args) {
        CounterSynchronized countOne = new CounterSynchronized();
        CounterSynchronized countTwo = new CounterSynchronized();
        countOne.start();
        countTwo.start();

//        Counter counterOne = new Counter();
//        Counter counterTwo = new Counter();
//        counterOne.start();
//        counterTwo.start();
    }
}
