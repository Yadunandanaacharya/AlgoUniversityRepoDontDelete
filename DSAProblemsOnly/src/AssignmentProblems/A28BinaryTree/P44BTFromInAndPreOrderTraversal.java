package AssignmentProblems.A28BinaryTree;

import java.io.*;
import java.util.*;

/*
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

 */

public class P44BTFromInAndPreOrderTraversal {
    public static class Node{
        int data;
        Node left, right;

       public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] preOrderStrList = br.readLine().split(",");
        String[] inOrderStrList = br.readLine().split(",");

        int[] preOrderList = new int[preOrderStrList.length];
        int[] inOrderList = new int[inOrderStrList.length];
        for(int i = 0; i <preOrderStrList.length;i++){
            preOrderList[i] = Integer.parseInt(preOrderStrList[i]);
        }
        for(int i = 0; i <inOrderStrList.length;i++){
            inOrderList[i] = Integer.parseInt(inOrderStrList[i]);
        }
        BuildTreeWithPreOrderInOrder(preOrderList, inOrderList);
    }

    public static int preOrderPointer = 0;
    private static  Node BuildTreeWithPreOrderInOrder(int[] preOrder, int[] inOrder){
        HashMap<Integer,Integer> inOrderMap = new HashMap();
        for(int i = 0; i<inOrder.length;i++){
            inOrderMap.put(inOrder[i],i);
        }

        return BuildTreeHelper(preOrder, inOrderMap,0,inOrder.length-1 );
    }

    private static Node BuildTreeHelper(int[] preOrder, HashMap<Integer,Integer> inOrderMap, int start,
                                        int end){
        if (start > end){
            return null;
        }

        //In every recursive call preOrderPointer will increase
        // Retrieve the current node value from the preorder array and create a new TreeNode
        int currentPreOrderVal = preOrder[preOrderPointer++];
        Node currentNode = new Node(currentPreOrderVal);

        // Find the index of the current node in the inorder array using the HashMap
        // we make it as root node that node's left will become left children right nodes will
        // become right children
        int inOrderIndexOfCurrentNode = inOrderMap.get(currentPreOrderVal);

        //recursively we build left and right subtrees
        currentNode.left = BuildTreeHelper(preOrder,inOrderMap,start,end-1);
        currentNode.right = BuildTreeHelper(preOrder,inOrderMap,start+1,end);
        return currentNode;
    }

    private static Node ConstructBinaryTree(int[] arr, int i){
        Node root = null;
        if (i < arr.length){
            root = new Node(arr[i]);

            root.left = ConstructBinaryTree(arr, 2*i+1);
            root.right = ConstructBinaryTree(arr, 2*i+2);
        }

        return root;
    }
}
