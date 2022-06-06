package by.teachmeskills;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Ivan");
        names.add("Pavel");
        names.add("Pavel");
        names.add("Dmitriy");

        names.stream()
                .filter(s -> s.length() > 4)
                .distinct()
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
