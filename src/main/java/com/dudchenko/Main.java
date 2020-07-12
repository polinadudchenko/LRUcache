package com.dudchenko;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter();
        System.out.println("Let's count unique elements! Type a String. For quit type 'exit' ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            Map<String, Integer> result = counter.getResult(input);
            System.out.print(OutputFormatter.format(result));
        }
    }
}
