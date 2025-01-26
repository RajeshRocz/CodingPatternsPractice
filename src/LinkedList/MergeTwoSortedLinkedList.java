package LinkedList;

import java.util.PriorityQueue;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(
                (a,b)-> Integer.compare(a.val, b.val)

        );
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode currentNode = dummy;


        while (pointer1 != null && pointer2 != null) {

            if (pointer1.val <= pointer2.val) {
                currentNode.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                currentNode.next = pointer2;
                pointer2 = pointer2.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next= pointer1 == null?pointer2:pointer1;
        return dummy.next;

    }
}

  class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
