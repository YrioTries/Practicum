package Classes;

import Classes.DishData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class LunchData {
    HashMap<String, ArrayList<String>> lunch;
    DishData pullOfDishes;
    Scanner scanner;

    public LunchData(Scanner scan){
        lunch = new HashMap<>();
        pullOfDishes = new DishData();
        scanner = scan;
    }

    private int randomPosition(String lunchType){
        Random random = new Random();
        return random.nextInt(pullOfDishes.food.get(lunchType).size());

    }

    private void createLunch (String lunchName, String dish){
        if(lunch.containsKey(lunchName)){
            lunch.get(lunchName).add(dish);
        }else{
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dish);
            lunch.put(lunchName,dishes);
        }

    }

    public void lunchConstructor() {

        ArrayList<String> types = new ArrayList<>();
        System.out.println("Какие типы блюд должны входить?");
        System.out.println("Чтобы закончить ввод блюд введите 'готово'");
        String dishType;

        do{
            dishType = scanner.next();
            if(pullOfDishes.food.containsKey(dishType)){
                types.add(dishType);
            }else if(!dishType.equals("готово")){
                System.out.println("Нет такого блюда в меню");
            }
        }while (!dishType.equals("готово"));

        HashMap<Integer, ArrayList<String>> combinations = new HashMap<>();
        for (int i = 0; i < 3; i++){
            ArrayList<String> varDish = new ArrayList<>();
            combinations.put(i + 1, varDish);
        }

        for (String type : types){
            combinations.get(1).add(pullOfDishes.food.get(type).get(randomPosition(type)));
            combinations.get(2).add(pullOfDishes.food.get(type).get(randomPosition(type)));
            combinations.get(3).add(pullOfDishes.food.get(type).get(randomPosition(type)));
        }


        for (int num : combinations.keySet()){
            System.out.println("\n================================================");
            System.out.println("Ланч №" + num);
            System.out.println("================================================");
            System.out.println("Состоит из:");
            for(String dish : combinations.get(num)){
                System.out.println(dish);
            }
        }
        System.out.println("Выберите один вариант ланча");
        int command = scanner.nextInt();


        System.out.println("Назовите новый ланч");
        String lunchName = scanner.next();

        lunch.put(lunchName, combinations.get(command));

    }



    public void createNewDish(String dishType,String dishName){
        System.out.println("Блюдо " + dishType + " " + dishName + " добавлено!");
        pullOfDishes.createDish(dishType, dishName);
    }

    public void printDishForLunch(String dishType){
        pullOfDishes.printDish(dishType);
    }

    public void printLunches(){
        int i = 0;
        for(String name : lunch.keySet()){
            System.out.println("\n================================================");
            System.out.println((++i) + ". " + name);
            System.out.println("================================================");
            System.out.println("Состоит из: ");
            for(String dish : lunch.get(name)){
                System.out.println(dish);
            }
        }
    }
}
