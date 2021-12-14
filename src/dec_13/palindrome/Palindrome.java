package dec_13.palindrome;

import java.util.Scanner;

public class Palindrome {

    public static boolean almostPalindrome(String tester) {
        boolean odd = tester.length() % 2 == 1;
        int mid = tester.length() / 2;

        String left = tester.substring(0, mid);
        String right = (odd) ? tester.substring(mid + 1) : tester.substring(mid);

        int change = 0;
        for (int i = 0; i < mid; i++) {
            if (left.charAt(i) != right.charAt(mid - 1 - i)) {
                change++;
            }
            if (change > 1) break;
        }
        return change == 1;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String in = scnr.nextLine();
        while (!in.equals("*")) {
            System.out.println(almostPalindrome(in));
            in = scnr.nextLine();
        }
        scnr.close();
    }
}
