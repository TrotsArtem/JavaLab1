import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int n = 15; // n >= 15
        double[][] X = new double[n][n];
        double[] Y = new double[n];
        Random rand = new Random();

        // Заповнюємо матрицю випадковими дійсними числами від -10.0 до 10.0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                X[i][j] = Math.round((rand.nextDouble() * 20 - 10) * 10.0) / 10.0;
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