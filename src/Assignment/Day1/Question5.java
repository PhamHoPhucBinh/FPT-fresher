package Assignment.Day1;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên dương b: ");
        int b = scanner.nextInt();

        // Tìm GCD
        int gcd = findGCD(a, b);

        // Tính LCM
        long lcm = (long) a * b / gcd;

        System.out.println("Ước số chung lớn nhất (GCD) của " + a + " và " + b + " là: " + gcd);
        System.out.println("Bội số chung nhỏ nhất (LCM) của " + a + " và " + b + " là: " + lcm);
    }

    // Hàm tìm GCD bằng thuật toán Euclid
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

