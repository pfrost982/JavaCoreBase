package lesson6;

public class Animal {
    private static int animalCount = 0;
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    private double maxJumpHeight;

    public Animal(String name, int maxRunDistance, int maxSwimDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        animalCount++;
    }
    @Override
    public String toString() {
        String info = name + ", Бег: " + maxRunDistance + "м";
        if (maxSwimDistance > 0) {
            info = info + ", Плаванье: " + maxSwimDistance + "м, Прыжок: " + String.format("%.2f", maxJumpHeight) + "м";
        } else {
            info = info + ", не умеет плавать, Прыжок: " + String.format("%.2f", maxJumpHeight) + "м";
        }
        return  info;/*name + ", Бег: " + maxRunDistance + "м, Плаванье: " + maxSwimDistance +
                "м, Прыжок: " + String.format("%.2f", maxJumpHeight) + "м";*/
    }
    public boolean run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " метров");
            return true;
        } else {
            System.out.println(name + " не смог пробежать " + distance + " метров");
            return false;
        }
    }
    public boolean swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " метров");
            return true;
        } else {
            System.out.println(name + " не смог проплыть " + distance + " метров");
            return false;
        }
    }
    public boolean jump(double height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " перепрыгнул препятствие " + String.format("%.2f", height) + " метров");
            return true;
        } else {
            System.out.println(name + " не смог перепрыгнуть " + String.format("%.2f", height) + " метров");
            return false;
        }
    }
    public static int getAnimalCount() {
        return animalCount;
    }
    public String getName() {
        return name;
    }
}
