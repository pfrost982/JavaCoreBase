package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class MainClass {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    //переменные для findNextPattern()
    public static char[] chainPatternFind;
    public static int lengthFind;
    public static int iFind = 0, jFind = 0;
    public static int iDirectFind, jDirectFind;

    public static int numOfTurnsAI = 0;
    public static int numOfTurnsHuman = 0;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
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
        chainPatternFind =new char[DOTS_TO_WIN];
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("Q ");
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
            System.out.println("Введите строку: ");
            i = sc.nextInt() - 1;
            System.out.println("Введите столбец: ");
            j = sc.nextInt() - 1;
        } while (!isCellValid(i, j));
        map[i][j] = DOT_X;
    }
    public static void aiTurn() {
        if (findWinTurn()) return;
        else if (blockHumanWin()) return;
        else randomTurn();
    }

    public static boolean findWinTurn() {
        lengthFind = DOTS_TO_WIN;
        for (int i = 0; i < lengthFind; i++) {
            for (int l = 0; l < lengthFind; l++) chainPatternFind[l] = DOT_O;
            chainPatternFind[i] = DOT_EMPTY;
            iFind = 0;
            jFind = 0;
            if (findNextPattern()) {
                map[iFind + iDirectFind * i][jFind + jDirectFind * i] = DOT_O;
                System.out.println("обнаружена победа кординанаты (" + (iFind + iDirectFind * i + 1) + ", " + (jFind + jDirectFind * i + 1) + ")");
                System.out.println("Компьютер походил в точку (" + (iFind + iDirectFind * i + 1) + ", " + (jFind + jDirectFind * i + 1) + ")");
                return true;
            }
        }
        return false;
    }

    public static boolean blockHumanWin() {
        lengthFind = DOTS_TO_WIN;
        for (int i = 0; i < lengthFind; i++) {
            for (int l = 0; l < lengthFind; l++) chainPatternFind[l] = DOT_X;
            chainPatternFind[i] = DOT_EMPTY;
            iFind = 0;
            jFind = 0;
            if (findNextPattern()) {
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

    public static boolean isCellValid(int i, int j) {
        if (i < 0 || i >= SIZE || j < 0 || j >= SIZE) return false;
        if (map[i][j] == DOT_EMPTY) return true;
        return false;
    }
    public static boolean isMapFull() {
        if ((numOfTurnsHuman + numOfTurnsAI) >= (SIZE * SIZE)) return true;
        else return false;
    }
    public static boolean checkWin(char symb) {
        lengthFind = DOTS_TO_WIN;
        iFind = 0;
        jFind = 0;
        for (int i = 0; i < lengthFind; i++) chainPatternFind[i] = symb;
        if (findNextPattern()) return true;
        else return false;
    }

    public static boolean findNextPattern() {
        // ищет следующую строку паттерн chainPatternFind начиная с позиции (iFind, jFind)
        // если находит возвращает true начало цепочки будет в позиции (iFind, jFind) направление в iDirectFind и jDirectFind
        int[][] directions = { {-1, 1}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (iFind = 0; iFind < SIZE; iFind++) {
            for (jFind = 0; jFind < SIZE; jFind++) {
                int iDirect, jDirect;
                for (int d = 0; d < 8; d++) {
                    iDirect = directions[d][0];
                    jDirect = directions[d][1];
                    if (patternDirectCompare(iFind, jFind, iDirect, jDirect, chainPatternFind, lengthFind)) {
                        System.out.println("найдена цепочка " + Arrays.toString(chainPatternFind) + " в точке (" + (iFind + 1) + ", " + (jFind + 1) + ")  направление " + iDirect + ", " + jDirect);
                        iDirectFind = iDirect;
                        jDirectFind = jDirect;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean patternDirectCompare(int i, int j, int iDirect, int jDirect, char[] pattern, int patternLength) {
        boolean DotValid;
        for (int k = 0; k < patternLength; k++) {

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