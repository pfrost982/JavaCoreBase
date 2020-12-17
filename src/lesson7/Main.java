package lesson7;

public class Main {
    final static int CATCOUNT = 10;

    public static void main(String[] args) {
        Cat[] cats = new Cat[CATCOUNT];
        String[] names = {"Макс", "Бейли", "Чарли", "Бадди", "Рокки", "Джейк", "Джек", "Тоби", "Коди", "Бустер", "Герцог",
                "Купер", "Райли", "Харлей", "Биар", "Такер", "Мерфи", "Лаки", "Оливер", "Сэм", "Оскар", "Тедди",
                "Уинстон", "Сэмми", "Шэдоу", "Гизмо", "Бэнтли", "Зевс", "Джексон", "Бакстер", "Бандит", "Гас",
                "Самсон", "Мило", "Руди", "Луи", "Хантер", "Кейси", "Рокко", "Спаркли", "Джоуи", "Бруно", "Бо",
                "Дакота", "Максимус", "Ромео", "Бумер", "Люк", "Генри"};
        for (int i = 0; i < CATCOUNT; i++) {
            cats[i] = new Cat(names[(int) (Math.random() * names.length)]);
        }
        System.out.println("У котов появился аппетит:\n");
        for (int i = 0; i < CATCOUNT; i++) {
            cats[i].setAppetite((int) (Math.random() * 10) + 1);
            cats[i].info();
        }
        Plate plate = new Plate();
        plate.addFood((int) (Math.random() * 100) + 1);
        System.out.println();
        plate.info();
        System.out.println("Коты приступили к трапезе... \n");
        for (int cat = 0; cat < CATCOUNT; cat++) {
            cats[cat].eat(plate);
        }
        System.out.println();
        plate.info();
        System.out.println("Результат кормления:\n");
        for (int i = 0; i < CATCOUNT; i++) {
            cats[i].info();
        }
    }
}
