package AssignmentProblems.A8LinkdList1;

import java.util.HashMap;

public class FindCycleInLinkList {
    Node head;

    static class Node{
        int data;
        Node next;
        int flag;
        Node(int d){
            this.data = d;
            next=null;
            flag=0;
        }
    }

    public void PrintList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public boolean CycleChecker() {
        Node temp = head;
        HashMap<Integer, Boolean> cycleCheckMap = new HashMap<>();
        boolean ans = false;

        while (temp != null) {
            if (temp.flag == 1)
                return true;

            temp.flag = 1;
            temp = temp.next;
        }

        return  false;
    }

    public static void main(String[] args) throws Exception {
        FindCycleInLinkList linkList = new FindCycleInLinkList();
        linkList.head= new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(1);
        Node sixth = new Node(2);

        linkList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
//        sixth.next = third;

        System.out.println(linkList.CycleChecker());
    }
}
