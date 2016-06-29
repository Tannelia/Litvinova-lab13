package ru.spb.herzen.first;

public class Message extends Thread {
    private Calculator calculator;
    public Message(Calculator calculator) {
        this.calculator = calculator;
        this.calculator.start();
    }
    @Override
    public void run() {
        while(this.calculator.isWorks()) {
            System.out.println("Works");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
