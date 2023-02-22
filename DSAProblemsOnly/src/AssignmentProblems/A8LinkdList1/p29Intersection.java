package AssignmentProblems.A8LinkdList1;

import java.io.*;
import java.util.*;

/*
5
4 1 8 4 5
6
5 6 1 8 4 5
 */

public class p29Intersection {
    public static class  Node {
        int data;
        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public static class LinkedList{
        Node head;
        int size;
        Node tail;

        public void AddLastWithTail(int val){
            Node newNode = new Node(val);

            if (size == 0)
                head = tail = newNode;
            else{
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void PrintLinkedList(){
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    public static boolean AreNodesIntersecting2LinkedLists(Node headA, Node headB) {

        return false;
    }

    public static void main(String[] arsg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lenFirstLinkedList = Integer.parseInt(br.readLine());
        String[] inputArrayFirstLinkList = br.readLine().split(" ");
        int lenSecondLinkedList = Integer.parseInt(br.readLine());
        String[] inputArraySecondLinkList = br.readLine().split(" ");

        LinkedList lL1 = new LinkedList();
        for (int i = 0; i<lenFirstLinkedList;i++)
            lL1.AddLastWithTail(Integer.parseInt(inputArrayFirstLinkList[i]));

        LinkedList lL2 = new LinkedList();
        for (int i = 0; i<lenSecondLinkedList;i++)
            lL2.AddLastWithTail(Integer.parseInt(inputArraySecondLinkList[i]));

//        lL1.PrintLinkedList();
//        System.out.println();
//        lL2.PrintLinkedList();
//        System.out.println();
//        System.out.println(lL1.head.data + " " + lL2.head.data);
//        System.out.println(lL1.tail.data + " " + lL2.tail.data);

        AreNodesIntersecting2LinkedLists(lL1.head, lL2.head);
    }
}
