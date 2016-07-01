package ru.spb.herzen.fourth;

public class Main {
    public static void main(String[] args) {
        MyObject myObjectOne = new MyObject();
        MyObject myObjectTwo = new MyObject();
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myObjectOne) {
                    System.out.println("First Thread lock ObjectOne");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (myObjectTwo) {
                        System.out.println("First Thread lock ObjectTwo");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myObjectTwo) {
                    System.out.println("Second Thread lock ObjectTwo");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (myObjectOne) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Second Thread lock ObjectOne");
                    }
                }
            }
        });
        firstThread.start();
        secondThread.start();
    }

}
