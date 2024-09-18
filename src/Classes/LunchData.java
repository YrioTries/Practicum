package Classes;

import Classes.DishData;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void createLunch (ArrayList<String> dishes){
        System.out.println("Введите название ланча");
        String lunchName = scanner.next();

        if(lunch.containsKey(lunchName)){
            System.out.println("Такой ланч уже существует");
        }else{
            lunch.put(lunchName,dishes);
        }
    }

    public void createNewDish(String dishType,String dishName){
        System.out.println("Блюдо " + dishType + " " + dishName + " добавлено!");
        pullOfDishes.createDish(dishType, dishName);
    }

    public void printLunches(){
        int i = 0;
        for(String name : lunch.keySet()){
            System.out.println("\n================================================");
            System.out.println((++i) + ". " + name);
            System.out.println("================================================");
            System.out.print("Состоит из: ");
            for(String dish : lunch.get(name)){
                System.out.print(dish);
            }
        }
    }
}
