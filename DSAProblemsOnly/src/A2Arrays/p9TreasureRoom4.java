package A2Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class p9TreasureRoom4 {
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
        for(int i=0;i<n;i++){
            int sum=x-arr[i];
            for(int j=i+1;j<n-1;j++){
                int sum1=sum-arr[j];
                map.remove(arr[j]);
                if(map.containsKey(sum1)){
                    int y=map.get(sum1);
                    System.out.print((i+1)+" "+(y+1)+" "+(j+1));
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
