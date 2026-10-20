import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("=== Меню завдань ===");
            System.out.println("1. Завдання 1");
            System.out.println("2. Завдання 2");
            System.out.println("3. Завдання 3");
            System.out.println("4. Завдання 4");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                // Завдання 1: обчислення виразу з різними типами даних
                System.out.println("--- Варіант 1: дійсні вхідні дані, дійсний результат ---");
                System.out.print("Введіть x: ");
                double x1 = Double.parseDouble(scanner.nextLine());
                System.out.print("Введіть y: ");
                double y1 = Double.parseDouble(scanner.nextLine());
                double res1 = x1 * y1 + (Math.pow(x1 + y1, 3) / (x1 * x1 + y1 * y1)) * (x1 - y1);
                System.out.println("Результат: " + res1);

                System.out.println("--- Варіант 2: цілі вхідні дані, дійсний результат ---");
                System.out.print("Введіть ціле x: ");
                int x2 = Integer.parseInt(scanner.nextLine());
                System.out.print("Введіть ціле y: ");
                int y2 = Integer.parseInt(scanner.nextLine());
                double res2 = x2 * (double) y2
                    + (Math.pow((double) x2 + y2, 3)
                    / ((double) x2 * x2 + (double) y2 * y2)) * (x2 - y2);
                System.out.println("Результат: " + res2);

                System.out.println("--- Варіант 3: дійсні вхідні дані, цілий результат ---");
                System.out.print("Введіть x: ");
                double x3 = Double.parseDouble(scanner.nextLine());
                System.out.print("Введіть y: ");
                double y3 = Double.parseDouble(scanner.nextLine());
                int res3 = (int) (x3 * y3
                    + (Math.pow(x3 + y3, 3) / (x3 * x3 + y3 * y3)) * (x3 - y3));
                System.out.println("Результат: " + res3);
                
            } else if (choice.equals("2")) {
                // Завдання 2: видалення елементів, які зустрічаються 1 раз
                System.out.print("Введіть кількість елементів масиву: ");
                int n = Integer.parseInt(scanner.nextLine());
                
                int[] arr = new int[n];
                System.out.println("Введіть елементи:");
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(scanner.nextLine());
                }
                
                // Рахуємо скільки разів кожне число зустрічається простими циклами
                int countUnique = 0;
                for (int i = 0; i < n; i++) {
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (arr[i] == arr[j]) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        countUnique++;
                    }
                }
                
                int[] resArr = new int[countUnique];
                int index = 0;
                for (int i = 0; i < n; i++) {
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (arr[i] == arr[j]) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        resArr[index] = arr[i];
                        index++;
                    }
                }
                
                System.out.println("Результат (по 5 в рядок):");
                for (int i = 0; i < resArr.length; i++) {
                    System.out.print(resArr[i] + "\t");
                    if ((i + 1) % 5 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
                
            } else if (choice.equals("3")) {
                // Завдання 3: матриця
                System.out.print("Введіть розмір матриці n (більше або рівно 15): ");
                int n = Integer.parseInt(scanner.nextLine());
                
                if (n < 15) {
                    System.out.println("Помилка! Треба >= 15.");
                    continue;
                }
                
                double[][] matrix = new double[n][n];
                System.out.println("Введіть елементи матриці:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Double.parseDouble(scanner.nextLine());
                    }
                }
                
                double[] y = new double[n];
                for (int i = 0; i < n; i++) {
                    int firstNegIndex = -1;
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] < 0) {
                            firstNegIndex = j;
                            break;
                        }
                    }
                    
                    if (firstNegIndex == -1) {
                        y[i] = -1;
                    } else {
                        double sum = 0;
                        for (int j = firstNegIndex; j < n; j++) {
                            sum = sum + Math.abs(matrix[i][j]);
                        }
                        y[i] = sum;
                    }
                }
                
                System.out.println("Вектор Y:");
                for (int i = 0; i < n; i++) {
                    System.out.print(y[i] + " ");
                }
                System.out.println();
                
            } else if (choice.equals("4")) {
                // Завдання 4: слова з подвоєнням
                System.out.print("Введіть текст: ");
                String text = scanner.nextLine();
                
                String[] words = text.split(" ");
                String removed = "";
                String left = "";
                
                for (int i = 0; i < words.length; i++) {
                    String w = words[i];
                    boolean hasDouble = false;
                    
                    // Перевіряємо сусідні букви
                    for (int j = 0; j < w.length() - 1; j++) {
                        char c1 = Character.toLowerCase(w.charAt(j));
                        char c2 = Character.toLowerCase(w.charAt(j + 1));
                        if (c1 == c2) {
                            hasDouble = true;
                            break;
                        }
                    }
                    
                    if (hasDouble) {
                        removed = removed + w + " ";
                    } else {
                        left = left + w + " ";
                    }
                }
                
                System.out.println("Вилучені слова: " + removed);
                System.out.println("Залишок: " + left);
                
            } else if (choice.equals("0")) {
                System.out.println("Бувай!");
                scanner.close();
                break;
            } else {
                System.out.println("Неправильний вибір, спробуй ще раз.");
            }
            
            System.out.println();
        }
    }
}