package com.dudchenko;

import lombok.Data;

import java.util.Map;

@Data
public class Node {

    private String nodeKey;
    private Map<String, Integer> nodeValue;
    private Node previous;
    private Node next;

    public Node(String nodeKey, Map<String, Integer> nodeValue) {
        this.nodeKey = nodeKey;
        this.nodeValue = nodeValue;
    }

}
