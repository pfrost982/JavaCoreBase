package lesson5;

public class Employee {
    String name;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                ", Должность: " + position +
                ", email: " + email +
                ",\nТелефонный номер: " + phoneNumber +
                ", Зарплата: " + salary +
                ", Возраст: " + age;
    }
}
