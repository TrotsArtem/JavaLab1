import java.util.Scanner;

public class MainMenuFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nМЕНЮ ПРОГРАМИ");
            System.out.println("1. Завдання");
            System.out.println("2. Завдання");
            System.out.println("3. Завдання");
            System.out.println("4. Завдання");
            System.out.println("0. Вихід");
            System.out.print("Оберіть номер: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Введіть ціле число від 0 до 4.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    executeTask1(scanner);
                    break;
                case 2:
                    executeTask2(scanner);
                    break;
                case 3:
                    executeTask3(scanner);
                    break;
                case 4:
                    executeTask4(scanner);
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void executeTask1(Scanner scanner) {
        System.out.println("\nЗАВДАННЯ 1: Обчислення виразу");

        System.out.println("\nВаріант 1 (Вхідні: double, Результат: double):");
        System.out.print("Введіть x (double): ");
        double x1 = scanner.nextDouble();
        System.out.print("Введіть y (double): ");
        double y1 = scanner.nextDouble();
        try {
            double res1 = calculateExpressionReal(x1, y1);
            System.out.printf("Результат: %.4f\n", res1);
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\nВаріант 2 (Вхідні: int, Результат: double):");
        System.out.print("Введіть x (int): ");
        int x2 = scanner.nextInt();
        System.out.print("Введіть y (int): ");
        int y2 = scanner.nextInt();
        try {
            double res2 = calculateExpressionIntToReal(x2, y2);
            System.out.printf("Результат: %.4f\n", res2);
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\nВаріант 3 (Вхідні: double, Результат: int):");
        System.out.print("Введіть x (double): ");
        double x3 = scanner.nextDouble();
        System.out.print("Введіть y (double): ");
        double y3 = scanner.nextDouble();
        try {
            int res3 = calculateExpressionRealToInt(x3, y3);
            System.out.println("Результат (int): " + res3);
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static double calculateExpressionReal(double x, double y) {
        double denominator = x * x + y * y;
        if (denominator == 0) {
            throw new ArithmeticException("Ділення на нуль у знаменнику (x^2 + y^2 = 0).");
        }
        double numerator = Math.pow(x + y, 3);
        return x * y + (numerator / denominator) * (x - y);
    }

    public static double calculateExpressionIntToReal(int x, int y) {
        double denominator = (double) (x * x + y * y);
        if (denominator == 0) {
            throw new ArithmeticException("Ділення на нуль у знаменнику (x^2 + y^2 = 0).");
        }
        double numerator = Math.pow((double)(x + y), 3);
        return (double)(x * y) + (numerator / denominator) * (double)(x - y);
    }

    public static int calculateExpressionRealToInt(double x, double y) {
        return (int) calculateExpressionReal(x, y);
    }

    public static void executeTask2(Scanner scanner) {
        System.out.println("\nЗАВДАННЯ 2: Вилучення чисел, що повторюються");
        System.out.print("Введіть розмір масиву n (n <= 300): ");
        int n = scanner.nextInt();
        if (n <= 0 || n > 300) {
            System.out.println("Некоректний розмір.");
            return;
        }

        int[] a = new int[n];
        System.out.println("Введіть елементи масиву:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    counts[i]++;
                }
            }
        }

        int newSize = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                newSize++;
            }
        }

        int[] compressedA = new int[newSize];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                compressedA[idx++] = a[i];
            }
        }

        System.out.println("\nУщільнений масив (по 5 елементів у рядку):");
        if (compressedA.length == 0) {
            System.out.println("Усі елементи масиву повторювалися, масив порожній.");
            return;
        }

        for (int i = 0; i < compressedA.length; i++) {
            System.out.printf("%-6d", compressedA[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // ================= ЗАВДАННЯ 3 =================
    public static void executeTask3(Scanner scanner) {
        System.out.println("\nЗАВДАННЯ 3: Побудова вектора Y за матрицею X");
        System.out.print("Введіть розмір матриці n (n <= 15): ");
        int n = scanner.nextInt();
        if (n <= 0 || n > 15) {
            System.out.println("Некоректний розмір");
            return;
        }

        double[][] x = new double[n][n];
        System.out.println("Введіть елементи матриці X (по рядках):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = scanner.nextDouble();
            }
        }

        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            int firstNegIndex = -1;
            for (int j = 0; j < n; j++) {
                if (x[i][j] < 0) {
                    firstNegIndex = j;
                    break;
                }
            }

            if (firstNegIndex == -1) {
                y[i] = -1.0;
            } else {
                double sum = 0;
                for (int j = firstNegIndex; j < n; j++) {
                    sum += Math.abs(x[i][j]);
                }
                y[i] = sum;
            }
        }

        System.out.println("\nОтриманий вектор Y:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Y[%d] = %.2f\n", i, y[i]);
        }
    }

    public static void executeTask4(Scanner scanner) {
        scanner.nextLine(); // очищення буфера
        System.out.println("\nЗАВДАННЯ 4: Вилучення слів (фіксований масив)");
        System.out.print("Введіть текст: ");
        String text = scanner.nextLine();

        final int MAX_WORDS = 15;
        String[] removedWords = new String[MAX_WORDS];
        int removedCount = 0;

        StringBuilder remainingText = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        StringBuilder currentNonWord = new StringBuilder();
        boolean inWord = false;

        for (int i = 0; i <= text.length(); i++) {
            char c = (i < text.length()) ? text.charAt(i) : ' ';
            
            if (Character.isLetter(c)) {
                if (!inWord) {
                    if (currentNonWord.length() > 0) {
                        remainingText.append(currentNonWord.toString());
                        currentNonWord.setLength(0);
                    }
                    inWord = true;
                }
                currentWord.append(c);
            } else {
                if (inWord) {
                    String word = currentWord.toString();
                    if (hasDoubleLetters(word)) {
                        if (removedCount < MAX_WORDS) {
                            removedWords[removedCount] = word;
                            removedCount++;
                        }
                    } else {
                        remainingText.append(word);
                    }
                    currentWord.setLength(0);
                    inWord = false;
                }
                currentNonWord.append(c);
            }
        }

        System.out.println("\nВилучені слова (з подвоєнням літер):");
        if (removedCount == 0) {
            System.out.println("Слів з подвоєнням не знайдено");
        } else {
            for (int i = 0; i < removedCount; i++) {
                System.out.print(removedWords[i] + " ");
            }
            System.out.println();
            if (removedCount == MAX_WORDS) {
                System.out.println("Ліміт масиву — 15 слів");
            }
        }

        String cleanedText = cleanExtraSpaces(remainingText.toString());
        System.out.println("\nТекст, що залишився після вилучення:");
        System.out.println(cleanedText);
    }

    public static boolean hasDoubleLetters(String word) {
        String lower = word.toLowerCase();
        for (int i = 0; i < lower.length() - 1; i++) {
            if (lower.charAt(i) == lower.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static String cleanExtraSpaces(String str) {
        StringBuilder sb = new StringBuilder();
        boolean spaceAdded = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isWhitespace(c)) {
                if (!spaceAdded && sb.length() > 0) {
                    sb.append(' ');
                    spaceAdded = true;
                }
            } else {
                sb.append(c);
                spaceAdded = false;
            }
        }
        return sb.toString().trim();
    }
}