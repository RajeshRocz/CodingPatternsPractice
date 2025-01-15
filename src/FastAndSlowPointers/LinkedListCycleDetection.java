package FastAndSlowPointers;

import java.util.Objects;

public class LinkedListCycleDetection {

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        // node3.next=node1;
        System.out.println("isCyclicList:" + isCyclicLinkedList(node1));
    }

    private static boolean isCyclicLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (Objects.equals(slow, fast)) {
                return true;
            }
        }

        return false;
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
