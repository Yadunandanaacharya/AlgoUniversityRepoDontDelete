package AssignmentProblems.A28BinaryTree;

import com.sun.source.tree.Tree;

/*
Input: root = [1,2,3,4,5]
1,2,3,4,5    pass this for input
Output: 3

 */

import java.io.*;
import java.util.*;

public class P41DiamterBinaryTree {
    public static int result = 0;
    public static int diameter = 0;
    
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    //below code is to constuct binary tree
    //https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
    Node rootIs;
    public static Node insertLevelOrder(int[] arr, int i)
    {
        Node root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);

            // insert left child always remember
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(",");

        int[] arr = new int[inputArr.length];
        for (int i = 0; i < arr.length;i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        P41DiamterBinaryTree p41DiamterBinaryTree = new P41DiamterBinaryTree();
        p41DiamterBinaryTree.rootIs = insertLevelOrder(arr,0);

        System.out.println(DiameterOfBinaryTree(p41DiamterBinaryTree.rootIs));
    }

    private static int DiameterOfBinaryTree(Node root){
        if (root == null)
            return 0;

        MaxDepth(root);
        return result;
    }

    private static int MaxDepth(Node root){
        if (root == null)
            return 0;

        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        diameter = left + right;
        result = Math.max(diameter, result);

        return Math.max(left, right) + 1;
    }
}
