package lesson7;

public class Plate {
    private int food;

    public Plate() {
        this.food = 0;
    }

    public int eatFood(int food) {
        int eatedFood;
        if (this.food > food) {
            this.food -= food;
            return food;
        } else {
            eatedFood = this.food;
            this.food = 0;
            return eatedFood;
        }
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }

}
