package Tutorials.FunctionalInterface;


import java.util.function.*;
import java.util.Random;

public class LambdaPlayground {
    public static void main(String[] args) {

        // FUNCTION: Takes input, returns output
        // Example: takes an integer and doubles it
        Function<Integer, Integer> doubler = x -> x * 2;
        System.out.println("Function ➡ 5 doubled is " + doubler.apply(5));

        // CONSUMER: Takes input, returns nothing
        // Example: prints a message using the given name
        Consumer<String> greeter = name -> System.out.println("Hello, " + name + "!");
        greeter.accept("Tom");

        // PREDICATE: Takes input, returns a boolean
        // Example: checks if a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Predicate ➡ Is 8 even? " + isEven.test(8));
        System.out.println("Predicate ➡ Is 7 even? " + isEven.test(7));

        // SUPPLIER: Takes nothing, returns output
        // Example: gives a random motivational quote
        String[] quotes = {
                "Keep pushing forward",
                "You’re doing amazing ",
                "Never stop learning",
                "Believe in yourself"
        };
        Random random = new Random();
        Supplier<String> quoteSupplier = () -> quotes[random.nextInt(quotes.length)];
        System.out.println("Supplier ➡ Your quote: " + quoteSupplier.get());

        //  RUNNABLE: Takes nothing, returns nothing
        // Example: runs a simple task
        Runnable countdown = () -> {
            System.out.println("Runnable ➡ Starting countdown...");
            for (int i = 3; i > 0; i--) {
                System.out.println(i + "...");
                try {
                    Thread.sleep(500); // pause for 0.5 seconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Go!");
        };

        // Start the runnable task
        countdown.run();
    }
}
