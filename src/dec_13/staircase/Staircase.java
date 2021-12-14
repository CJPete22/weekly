package dec_13.staircase;

import java.util.Scanner;

public class Staircase {

    public static int waysToClimb(int stairs) {
        int ways = 0;

        if (stairs == 1 || stairs == 0) return 1;
        if (stairs == 2) return 2;

        int past = 1;
        int prev = 1;
        for (int i = 1; i < stairs; i++) {
            ways = past + prev;
            past = prev;
            prev = ways;
        }
        return ways;
    }

    @Deprecated
    public static int longClimb(int stairs) {
        if (stairs == 1 || stairs == 0) return 1;
        if (stairs == 2) return 2;
        return longClimb(stairs - 1) + longClimb(stairs - 2);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int in = scnr.nextInt(); scnr.nextLine();
        while(in >= 0) {
            long startTime = System.nanoTime();
            int r = longClimb(in);
            long endTime = System.nanoTime();
            long rtime = endTime - startTime;
            startTime = System.nanoTime();
            int i = waysToClimb(in);
            endTime = System.nanoTime();
            long itime = endTime - startTime;

            System.out.printf("%s is faster than %s%n %d < %d%n",
                    (rtime < itime) ? "recurse" : "iterate",
                    (rtime > itime) ? "recurse" : "iterate",
                    Math.min(itime, rtime),
                    Math.max(rtime, itime));

            in = scnr.nextInt(); scnr.nextLine();
        }
    }
}
