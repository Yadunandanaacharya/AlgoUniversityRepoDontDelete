package AssignmentProblems.A8LinkdList1;

import java.io.*;

public class DeletionInLinkList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void DeleteNode(Node node) {
        if(node != null && node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLinkList = br.readLine().split(" ");
        int nodeToDelete = Integer.parseInt(br.readLine());

        Node n = new Node(nodeToDelete);
        DeleteNode(n);

    }
}
