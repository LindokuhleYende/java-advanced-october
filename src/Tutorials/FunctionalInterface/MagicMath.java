package Tutorials.FunctionalInterface;

import java.util.function.Function;

public class MagicMath {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> doubleIt = x -> x * 2;

        // Chain them together (square first, then double)
        Function<Integer, Integer> magic = square.andThen(doubleIt);

        System.out.println("Result: " + magic.apply(5)); // (5*5)*2 = 50
    }
}
