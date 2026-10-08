import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмір матриці n (n >= 15): ");
        int n = scanner.nextInt();
        double[][] X = new double[n][n];
        double[] Y = new double[n];

        // Введення початкових даних матриці
        System.out.println("Введіть " + (n * n) + " елементів матриці:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                X[i][j] = scanner.nextDouble();
            }
        }

        // Обчислюємо вектор Y
        for (int i = 0; i < n; i++) {
            int firstNegativeIdx = -1;

            // Знаходимо індекс першого від'ємного елемента
            for (int j = 0; j < n; j++) {
                if (X[i][j] < 0) {
                    firstNegativeIdx = j;
                    break;
                }
            }

            if (firstNegativeIdx == -1) {
                Y[i] = -1; // Від'ємного елемента немає
            } else {
                double sum = 0;
                // Сума модулів за першим ВКЛЮЧНО від'ємним елементом
                for (int j = firstNegativeIdx; j < n; j++) {
                    sum += Math.abs(X[i][j]);
                }
                Y[i] = Math.round(sum * 10.0) / 10.0;
            }
        }

        // Виведення результатів
        System.out.println("Вектор Y:");
        System.out.println(Arrays.toString(Y));
    }
}