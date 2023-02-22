package AssignmentProblems.A8LinkdList1;

public class InsertLinkdList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int dataOfNode) {
            this.data = dataOfNode;
            next = null;
        }
    }

    public void PrintList() {
        Node n = head;
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }


    public static void main(String[] args) throws Exception {
        InsertLinkdList linkdList =new InsertLinkdList();
        linkdList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkdList.head.next = second;
        second.next = third;
        linkdList.PrintList();
    }
}
