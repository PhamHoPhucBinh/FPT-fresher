package Assignment.Day1;

import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng (m): ");
        int m = scanner.nextInt();
        System.out.print("Nhập số cột (n): ");
        int n = scanner.nextInt();

        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhập phần tử A[" + i + "][" + j + "]: ");
                A[i][j] = scanner.nextInt();
            }
        }

        int productFirstRow = 1;
        for (int j = 0; j < n; j++) {
            if (A[0][j] % 3 == 0) {
                productFirstRow *= A[0][j];
            }
        }
        System.out.println("Tích các số là bội số của 3 trên dòng đầu tiên: " + productFirstRow);

        int[] X = new int[m];
        for (int i = 0; i < m; i++) {
            int maxRowValue = A[i][0];
            for (int j = 1; j < n; j++) {
                if (A[i][j] > maxRowValue) {
                    maxRowValue = A[i][j];
                }
            }
            X[i] = maxRowValue;
        }

        System.out.print("Mảng X: ");
        for (int value : X) {
            System.out.print(value + " ");
        }
    }
}
