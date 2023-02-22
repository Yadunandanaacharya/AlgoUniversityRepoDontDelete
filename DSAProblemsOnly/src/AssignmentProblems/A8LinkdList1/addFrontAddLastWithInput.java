package AssignmentProblems.A8LinkdList1;

import java.io.*;

/*
check pepcoding addLast also checked gfg
 */
public class addFrontAddLastWithInput {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public  void PushFront(int val){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        //working correct
        public void PushLast(int val){
            Node newNode = new Node(val);

            if (size == 0)
                head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        //this becomes wrong If I give input 1 2 3 4 5
        //then at first 1,   next iteration 1->2
        //next iteattion 1->3 after iteraton 1->4
        //which is wrong our ans should be 1->2->3->4->5
        public void PushLastMyMethodWithoutTail(int val){
            Node newNode = new Node(val);

            if (size == 0)
                head = newNode;
            else {
                head.next = newNode;
            }

            size++;
        }

        //working correct but takes o(n^2)
        public void PushLastUseWhile(int val) {
            Node newNode = new Node(val);
            Node temp = head;

            if (size == 0)
                head = newNode;
            else {
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }

            size++;
        }

        public void PrintLinkedList(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        public boolean AreNodesIntersectingIn2LinkedList(Node headA, Node headB) {


            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList lL = new LinkedList();
        int lengthArray = Integer.parseInt(br.readLine());

        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i <lengthArray; i++){
            int d = Integer.parseInt(inputArrayString[i]);
//            lL.PushLast(d);
//            lL.PushLastMyMethodWithoutTail(d);
            lL.PushLastUseWhile(d);
        }
        lL.PrintLinkedList();
    }
}
