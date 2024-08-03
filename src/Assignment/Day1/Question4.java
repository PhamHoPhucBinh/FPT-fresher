package Assignment.Day1;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số m: ");
        int m = scanner.nextInt();

        int sum = 0;
        int product = 1;
        int originalM = m;

        while (m > 0) {
            int digit = m % 10;
            sum += digit;
            product *= digit;
            m /= 10;
        }

        System.out.println("Tổng các chữ số của " + originalM + " là: " + sum);
        System.out.println("Tích các chữ số của " + originalM + " là: " + product);
    }
}
