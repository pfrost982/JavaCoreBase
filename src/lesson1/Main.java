package lesson1;

public class Main {
    public static void main(String[] args) {
        byte b = 15;
        short s = 98;
        int i = 37728;
        long l = 9223372036854775L;
        float f = 28.3F;
        double d = 28.33;
        char c = 'a';
        boolean bool = true;

        System.out.println(calculate(1, 2, 3, 2));

        System.out.println(task10and20(5, 15));

        isPositiveOrNegative(-5);

        System.out.println(isNegative(0));

        greetings("Павел");

        leapYear(700);
        leapYear(800);
        leapYear(804);

    }

    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task10and20(int x1, int x2) {
        return (x1 + x2) >= 10 && (x1 + x2) <= 20;

    }

    public static void isPositiveOrNegative(int x) {
        if(x >= 0) System.out.println("Positive");
        else System.out.println("Negative");
    }

    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int year) {
        if(year % 400 == 0) System.out.println("Високосный, кратно 400");
        else if(year % 100 == 0) System.out.println("Не високосный, кратно 100");
        else System.out.println("Високосный, кратно 4");
    }

}