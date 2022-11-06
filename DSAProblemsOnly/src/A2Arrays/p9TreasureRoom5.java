package A2Arrays;

import java.util.HashMap;
import java.util.Scanner;

/*
13 11
4 3 4 4 9 12 20 14 2 12 12 11 6
ans: 1 2 3

13 11
4 9 12 20 14 2 12 12 11 6 4 3 4
ans:1 12 13

13 11
4 9 12 20 14 2 12 12 11 6 6 3 4
ans:1 12 13

13 11
4 9 12 20 14 2 12 12 11 6 6 3 1
ans:1 12 13
 */
public class p9TreasureRoom5 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean check=false;
        int[] ans = new int[3];
        for(int i=0;i<n;i++){
            int sum=x-arr[i];
            for(int j=i+1;j<n-1;j++){
                int sum1=sum-arr[j];
                map.remove(arr[j]);
                if(map.containsKey(sum1)){
                    int y=map.get(sum1);
                    System.out.print((i+1)+" "+(y+1)+" "+(j+1));

                    ans[0] = i+1;
                    ans[1] = j+1;
                    ans[2] = y + 1;
                    check=true;
                    break;
                }
                map.put(arr[j],j);

            }
            if(check==true){
                break;
            }
        }
        if(check==false){
            System.out.print(-1);
        }
    }
}
