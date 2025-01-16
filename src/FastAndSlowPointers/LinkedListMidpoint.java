package FastAndSlowPointers;

public class LinkedListMidpoint {
    public static void main(String[] args) {
        Node node4 =new Node(4);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        System.out.println("getMidpointSecondMidIfEvenNumberOfList Result:"+getMidpointSecondMidIfEvenNumberOfList(node1));
        System.out.println("getMidpointFirstMidIfEvenNumberOfList Result:"+getMidpointFirstMidIfEvenNumberOfList(node1));


    }

    private static int getMidpointSecondMidIfEvenNumberOfList(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.value;
    }

    private static int getMidpointFirstMidIfEvenNumberOfList(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.value;
    }
}
