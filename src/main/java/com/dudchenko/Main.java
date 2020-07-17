package com.dudchenko;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter();
        Cache cache = new Cache();
        System.out.println("Let's count unique elements! Type a String. For quit type 'exit' ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            Map<Character, Integer> result = counter.getResult(input, cache);
            System.out.print(format(result));
        }
    }

    public static String format(Map<Character, Integer> result) {
        StringBuilder output = new StringBuilder();
        Iterator iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            output.append("\"");
            output.append(pair.getKey());
            output.append("\"");
            output.append(" - ");
            output.append(pair.getValue());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
