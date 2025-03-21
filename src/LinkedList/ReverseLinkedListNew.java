package LinkedList;

public class ReverseLinkedListNew {

    public static void main(String[] args) {
        NodeStructure actual=getLinkedList(new int[]{1,2,3,4,5});
        printList(actual);
        NodeStructure reversedList=reverseLinkedList(actual);
        printList(reversedList);
    }

    private static NodeStructure reverseLinkedList(NodeStructure head){
        NodeStructure current=head;
        NodeStructure prev=null;
        while(current!=null){
            NodeStructure next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }


    private static NodeStructure getLinkedList(int[] nums){
        NodeStructure dummy=new NodeStructure(-1);
        NodeStructure currentNode=dummy;
        for(int i=0;i<nums.length;i++){
            NodeStructure temp=new NodeStructure(nums[i]);
            currentNode.next=temp;
            currentNode=currentNode.next;
        }

        return dummy.next;
    }

    private static void printList(NodeStructure head){
        NodeStructure current=head;
        while(current!=null){
            System.out.print(current.value+"->");
            current=current.next;
        }
        System.out.println("");
    }
}

class NodeStructure{

    int value;
    NodeStructure next;
    public NodeStructure(int value){
        this.value=value;
    }
}
