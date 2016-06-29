package ru.spb.herzen.third;

public class Main {
    public static void main(String[] args) {
        Account accountOne = new Account(1, 1000000);
        Account accountTwo = new Account(2, 1000000);

        accountOne.setReceiver(accountTwo);
        accountTwo.setReceiver(accountOne);

        accountOne.start();
        accountTwo.start();
        try {
            accountOne.join();
            accountTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accountOne.getName() + " have " + accountOne.getMoney() + "rubles");
        System.out.println(accountTwo.getName() + " have " + accountTwo.getMoney() + "rubles");
    }
}
