package LinkedList;

public class RemoveKthLastNode {

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,4,5,6,7,8};
        Node head=new Node(nums[0],null);
        Node nextNode=head;
        for(int i=1;i< nums.length;i++){
            Node temp=new Node(nums[i], null);
            nextNode.next=temp;
            nextNode=temp;
        }
        removeKthLastNode(head, 2);

    }

    private static void removeKthLastNode(Node head, int k){
        Node dummy=new Node(0,head);
        Node slow=dummy;
        Node fast=dummy;
        for(int i=0;i<k;i++){
            fast=fast.next;
            if(null==fast) {return;}

        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        Node remove=slow.next;
        slow.next=slow.next.next;
        remove.next=null;
    }

}

