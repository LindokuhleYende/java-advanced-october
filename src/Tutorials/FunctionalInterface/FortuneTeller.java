package Tutorials.FunctionalInterface;

import java.util.function.Supplier;
import java.util.Random;

public class FortuneTeller {
    public static void main(String[] args) {
        String[] fortunes = {
                "You will ace your next coding challenge ",
                "A great opportunity is coming your way ",
                "Today is a perfect day for pizza ",
                "You’re going to make someone smile "
        };

        Random random = new Random();

        // Supplier that gives a random fortune each time it's called
        Supplier<String> fortuneSupplier = () -> fortunes[random.nextInt(fortunes.length)];

        // Call get() to receive a new fortune each time
        System.out.println("🔮 Your fortune: " + fortuneSupplier.get());
        System.out.println("🔮 Another fortune: " + fortuneSupplier.get());
        System.out.println("🔮 One more: " + fortuneSupplier.get());
    }
}
