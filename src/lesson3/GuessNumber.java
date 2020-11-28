package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    
    public static void main(String[] args) {
        int num;
        do {
            game();
            num = getNum("Повторить игру еще раз? 1 – да / 0 – нет (1 – повторить, 0 – нет): ");
        } while (num == 1);
    }

    public static int getNum(String s) {
        int num;
        do {
            System.out.print(s);
            num = scanner.hasNextInt() ? scanner.nextInt() : -1;
            if (num == -1) scanner.nextLine();
        } while(num == -1);
        return num;
    }

    public static void game() {
        int rand = random.nextInt(10);
        int tryNum = 1;
        int answ;
        while (tryNum < 4) {
            System.out.println("Загадано: " + rand + ", Попытка № " + tryNum); //Показываю загаданное число для отладки
            answ = getNum("Введите число от 0 до 9: ");
            if (answ > rand) System.out.println("Ваше число больше загаданного");
            else if (answ < rand) System.out.println("Ваше число меньше загаданного");
            else if (answ == rand) {
                System.out.println("Поздравляем вы угадали!!!");
                tryNum = 5;
            }
            tryNum++;
        }
        if (tryNum == 4) System.out.println("К сожалению у вас закончились попытки...");
    }

}