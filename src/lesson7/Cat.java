package lesson7;

class Cat {
    private String name;
    private int appetite;

    public Cat(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        int eat = plate.eatFood(appetite);
        System.out.println("Кот " + name + " съел: " + eat + " еды");
        appetite -= eat;
    }

    public void info() {
        if (appetite > 0) {
            System.out.println("Кот " + name + ", голод: " + appetite);
        } else {
            System.out.println("Кот " + name + " сытый");
        }

    }
}
