package com.dudchenko;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's count unique elements! Type a String");
        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> result = new Count().countElements(input);


        System.out.print(OutputFormatter.format(result));
    }
}
