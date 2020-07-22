package com.dudchenko;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICounter counter = new CacheCounter(new Counter());
        System.out.println("Let's count unique elements! Type a String. For quit type 'exit' ");
        String input = scanner.nextLine();
        while (!input.equals("exit")) {
            Map<Character, Integer> result = counter.countCharacters(input);
            System.out.print(format(result));
            input = scanner.nextLine();
        }
    }

    public static String format(Map<Character, Integer> result) {
        StringBuilder output = new StringBuilder();
        Iterator iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("\"" + pair.getKey() + "\"" + " - " + pair.getValue());
        }
        return output.toString();
    }
}
