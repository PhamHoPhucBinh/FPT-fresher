package Assignment.Day2.Util;

import java.util.Scanner;

public class CommonUtil {
    public static int getChoice(int from, int to) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;

        while (res < from || res > to) {
            System.out.printf("Input your choice from %s to %s:", from, to);
            while (!scanner.hasNextInt()) {
                System.out.printf("Your choice have to a number. Please input again:");
                scanner.nextLine();
            }
            res = scanner.nextInt();
        }

        return res;
    }
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
