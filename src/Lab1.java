import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lab1 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = SCANNER.nextLine().trim();

            switch (choice) {
                case "1":
                    task1();
                    break;
                case "2":
                    task2();
                    break;
                case "3":
                    task3();
                    break;
                case "4":
                    task4();
                    break;
                case "0":
                    System.out.println("До побачення!");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("=== Меню завдань ===");
        System.out.println("1. Завдання 1");
        System.out.println("2. Завдання 2");
        System.out.println("3. Завдання 3");
        System.out.println("4. Завдання 4");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");
    }

    private static void task1() {
        System.out.println("--- Варіант 1: double -> double ---");
        System.out.print("Введіть дійсне x: ");
        double x1 = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Введіть дійсне y: ");
        double y1 = Double.parseDouble(SCANNER.nextLine());

        double res1 = x1 * y1
                + (Math.pow(x1 + y1, 3) / (x1 * x1 + y1 * y1)) * (x1 - y1);
        System.out.println("Результат: " + res1);

        System.out.println("\n--- Варіант 2: int -> double ---");
        System.out.print("Введіть ціле x: ");
        int x2 = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Введіть ціле y: ");
        int y2 = Integer.parseInt(SCANNER.nextLine());

        double res2 = (double) x2 * y2 + (Math.pow(x2 + y2, 3) / (double) (x2 * x2 + y2 * y2)) * (x2 - y2);
        System.out.println("Результат: " + res2);

        System.out.println("\n--- Варіант 3: double -> int ---");
        System.out.print("Введіть дійсне x: ");
        double x3 = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Введіть дійсне y: ");
        double y3 = Double.parseDouble(SCANNER.nextLine());

        int res3 = (int) (x3 * y3 + (Math.pow(x3 + y3, 3) / (x3 * x3 + y3 * y3)) * (x3 - y3));
        System.out.println("Результат (приведений до цілого): " + res3);
    }

    private static void task2() {
        System.out.print("Введіть кількість елементів масиву: ");
        int n = Integer.parseInt(SCANNER.nextLine());

        int[] array = new int[n];
        System.out.println("Введіть " + n + " елементів масиву:");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(SCANNER.nextLine());
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int number : array) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        List<Integer> compressedList = new ArrayList<>();
        for (int number : array) {
            if (countMap.get(number) == 1) {
                compressedList.add(number);
            }
        }

        int[] result = compressedList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("Ущільнений масив (по 5 елементів у рядку):");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%6d", result[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        if (result.length % 5 != 0) {
            System.out.println();
        }
    }

    private static void task3() {
        System.out.print("Введіть розмір матриці n (n >= 15): ");
        int n = Integer.parseInt(SCANNER.nextLine());

        if (n < 15) {
            System.out.println("Помилка: n має бути не менше 15.");
            return;
        }

        double[][] matrix = new double[n][n];
        double[] y = new double[n];

        System.out.println("Введіть " + (n * n) + " елементів матриці:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.parseDouble(SCANNER.nextLine());
            }
        }

        for (int i = 0; i < n; i++) {
            int firstNegativeIndex = -1;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    firstNegativeIndex = j;
                    break;
                }
            }

            if (firstNegativeIndex == -1) {
                y[i] = -1;
            } else {
                double sum = 0;

                for (int j = firstNegativeIndex; j < n; j++) {
                    sum += Math.abs(matrix[i][j]);
                }

                y[i] = Math.round(sum * 10.0) / 10.0;
            }
        }

        System.out.println("Вектор Y:");
        System.out.println(Arrays.toString(y));
    }

    private static void task4() {
        System.out.print("Введіть текст: ");
        String inputText = SCANNER.nextLine();

        String[] tokens = inputText.split("(?<=\\b)|(?=\\b)");

        List<String> removedWords = new ArrayList<>();
        StringBuilder remainingText = new StringBuilder();

        for (String token : tokens) {
            if (token.matches("[a-zA-Zа-яА-ЯіІїЇєЄґҐ]+") && hasDoubleLetter(token)) {
                removedWords.add(token);
            } else {
                remainingText.append(token);
            }
        }

        String removedWordsStr = String.join(" ", removedWords);

        System.out.println("Оригінальний текст:\n" + inputText);
        System.out.println("\nВилучені слова (з подвоєнням літер):\n" + removedWordsStr);
        System.out.println("\nЗалишковий текст:\n" + remainingText);
    }

    private static boolean hasDoubleLetter(String word) {
        String lower = word.toLowerCase();

        for (int i = 0; i < lower.length() - 1; i++) {
            if (Character.isLetter(lower.charAt(i))
                    && lower.charAt(i) == lower.charAt(i + 1)) {
                return true;
            }
        }

        return false;
    }
}