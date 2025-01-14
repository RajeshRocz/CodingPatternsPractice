package LinkedList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListIntersection {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Node head1 = new Node(nums[0], null);
        Node head2 = new Node(9, null);
        Node nextNode = head1;
        Node h2NextNode = head2;
        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i], null);
            nextNode.next = temp;
            h2NextNode.next = temp;
            nextNode = temp;
            h2NextNode = temp;
        }
        //  Node result = getInterSectionNodeUsingHashSet(head1, head2);
        Node result1 = getInterSectionNodeUsingMergeList(head1, head2);

        System.out.println("Result value:" + result1.value);
    }

    private static Node getInterSectionNodeUsingHashSet(Node head1, Node head2) {

        Set<Node> setHead1 = new HashSet<>();
        Node h1 = head1;
        while (null != h1) {
            setHead1.add(h1);
            h1 = h1.next;
        }
        Node h2 = head2;
        while (h2 != null) {
            if (setHead1.contains(h2)) {
                return h2;
            }
            h2 = h2.next;
        }
        return null;
    }

    private static Node getInterSectionNodeUsingMergeList(Node head1, Node head2) {

        Node tempHead1 = head1;
        Node tempHead2 = head2;
        while (!Objects.equals(tempHead2, tempHead1)) {
            tempHead1 = tempHead1.next != null ? tempHead1.next : head2;
            tempHead2 = tempHead2.next != null ? tempHead2.next : head1;
        }
        return tempHead1;
    }
}
