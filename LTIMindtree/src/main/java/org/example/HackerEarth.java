package org.example;

public class HackerEarth {
    int cal = 10;

    public void display() {
        int num = 15;
        Runnable r = new Runnable() {
            final int num = 20;

            @Override
            public void run() {
                int num = 25;
                System.out.println(this.num);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        HackerEarth he = new HackerEarth();
        he.display();
        System.out.println('J' + 'a' + 'v' + 'a');
    }
}
