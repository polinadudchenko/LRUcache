package com.dudchenko;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cache {
    private Node headNode;
    private Node tailNode;
    private HashMap<String, Node> cacheMap = new HashMap<>();
    private static final int cacheCapacity = 5;

    public Map<String, Integer> get(String key) {
        if (cacheMap.get(key) == null) {
            return null;
        } else {
            Node node = cacheMap.get(key);
            removeNode(node);
            addNode(node);
            return node.getNodeValue();
        }
    }

    public void put(String key, HashMap<String, Integer> value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            removeNode(node);
            addNode(node);
        } else {
            if (cacheMap.size() == cacheCapacity) {
                cacheMap.remove(headNode.getNodeKey());
                removeNode(headNode);
            }
            Node node = new Node(key, value);
            addNode(node);
            cacheMap.put(key, node);
        }
    }

    private void removeNode(Node node) {
        if (node.getPrevious() != null) {
            node.getPrevious().setNext(node.getNext());
        } else {
            headNode = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrevious(node.getPrevious());
        } else {
            tailNode = node.getPrevious();
        }
    }


    private void addNode(Node node) {
        if (tailNode != null) {
            tailNode.setNext(node);
        }
        node.setPrevious(tailNode);
        node.setNext(null);
        tailNode = node;

        if (headNode == null) {
            headNode = tailNode;
        }
    }

    public boolean contains(String key) {
        return cacheMap.containsKey(key);
    }

}

