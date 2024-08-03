package Assignment.Day1;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        String binary = convertToBinary(n);
        System.out.println("Số " + n + " trong hệ nhị phân là: " + binary);
    }

    // Hàm chuyển đổi số nguyên sang chuỗi hệ nhị phân
    public static String convertToBinary(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int digit = n % 2;
            result.insert(0, digit); // Chèn từ phải qua trái
            n /= 2;
        }
        return result.toString();
    }
}
