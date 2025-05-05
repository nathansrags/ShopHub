package org.example;

public class CountDiv {
    public static void main(String[] args) {
        CountDiv div = new CountDiv();
        int result = div.counting(2, 30, 3);
        System.out.println(result);
    }


    private int counting(int a, int b, int k) {
        int result = 0;
        for (int i = a; i <= b; i++) {
            if (i % k == 0) {
                result++;
            }
        }
        return result;
    }
}
