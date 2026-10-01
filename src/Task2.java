import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        int n = 300; // Розмір масиву (n >= 300)
        int[] A = new int[n];
        Random rand = new Random();

        // Заповнюємо масив випадковими числами від 1 до 100
        for (int i = 0; i < n; i++) {
            A[i] = rand.nextInt(100) + 1;
        }

        // Знаходимо частоту кожного елемента
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Формуємо новий ущільнений масив тільки з унікальних чисел (які НЕ повторювалися взагалі)
        List<Integer> compressedList = new ArrayList<>();
        for (int num : A) {
            if (countMap.get(num) == 1) {
                compressedList.add(num);
            }
        }

        // Перетворюємо у звичайний масив
        int[] result = compressedList.stream().mapToInt(i -> i).toArray();

        // Друк результату по 5 елементів у рядку
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
}