public class ThreadClass extends Thread {
    public void run()   {
        MultiThreadedFib.fiboArr[0] = 0;
        MultiThreadedFib.fiboArr[1] = 1;

        for (int i = 2; i <  MultiThreadedFib.x; i++) {
                MultiThreadedFib.fiboArr[i] = MultiThreadedFib.fiboArr[i-1] +
                MultiThreadedFib.fiboArr[i-2];
        }
    }
}
