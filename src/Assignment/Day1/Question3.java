package Assignment.Day1;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();

        double sum = 0.0;
        double factorial = 1.0;

        for (int i = 1; i <= n; i++) {
            factorial *= (2 * i - 1); // Tính giai thừa (2n-1)!
            sum += 1.0 / factorial;
        }

        System.out.println("Tổng S = " + sum);
    }
}
