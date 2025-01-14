package LinkedList;

import static java.util.Objects.isNull;

public class ReverseLinkedList {
    public static void main(String[] args) {
        
        int[] nums=new int[]{1,2,3,4,5,6};
        Node head=new Node(nums[0],null);
        Node nextNode=head;
        for(int i=1;i< nums.length;i++){
            Node temp=new Node(nums[i], null);
            nextNode.next=temp;
            nextNode=temp;
        }
        Node newHead = getReverseLinkedList(head);
        System.out.println(newHead);
    }
    private static Node getReverseLinkedList(Node head){

        if(isNull(head) || isNull(head.next)){
            return head;
        }
        Node currentNode= head;
        Node previousNode=null;
        Node nextNode;
        while(currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }

        return previousNode;
    }
}
class Node{
    Integer value;
    Node next;

    public Node(Integer value, Node next) {
        this.value = value;
        this.next = next;
    }
}
