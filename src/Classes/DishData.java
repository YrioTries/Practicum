package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class DishData {
    HashMap<String, ArrayList<String>> food;
    protected DishData(){
        food = new HashMap<>();
    }

    protected void createDish(String dishType, String dishName){
        if (food.containsKey(dishType)){
            System.out.println("Добавили новое блюдо к существующему типу");
            food.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            System.out.println("Добавили новое блюдо к новому типу");
            food.put(dishType, dishes);
        }
    }

    protected void printDish(String dishType){
        if (food.containsKey(dishType)){
            System.out.println(dishType + ": ");

            for (String dish : food.get(dishType)){
                System.out.println(dish);
            }

        } else {
            System.out.println("Такого типа блюда нет");
        }
    }
}
