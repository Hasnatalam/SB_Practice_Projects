package com.app.multithread;
class MyThread extends Thread {
    static int count = 0;

    public void run() {
        for (int i = 1; i <= 1000; i++) {
            count++;
        }
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(MyThread.count);
    }
}