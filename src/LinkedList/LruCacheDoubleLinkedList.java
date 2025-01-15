package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LruCacheDoubleLinkedList {
    private static final int capacity = 3;
    private final DoubleLinkedListNode head;
    private final DoubleLinkedListNode tail;
    private final Map<Integer, DoubleLinkedListNode> nodeMap;

    public LruCacheDoubleLinkedList() {
        this.head = new DoubleLinkedListNode(-1, -1);
        this.tail = new DoubleLinkedListNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        nodeMap = new HashMap<>();
    }

    public static void main(String[] args) {
        LruCacheDoubleLinkedList lruList = new LruCacheDoubleLinkedList();
        lruList.putNode(2, 250);
        lruList.putNode(3, 350);
        lruList.putNode(4, 450);
        Integer getValue = lruList.getNode(2);
        System.out.println("GetValue:" + getValue);
        lruList.putNode(5, 550);

    }

    private void addNodeAtEnd(DoubleLinkedListNode newNode) {

        DoubleLinkedListNode prevNode=tail.prev;
        prevNode.next=newNode;
        newNode.prev = prevNode;
        newNode.next = tail;
        tail.prev = newNode;
    }

    private void removeNode(DoubleLinkedListNode removeNode) {
        removeNode.prev.next = removeNode.next;
        removeNode.next.prev = removeNode.prev;
        removeNode.next = null;
        removeNode.prev = null;
    }

    private void putNode(Integer key, Integer value) {
        if (nodeMap.containsKey(key)) {
            removeNode(nodeMap.get(key));
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
        nodeMap.put(key,node);
        if (nodeMap.size() > capacity) {
            nodeMap.remove(head.next.key);
            removeNode(head.next);
        }
        addNodeAtEnd(node);

    }

    private Integer getNode(Integer key) {

        if (!nodeMap.containsKey(key)) {
            return null;
        }
        DoubleLinkedListNode removeNode = nodeMap.get(key);
        removeNode(removeNode);
        addNodeAtEnd(removeNode);

        return removeNode.key;
    }
}

class DoubleLinkedListNode {
    int key;
    int value;
    DoubleLinkedListNode prev;
    DoubleLinkedListNode next;

    public DoubleLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
