package Tutorials;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // allowed in List (duplicates allowed)

        Set<String> uniqueNames = new HashSet<>(names); // removes duplicates

        Map<Integer, String> idToName = new HashMap<>();
        idToName.put(1, "Alice");
        idToName.put(2, "Bob");

        System.out.println(names);       // [Alice, Bob, Alice]
        System.out.println(uniqueNames); // [Alice, Bob] (order not guaranteed)
        System.out.println(idToName);    // {1=Alice, 2=Bob}
    }
}

