/*
Program By Davis Shriver
This program generates the fibbonacci sequence with multiple threads.
Last Modified: 3/13/2021
 */

import java.util.*;

public class MultiThreadedFib {
    static int x;
    static int fiboArr[]=new int[100];

    public static void main(String args[])  {

        Scanner input = new Scanner(System.in);
        String s1;
        ThreadClass thread1;

        System.out.print("Input your fibbonacci series' length: ");
        s1 = input.nextLine();
        x = Integer.parseInt(s1);

        thread1 = new ThreadClass();
        thread1.start();

        try {
            thread1.join();
        }
        catch (Exception e) {
        }

        System.out.println("Your fibbonacci numbers: ");

        for(int i = 0; i < x; i++)  {
            System.out.print(fiboArr[i]);
            System.out.print(" ");
        }
    }
}
