package ru.geekbrains;

public class lesson5 {
    public static void main(String[] args) {
        Employee ivan;
        ivan = new Employee("Ivan", "developer", "mail@ru", "89990000000", 50, 30);
        System.out.println("Инфо о работнике. функция printInfo()");
        ivan.printInfo();

        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89990000000", 30000, 30);
        persArray[1] = new Employee("Petrov Peter", "Developer", "petrov@mailbox.com", "89990000111", 40000, 40);
        persArray[2] = new Employee("Sidorov Sidor", "Manager", "sidorov@mailbox.com", "89990000222", 50000, 50);
        persArray[3] = new Employee("Andreev Andrey", "Manager", "andreev@mailbox.com", "89990000333", 60000, 60);
        persArray[4] = new Employee("Vasiliev Vasiliy", "Manager", "vasiliev@mailbox.com", "89990000444", 70000, 70);

        System.out.println("\nСотрудники старше 40 лет: ");
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                System.out.println(persArray[i].fio + " " + persArray[i].age + " лет.");
            }
        }
    }
}
