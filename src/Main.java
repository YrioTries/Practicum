import Classes.LunchData;

import java.util.Scanner;
import Classes.LunchData;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LunchData lunchManager = new LunchData(scanner);
        String dishType;

        while (true){
            getMenu();

            System.out.print("--> ");
            int command = scanner.nextInt();
            System.out.println("\n");

            switch (command) {
                case 1:
                    System.out.println("Введите тип блюда:");
                    dishType = scanner.next();
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.next();
                    lunchManager.createNewDish(dishType,dishName);
                    break;

                case 2:
                    System.out.println("Введите тип блюда:");
                    dishType = scanner.next();
                    lunchManager.printDishForLunch(dishType);
                    break;

                case 3:
                    lunchManager.printLunches();
                    break;

                case 4:
                    lunchManager.lunchConstructor();
                    break;

                case 5:
                    System.out.println("До новых встреч!");
                    return;

                default:
                    System.out.println("Неизвестная команда!");
            }
        }
    }
    public static void getMenu(){
        System.out.println("\nВведите код команды:");
        System.out.println("1. Ввести новое блюдо");
        System.out.println("2. Посмотреть список блюд");
        System.out.println("3. Посмотреть меню ланчей");
        System.out.println("4. Создать ланч");
        System.out.println("5. Выйти из приложения");
    }
}