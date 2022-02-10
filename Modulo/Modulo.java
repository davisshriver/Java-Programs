// Kattis - Modulo (Easy)

import java.util.*;

public class Modulo {
    public static void main(String[] args) {
        int in = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            in = (input.nextInt() % 42);
            if(!nums.contains(in))   {
                nums.add(in);
            }
        }
        System.out.println(nums.size());
    }
}
