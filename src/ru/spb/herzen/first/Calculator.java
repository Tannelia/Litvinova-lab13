package ru.spb.herzen.first;

class Calculator extends Thread {
    private boolean completed = true;

    boolean isWorks() {
        return this.completed;
    }
    void endWorks() {
        this.completed = false;
    }
    @Override
    public void run()
    {
        int rnd = 100000000 + (int) (Math.random() * ((999999999 - 100000000) + 1));
        boolean prime = false;
        for (int i = 1; i < Math.sqrt(rnd); i++) {
            if (rnd % i == 0) {
                prime = true;
            }
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(prime)
            System.out.println(rnd + " - простое число");
        else
            System.out.println(rnd + " - сложное число");
        this.endWorks();
    }
}
