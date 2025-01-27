package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class CombineSortedLinkedLists {


 private static ListNode combineSortedLinkedLists(ListNode[] list) {
  if (list == null) {
   return null;
  }
  PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));


  Collections.addAll(minHeap, list);

  ListNode dummy = new ListNode(-1);
  ListNode currentNode = dummy;
  while (!minHeap.isEmpty()) {
   ListNode top = minHeap.poll();
   currentNode.next = top;
   currentNode = currentNode.next;

   if (null != top.next) {
    minHeap.add(top.next);
   }

  }

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
