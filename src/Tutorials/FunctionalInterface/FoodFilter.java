package Tutorials.FunctionalInterface;
import java.util.*;
import java.util.function.Predicate;

public class FoodFilter {
    public static void main(String[] args) {
        List<String> foods = Arrays.asList("Pizza", "Broccoli", "Burger", "Spinach");

        Predicate<String> isJunkFood = food -> food.equalsIgnoreCase("Pizza") || food.equalsIgnoreCase("Burger");

        System.out.println("🍕 Junk foods:");
        foods.stream().filter(isJunkFood).forEach(System.out::println);
    }
}
