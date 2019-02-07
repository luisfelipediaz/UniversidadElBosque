import java.util.*;

class fibonacci {

    static int fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        fib(100000);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
