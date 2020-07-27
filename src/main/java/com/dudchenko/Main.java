package com.dudchenko;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharsCounter counter = new CachedCharsCounter(new UniqueCharsCounter());
        System.out.println("Let's count unique elements! Type a String. For quit type 'exit' ");
        String input = scanner.nextLine();
        while (!input.equals("exit")) {
            Map<Character, Integer> result = counter.countCharacters(input);
            printResult(result);
            input = scanner.nextLine();
        }
    }

    public static void printResult(Map<Character, Integer> result) {
        StringBuilder output = new StringBuilder();
        Iterator iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("\"" + pair.getKey() + "\"" + " - " + pair.getValue());
        }
    }
}
