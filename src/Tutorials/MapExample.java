package Tutorials;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Integer> studentScores = new HashMap<>();

        // Add key-value pairs
        studentScores.put("Alice", 90);
        studentScores.put("Bob", 85);
        studentScores.put("Charlie", 92);

        // Access value using key
        System.out.println("Alice's score: " + studentScores.get("Alice"));

        // Update value for an existing key
        studentScores.put("Alice", 95);
        System.out.println("Updated Alice's score: " + studentScores.get("Alice"));

        // Check if a key exists
        if (studentScores.containsKey("Bob")) {
            System.out.println("Bob is in the map.");
        }

        // Loop through the map
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " scored " + entry.getValue());
        }
    }
}
