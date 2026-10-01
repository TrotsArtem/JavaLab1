//package lab1.example.fourth;
import java.util.Scanner;
public class Task4 {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System. out.println("Введіть текст:");
 String text = in.nextLine();
 String[] words = text.split("[ ,.:;-?!]+");
 System.out.println("Слова, які починаються і закінчуються однаковими літерами:");
 for (int i=0;i<words.length;i++){
 String word = words[i];
 if (word.charAt(0)==word.charAt(word.length()-1))
 System.out.print(word + " ");
 }
 in.close();
}
}