package ru.spb.herzen.third;

import java.util.Random;

class Account extends Thread {
    private int money;
    private int startMoney;
    private Account receiver;

    Account(int accountNumber, int money) {
        this.setName("Accoutn #" + accountNumber);
        this.money = money;
        this.startMoney = money;
    }
    void setReceiver(Account reciever) {
        this.receiver = reciever;
    }
    private int getStartMoney() {
        return startMoney;
    }
    public int getMoney() {
        return this.money;
    }

    public int sendMoney(int money) {
        this.money += money;
        return this.money;
    }
    public int takeMoney(int money) {
        this.money -= money;
        return this.money;
    }

    @Override
    public void run() {
        Random random = new Random();
        int check = receiver.getStartMoney() + this.getStartMoney();
        for (int i = 0; i< 1000; i++) {
            int amount = random.nextInt(money);

            int sender = this.takeMoney(amount);
            int getter = receiver.sendMoney(amount);

            if (sender + getter != check) {
                System.out.println("RaceCondition");
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
