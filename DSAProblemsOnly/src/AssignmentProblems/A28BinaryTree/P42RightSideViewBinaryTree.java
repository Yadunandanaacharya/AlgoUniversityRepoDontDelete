package AssignmentProblems.A28BinaryTree;

import java.util.*;
import java.io.*;

/*
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
 */


public class P42RightSideViewBinaryTree {
    public static class Node{
        String data;
        Node left,right;

        public Node(String data){
            this.data = data;
        }
    }

    private static Node ConstructBinaryTree(String[] arr, int i){
        Node root = null;
        if (i < arr.length){
            root = new Node(arr[i]);

            root.left = ConstructBinaryTree(arr, 2*i+1);
            root.right = ConstructBinaryTree(arr, 2*i+2);
        }

        return root;
    }

//    https://www.youtube.com/watch?v=fcmxvpwFHgk&ab_channel=Pepcoding
    //must watch video for understanding logic sai from algouniversity explained but couldn't
    //understand but pepcoding explained very good
    public static ArrayList<String> ans = new ArrayList<>();
    private static ArrayList<String> RightSideView(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (queue.size() != 0){
            int size = queue.size();
            ans.add(queue.getFirst().data);
            //until size is not 0 we keep popping items from linkedlist
            while (size-- > 0){
                Node removeNode = queue.removeFirst();

                if (removeNode.right != null){
                    queue.addLast(removeNode.right); //adding child node at the end of linkedlist
                }
                if (removeNode.left != null){
                    queue.addLast(removeNode.left); //adding child node at the end of linkedlist
                }
            }
        }

        return ans;
    }

    public static Node rootNode;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArrStr = br.readLine().split(",");
        String[] intArr = new String[inputArrStr.length];

        for(int i = 0; i < inputArrStr.length;i++){
            intArr[i] = inputArrStr[i];
        }

        rootNode = ConstructBinaryTree(intArr, 0);

        ans = RightSideView(rootNode);
        for( String s : ans )
        {
            System.out.print( s + ",");
        }
    }
}
