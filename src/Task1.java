import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Вхідні дані — дійсного типу (double), результат — дійсного (double)
        System.out.println("--- Варіант 1: double -> double ---");
        System.out.print("Введіть дійсне x: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введіть дійсне y: ");
        double y1 = scanner.nextDouble();

        double res1 = x1 * y1 + (Math.pow(x1 + y1, 3) / (x1 * x1 + y1 * y1)) * (x1 - y1);
        System.out.println("Результат: " + res1);

        // 2) Вхідні дані — цілого типу (int), результат — дійсного (double)
        System.out.println("\n--- Варіант 2: int -> double ---");
        System.out.print("Введіть ціле x: ");
        int x2 = scanner.nextInt();
        System.out.print("Введіть ціле y: ");
        int y2 = scanner.nextInt();

        double res2 = (double) x2 * y2 + (Math.pow(x2 + y2, 3) / (double) (x2 * x2 + y2 * y2)) * (x2 - y2);
        System.out.println("Результат: " + res2);

        // 3) Вхідні дані — дійсного типу (double), результат — цілого (int)
        System.out.println("\n--- Варіант 3: double -> int ---");
        System.out.print("Введіть дійсне x: ");
        double x3 = scanner.nextDouble();
        System.out.print("Введіть дійсне y: ");
        double y3 = scanner.nextDouble();

        int res3 = (int) (x3 * y3 + (Math.pow(x3 + y3, 3) / (x3 * x3 + y3 * y3)) * (x3 - y3));
        System.out.println("Результат (приведений до цілого): " + res3);

        scanner.close();
    }
}