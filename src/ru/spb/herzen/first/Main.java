package ru.spb.herzen.first;

public class Main {
    public static void main(String[] args) {
        Message message = new Message(new Calculator());
        message.start();
    }
}