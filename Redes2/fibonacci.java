class fibonacci {
    public static void main(String args[]) {
        int a = 0, b = 1, c;

        long startTime = System.nanoTime();

        for (int i = 1; i <= 90000; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}