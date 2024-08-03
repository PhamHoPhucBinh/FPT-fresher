package Assignment.Day1;

import java.util.Scanner;

public class Question1 {
    // TODO: 8/3/2024 bài 1: tam giác * bên trái 6 dòng
    public static void main(String[] args) {
        int n = 6; // Chiều cao của tam giác
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
