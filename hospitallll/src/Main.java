import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Doctor[] doctors = {
                new Doctor("Терапевт", "Доктор Иванов"),
                new Doctor("Хирург", "Доктор Петров"),
                new Doctor("Окулист", "Доктор Сидоров")
        };
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите роль:");
        System.out.println("1. Пациент");
        System.out.println("2. Врач");
        System.out.println("3. Выход из системы");
        int role = scanner.nextInt();

        if (role == 1) {
            System.out.println("Введите ваше имя:");
            String patientName = scanner.next();

            System.out.println("Выберите специализацию врача:");
            for (int i = 0; i < doctors.length; i++) {
                System.out.println((i+1) + ". " + doctors[i].getSpecialization());
            }
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= doctors.length) {
                Doctor selectedDoctor = doctors[choice - 1];
                String time = "10:00";
                int ticketNumber = 1;
                System.out.println("Вы записаны на прием к " + selectedDoctor.getName());
                System.out.println("Время: " + time);
                System.out.println("Номер талона: " + ticketNumber);
            } else {
                System.out.println("Неверный выбор специализации.");
            }

        } else if (role == 2) {
            System.out.println("Доступные действия:");
            System.out.println("1. Просмотреть расписание");
            System.out.println("2. Посмотреть список пациентов");
            int doctorAction = scanner.nextInt();

            if (doctorAction == 1) {
                System.out.println("Ваше расписание на сегодня:");
                for (Doctor doctor : doctors) {
                    System.out.println("Специализация: " + doctor.getSpecialization());
                    System.out.println("Имя врача: " + doctor.getName());
                    System.out.println("Время приема: 10:00");
                    System.out.println("Номер талона: 1");
                    System.out.println();
                }

            }System.out.println("Добро пожаловать в систему управления медицинской клиникой!");

            if (role == 2) {
                System.out.println("Доступные действия:");
                System.out.println("1. Просмотреть расписание");
                System.out.println("2. Посмотреть список пациентов");
                doctorAction = scanner.nextInt();

                if (doctorAction == 1) {
                    System.out.println("Ваше расписание на сегодня:");
                    for (Doctor doctor : doctors) {
                        System.out.println("Специализация: " + doctor.getSpecialization());
                        System.out.println("Имя врача: " + doctor.getName());
                        System.out.println("Время приема: 10:00");
                        System.out.println("Номер талона: 1");
                        System.out.println();
                    }
                } else if (doctorAction == 2) {
                    System.out.println("Список пациентов на сегодня:");
                    for (int i = 0; i < doctors.length; i++) {
                        Doctor doctor = doctors[i];
                        System.out.println("Врач: " + doctor.getName());
                        System.out.println("Специализация: " + doctor.getSpecialization());
                        System.out.println("Пациент: Пациент " + (i + 1));
                        System.out.println();
                    }
                } else {
                    System.out.println("Неверное действие.");
                }
            } else if (role == 3) {
                System.out.println("Спасибо, что воспользовались нашей системой. До свидания!");
            } else {
                System.out.println("Неверная роль. Пожалуйста, выберите 1, 2 или 3.");
            }{
            }
        }}}