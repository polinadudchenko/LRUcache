package com.dudchenko;

import lombok.Data;

import java.util.HashMap;

@Data
public class Node {

    private String nodeKey;
    private HashMap<String, Integer> nodeValue;
    private Node previous;
    private Node next;

    public Node(String nodeKey, HashMap<String, Integer> nodeValue) {
        this.nodeKey = nodeKey;
        this.nodeValue = nodeValue;
    }

}
