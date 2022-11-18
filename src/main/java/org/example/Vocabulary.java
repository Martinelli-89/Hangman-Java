package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vocabulary {

    private static List<String> words = new ArrayList<>();
    private static Random rand = new Random();

    static {
        words.add("hello");
        words.add("java");
        words.add("sky");
        words.add("sea");
        words.add("mountain");
        words.add("laptop");
        words.add("archeology");
        words.add("history");
        words.add("computer");
        words.add("toilet");
        words.add("ketchup");
        words.add("banana");
        words.add("coffee");
        words.add("restaurant");
        words.add("chemistry");
        words.add("hospital");
        words.add("truck");
    }

    public static String getWord () {
        return words.get(rand.nextInt(words.size())+1);
    }

}
