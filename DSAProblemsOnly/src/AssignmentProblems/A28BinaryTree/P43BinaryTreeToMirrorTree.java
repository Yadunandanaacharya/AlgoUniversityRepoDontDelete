package AssignmentProblems.A28BinaryTree;

import java.io.*;
import java.util.*;

/*
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
 */

public class P43BinaryTreeToMirrorTree {
    public static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
        }
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

    //method type passing Node is not good if you make List it's so much good directly you can print them
    private static Node InvertOrMirrorTree(Node root){
        if (root == null) return null;

        InvertOrMirrorTree(root.left);
        InvertOrMirrorTree(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    private static int Height(Node root){
        if (root == null) return 0;
        else{
            int leftHeight = Height(root.left);
            int rightHeight = Height(root.right);

            if (leftHeight>rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
    }

    private static void PrintLevelOrder(Node root){
        int height = Height(root);
        for (int i = 1; i <= height; i++){
            PrintGivenLevel(root, i);
        }
    }

    public static List<Integer> nodesList = new ArrayList<Integer>();
    private static void PrintGivenLevel(Node root, int level){
        if (root == null) return;
        if (level == 1){
            nodesList.add(root.data);
        }
        else if (level > 1){
            PrintGivenLevel(root.left, level -1);
            PrintGivenLevel(root.right, level -1);
        }
    }

    public static Node rootNode;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArrStr = br.readLine().split(",");
        int[] intArr = new int[inputArrStr.length];

        for(int i = 0; i < inputArrStr.length;i++){
            intArr[i] = Integer.parseInt(inputArrStr[i]);
        }

        rootNode = ConstructBinaryTree(intArr, 0);

        rootNode = InvertOrMirrorTree(rootNode);
        PrintLevelOrder(rootNode);
        for(int i = 0; i < nodesList.size();i++){
            System.out.print(nodesList.get(i) + ",");
        }
    }
}
