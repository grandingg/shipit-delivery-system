package delivery.app;

import delivery.model.*;
import delivery.interfaces.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> reports = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(80);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(50);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Отследить посылку");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки");
        int weightParcel = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки");
        String adressParcel = scanner.nextLine();
        System.out.println("Введите дату отправки");
        int dayOfSend = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите тип послыки");
        System.out.println("S - стандартная, F - хрупкая, P - скоропортящаяся");
        String typeParcel = scanner.nextLine();

        Parcel parcel = null;

        switch (typeParcel) {
            case "S" -> {
                parcel = new StandardParcel(description, weightParcel, adressParcel, dayOfSend);
                standardBox.addParcel((StandardParcel) parcel);
            }
            case "F" -> {
                parcel = new FragileParcel(description, weightParcel, adressParcel, dayOfSend);
                fragileBox.addParcel((FragileParcel) parcel);
                reports.add((FragileParcel) parcel);
            }
            case "P" -> {

                System.out.println("Введите срок хранения");
                int storageLife = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weightParcel, adressParcel, dayOfSend, storageLife);
                perishableBox.addParcel((PerishableParcel) parcel);
            }
            default -> System.out.println("Вы ввели что-то не то");
        }

        allParcels.add(parcel);
        System.out.println("Посылка успешно добавлена!");
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        for(Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sum = 0;
        for(Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая сумма всех доставок: " + sum);
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

    private static void reportStatus() {
        if(reports.isEmpty()) {
            System.out.println("Нет посылок, которые можно отследить");
        }
        System.out.println("Введите новое местоположение");
        String newLocation = scanner.nextLine();

        for(Trackable parcel : reports) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showBox() {
        System.out.println("Введите тип коробки");
        System.out.println("S - стандартная, F - хрупкая, P - скоропортящаяся");
        String typeBox = scanner.nextLine();

        List<? extends Parcel> parcels = List.of();
        //Добавила List.of() потому что parcels подчёркивалось и IDEA предложила
        switch(typeBox) {
            case "S" -> parcels = standardBox.getAllParcels();
            case "F" -> parcels = fragileBox.getAllParcels();
            case "P" -> parcels = perishableBox.getAllParcels();
            default -> System.out.println("Вы ввели что-то не то");
        }

        if (parcels.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("Сoдержимое коробки: ");
            for(Parcel parcel : parcels) {
                System.out.println(parcel.description + "вес " + parcel.weight + " кг");
            }
        }

    }

}

