package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class MainClass {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;

    //переменные для findNextPattern()
    public static int iFind = 0, jFind = 0;
    public static int iDirectFind, jDirectFind;

    public static int numOfTurnsAI = 0;
    public static int numOfTurnsHuman = 0;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        SIZE = getInt("Введите размер поля: ");
        DOTS_TO_WIN = getInt("Введите количество символов для победы: ");
        initMap();
        printMap();
        while (true) {
            humanTurn();
            numOfTurnsHuman++;
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            numOfTurnsAI++;
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("☺ ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int i, j;
        do {
            i = getInt("Введите строку: ") - 1;
            j = getInt("Введите столбец: ") - 1;
        } while (!isCellValid(i, j));
        map[i][j] = DOT_X;
    }

    public static int getInt(String s) {
        int result = SIZE + 1;
        do {
            try {
                System.out.println(s);
                int value = sc.nextInt();
                if (value < 1 | value > SIZE) {
                    System.out.println("Число вне диапазона, введите еще раз");
                    continue;
                }
                result = value;
            } catch (NumberFormatException e) {
                System.out.println("Это не число, введите еще раз");
            }
        } while (result == SIZE + 1);
        return result;

    }

    public static boolean isCellValid(int i, int j) {
        if (i < 0 || i >= SIZE || j < 0 || j >= SIZE) return false;
        if (map[i][j] == DOT_EMPTY) return true;
        return false;
    }

    public static void aiTurn() {
        if (findWinTurn()) return;
        else if (blockHumanWin()) return;
        else randomTurn();
    }

    public static boolean findWinTurn() {
        char[] pattern = new char[DOTS_TO_WIN];
        for (int i = 0; i < pattern.length; i++) {//формируем все возможные предпобедные паттерны
            for (int l = 0; l < pattern.length; l++) pattern[l] = DOT_O;
            pattern[i] = DOT_EMPTY;
            if (findNextPattern(0, 0, pattern)) {
                map[iFind + iDirectFind * i][jFind + jDirectFind * i] = DOT_O;
                System.out.println("обнаружена победа кординанаты (" + (iFind + iDirectFind * i + 1) + ", " + (jFind + jDirectFind * i + 1) + ")");
                System.out.println("Компьютер походил в точку (" + (iFind + iDirectFind * i + 1) + ", " + (jFind + jDirectFind * i + 1) + ")");
                return true;
            }
        }
        return false;
    }

    public static boolean blockHumanWin() {
        char[] pattern = new char[DOTS_TO_WIN];
        for (int i = 0; i < pattern.length; i++) {//формируем все возможные предпобедные паттерны
            for (int l = 0; l < pattern.length; l++) pattern[l] = DOT_X;
            pattern[i] = DOT_EMPTY;
            if (findNextPattern(0, 0, pattern)) {
                map[iFind + iDirectFind * i][jFind + jDirectFind * i] = DOT_O;
                System.out.println("заблокирована победа кординанаты (" + (iFind + iDirectFind * i + 1) + ", " + (jFind + jDirectFind * i + 1) + ")");
                System.out.println("Компьютер походил в точку (" + (iFind + iDirectFind * i + 1) + ", " + (jFind + jDirectFind * i + 1) + ")");
                return true;
            }
        }
        return false;
    }

    public static void randomTurn() {
        int i, j;
        do {
            i = rand.nextInt(SIZE);
            j = rand.nextInt(SIZE);
        } while (!isCellValid(i, j));
        map[i][j] = DOT_O;
        System.out.println("Компьютер походил в точку (" + (i + 1) + ", " + (j + 1) + ")");
    }
    public static boolean isMapFull() {
        if ((numOfTurnsHuman + numOfTurnsAI) >= (SIZE * SIZE)) return true;
        else return false;
    }
    public static boolean checkWin(char symb) {
        char[] pattern = new char[DOTS_TO_WIN];
        for (int i = 0; i < pattern.length; i++) pattern[i] = symb; //формируем победный паттерн
        if (findNextPattern(0, 0, pattern)) return true;
        else return false;
    }

    public static boolean findNextPattern(int iStart, int jStart, char[] pattern) {
        // ищет следующую строку pattern в матрице поля начиная с позиции iStart, jStart(предусмотрено на будующее чтобы продолжать поиск)
        // если находит возвращает true начало цепочки будет в позиции iFind, jFind направление в iDirectFind и jDirectFind
        int i = iStart;
        int j = jStart;
        int[][] directions = { {-1, 1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};//8 направлений
        for (; i < SIZE; i++) {
            if (j >= SIZE) j = 0;
            for (; j < SIZE; j++) {
                int iDirect, jDirect;
                for (int d = 0; d < 8; d++) {
                    iDirect = directions[d][0];
                    jDirect = directions[d][1];
                    if (patternDirectCompare(i, j, iDirect, jDirect, pattern)) {
/*для отладки*/         System.out.println("найдена цепочка " + Arrays.toString(pattern) + " в точке (" + (i + 1) + ", " + (j + 1) + ")  направление " + iDirect + ", " + jDirect);
                        iDirectFind = iDirect;
                        jDirectFind = jDirect;
                        iFind = i;
                        jFind = j;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean patternDirectCompare(int i, int j, int iDirect, int jDirect, char[] pattern) {
        //сравнивает переданный pattern с цепочкой символов в матрице поля, начинающейся с позиции i, j в направлении iDirect, jDirect
        //в случае совпадения возвращает true
        boolean DotValid;
        for (int k = 0; k < pattern.length; k++) {

            DotValid = i >= 0 & i < SIZE & j >= 0 & j < SIZE;

            if (DotValid)
                DotValid &= map[i][j] == pattern[k];
            else return false;

            if(DotValid) {
                i += iDirect;
                j += jDirect;
            } else return false;
        }
        return true;
    }
}