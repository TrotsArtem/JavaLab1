import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        String inputText = "Hello world! Anna went to the zoo, looking at the balloon and small birds.";

        // Регулярний вираз для розділення тексту на слова та розділові знаки/пробіли
        String[] tokens = inputText.split("(?<=\\b)|(?=\\b)");

        List<String> removedWords = new ArrayList<>();
        StringBuilder remainingText = new StringBuilder();

        for (String token : tokens) {
            // Перевіряємо, чи є лексема словом і чи містить вона подвоєні літери
            if (token.matches("[a-zA-Zа-яА-ЯіІїЇєЄґҐ]+") && hasDoubleLetter(token)) {
                removedWords.add(token);
            } else {
                remainingText.append(token);
            }
        }

        // Формуємо рядок з вилучених слів, розділених пробілами
        String removedWordsStr = String.join(" ", removedWords);

        System.out.println("Оригінальний текст:\n" + inputText);
        System.out.println("\nВилучені слова (з подвоєнням літер):\n" + removedWordsStr);
        System.out.println("\nЗалишковий текст:\n" + remainingText.toString());
    }

    // Метод перевірки наявності подвоєних літер у слові
    private static boolean hasDoubleLetter(String word) {
        String lower = word.toLowerCase();
        for (int i = 0; i < lower.length() - 1; i++) {
            if (Character.isLetter(lower.charAt(i)) && lower.charAt(i) == lower.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}