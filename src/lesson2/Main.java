package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        invertArray();
        System.out.println();
        fillArray();
        System.out.println();
        changeArray();
        System.out.println();
        fillDiagonal();
        System.out.println();
        findMinMax();
        System.out.println();

        int[] arr = { 0, 1, 5, 0, 3, 2, 0, 11, 11, 2, 3, 5, 1 };
        int balance = checkBalance(arr);
        if (balance == -1) System.out.println("Баланса нет");
        else System.out.println("Баланс между элементами массива " + (balance + 1) + " и " + (balance + 2));
        System.out.println();

        System.out.println(Arrays.toString(arr));
        rollArray(arr, 2);
        System.out.println(Arrays.toString(arr));
        rollArray(arr, -3);
        System.out.println(Arrays.toString(arr));

    }


    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] =1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) if(arr[i] < 6) arr[i] *= 2;
        System.out.println(Arrays.toString(arr));

    }

    public static void fillDiagonal() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            arr[i][i] = 1;
            arr[i][9-i] = 1;
        }
        printArr(arr);
    }


    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void findMinMax() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }

    public static int checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) rightSum += arr[i];
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            rightSum -= arr[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

    public static void rollArray(int[] arr, int n) {
        if (n == 0) return;
        else if (n > 0) for (int i = 1; i <= n; i++) rollRight(arr);
        else for (int i = n; i < 0; i++) rollLeft(arr);
    }

    public static void rollLeft(int[] arr) {
        int first = arr[0];
        for (int i = 0; i < (arr.length - 1); i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    public static void rollRight(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }


}