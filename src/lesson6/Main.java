package lesson6;

public class Main {
    final static int ANIMALCOUNT = 10;

    public static void main(String[] args) {
        Animal[] animals = new Animal[ANIMALCOUNT];
        String[] names = {  "Макс", "Бейли", "Чарли", "Бадди", "Рокки", "Джейк", "Джек", "Тоби", "Коди", "Бустер", "Герцог",
                            "Купер", "Райли", "Харлей", "Биар", "Такер", "Мерфи", "Лаки", "Оливер", "Сэм", "Оскар", "Тедди",
                            "Уинстон", "Сэмми", "Шэдоу", "Гизмо", "Бэнтли", "Зевс", "Джексон", "Бакстер", "Бандит", "Гас",
                            "Самсон", "Мило", "Руди", "Луи", "Хантер", "Кейси", "Рокко", "Спаркли", "Джоуи", "Бруно", "Бо",
                            "Дакота", "Максимус", "Ромео", "Бумер", "Люк", "Генри" };
        for (int i = 0; i < ANIMALCOUNT; i++) {
            if ((int) (Math.random() * 2) == 0) {
                animals[i] = new Dog(names[(int) (Math.random() * names.length)], 400 + (int) (Math.random() * 200),
                        5 + (int) (Math.random() * 10), Math.random() * 0.6);
            } else {
                animals[i] = new Cat(names[(int) (Math.random() * names.length)], 100 + (int) (Math.random() * 200),
                        1 + Math.random());
            }
        }
        System.out.println("Список участников:");
        for (int i = 0; i < ANIMALCOUNT; i++) {
            System.out.println(animals[i]);
        }
        System.out.println("\nВсего животных: " + Animal.getAnimalCount() + " Собак: " + Dog.getDogCount() + " Кошек: " + Cat.getCatCount());
        System.out.println("\nНачинаем испытание:");
        for (int i = 0; i < ANIMALCOUNT; i++) {
            int challenge = (int) (Math.random() * 3);
            if (challenge == 0) {
                animals[i].run(200 + (int) (Math.random() * 200));
            } else if (challenge == 1) {
                animals[i].swim(3 + (int) (Math.random() * 10));
            } else {
                animals[i].jump(Math.random() * 1.5);
            }
        }
    }
}
