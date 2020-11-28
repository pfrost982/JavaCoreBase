package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessWord {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana",
                          "apricot", "avocado", "broccoli", "carrot",
                          "cherry", "garlic", "grape", "melon",
                          "leak", "kiwi", "mango", "mushroom", "nut",
                          "olive", "pea", "peanut", "pear", "pepper",
                          "pineapple", "pumpkin", "potato"};
        int rand = random.nextInt(words.length);
        String answ = "";
        do {
            System.out.println("Загадано: " + words[rand]); //Показываю загаданное слово для отладки
            answ = getWord("Введите слово: ");
            if (!answ.equals(words[rand])) System.out.println(fillMake(words[rand], answ));

        } while (!answ.equals(words[rand]));
        System.out.println("\nПоздравляю, вы угадали слово!!!");

    }

    public static String getWord(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }

    public static String fillMake(String word, String answ) {
        String fill = "";
        int wordLength;
        int i = 0;
        if (word.length() > answ.length()) wordLength = answ.length();
        else wordLength = word.length();

        for (; i < wordLength; i++) {
            if (word.charAt(i) == answ.charAt(i)) fill = fill + word.charAt(i);
            else fill = fill + "#";
        }
        for (; i < 15 ; i++) fill = fill + "#";

        return fill;
    }
}
