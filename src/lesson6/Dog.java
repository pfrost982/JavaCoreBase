package lesson6;

class Dog extends Animal{
    private static int dogCount = 0;
    public Dog(String name, int maxRunDistance, int maxSwimDistance, double maxJumpHeight) {
        super(name, maxRunDistance, maxSwimDistance, maxJumpHeight);
        dogCount++;
    }
    @Override
    public String toString() {
        return "Пес " + super.toString();
    }
    @Override
    public boolean run(int distance) {
        System.out.printf("Пес ");
        return super.run(distance);
    }
    @Override
    public boolean swim(int distance) {
        System.out.printf("Пес ");
        return super.swim(distance);
    }
    @Override
    public boolean jump(double height) {
        System.out.printf("Пес ");
        return super.jump(height);
    }
    public static int getDogCount() {
        return dogCount;
    }
}
