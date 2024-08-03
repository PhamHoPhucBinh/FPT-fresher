package Assignment.Day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi S: ");
        String S = scanner.nextLine();

        String reverseS = new StringBuilder(S).reverse().toString();
        System.out.println("Chuỗi đảo ngược của S: " + reverseS);

        String uppercaseS = S.toUpperCase();
        String lowercaseS = S.toLowerCase();
        System.out.println("Chữ Hoa của S: " + uppercaseS);
        System.out.println("Chữ thường của S: " + lowercaseS);

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        System.out.println("Bảng tần số xuất hiện của các kí tự trong S:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.print("Nhập vị trí n: ");
        int n = scanner.nextInt();
        System.out.print("Nhập vị trí m: ");
        int m = scanner.nextInt();
        String subStringNM = S.substring(n, m);
        System.out.println("Chuỗi con từ vị trí " + n + " đến " + m + ": " + subStringNM);
    }
}

