package lesson6;

class Cat extends Animal{
    private static int catCount = 0;
    public Cat(String name, int maxRunDistance,  double maxJumpHeight) {
        super(name, maxRunDistance, 0, maxJumpHeight);
        catCount++;
    }
    @Override
    public String toString() {
        return "Кот " + super.toString();
    }
    @Override
    public boolean run(int distance) {
        System.out.printf("Кот ");
        return super.run(distance);
    }
    @Override
    public boolean swim(int distance) {
        System.out.println("Кот " + super.getName() + " не умеет плпвать");
        return false;
    }
    @Override
    public boolean jump(double height) {
        System.out.printf("Кот ");
        return super.jump(height);
    }
    public static int getCatCount() {
        return catCount;
    }
}
