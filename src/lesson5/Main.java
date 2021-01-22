package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Фролов Иван Павлович", "директор", "ivan_frolov@mailbox.com", "+792312312", 40000, 25);
        employeeArray[1] = new Employee("Стрельников Вячеслав Геннадьевич", "инженер", "strelnikov777@mailbox.com", "+79131223322", 35000, 42);
        employeeArray[2] = new Employee("Цой Анита Александровна", "певица", "chas_spoyu@mailbox.com", "+79836699135", 300000, 45);
        employeeArray[3] = new Employee("Быстрова Татьяна Ивановна", "уборщица", "bistro_uberu@mailbox.com", "+79271231221", 15000, 56);
        employeeArray[4] = new Employee("Корнев Павел Николаевич", "писатель", "kornev_pavel@mailbox.com", "+79779993377", 100000, 38);

        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].age > 40)System.out.println(employeeArray[i]);
            System.out.println();
        }
    }
}
