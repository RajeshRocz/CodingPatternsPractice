package LinkedList;

import static java.util.Objects.isNull;

public class ReverseLinkedList {
    public static void main(String[] args) {
        
        int[] nums=new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        Node head=new Node(nums[0],null);
        Node nextNode=head;
        for(int i=1;i< nums.length;i++){
            Node temp=new Node(nums[i], null);
            nextNode.next=temp;
            nextNode=temp;
        }
        System.out.println("Sum:"+getSum(head));

        // Node newHead = getReverseLinkedList(head);
        Node newHead = getReverseLinkedListByRecursion(head);
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

    private static Node getReverseLinkedListByRecursion(Node head) {

        if(isNull(head)||isNull(head.next)){
            return head;
        }
        Node newNode=getReverseLinkedListByRecursion(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    private static double getSum(Node head){
        int i=0;
        double sum=0;
        Node temp =head;
        while(temp!=null){
            sum= sum+(temp.value*Math.pow(10,i++));
            temp=temp.next;

        }
        return sum;
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
