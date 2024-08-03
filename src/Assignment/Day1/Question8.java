package Assignment.Day1;

import java.util.Arrays;
import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
        }

        int sumPositiveOdd = 0;
        for (int num : a) {
            if (num > 0 && num % 2 != 0) {
                sumPositiveOdd += num;
            }
        }
        System.out.println("Tổng số dương lẻ của mảng a: " + sumPositiveOdd);

        System.out.print("Nhập phần tử k: ");
        int k = scanner.nextInt();
        boolean found = false;
        System.out.print("Vị trí của k trong mảng a: ");
        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy k trong mảng a.");
        }

        Arrays.sort(a);
        System.out.println("Mảng a sau khi sắp xếp: " + Arrays.toString(a));

        System.out.print("Nhập số p: ");
        int p = scanner.nextInt();
        int[] newArray = new int[n + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < p) {
                newArray[index++] = a[i];
            } else {
                break;
            }
        }
        newArray[index] = p;
        for (int i = index + 1; i < n + 1; i++) {
            newArray[i] = a[i - 1];
        }
        System.out.println("Mảng a sau khi chèn số p: " + Arrays.toString(newArray));
    }
}
