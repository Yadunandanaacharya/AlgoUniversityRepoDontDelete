package A4SearchSort1;

/*
DANGER: TRY TO CODE EVERY WORD OF CODE BY YOURSELF DON'T CLICK ON INTELLISENCE
IN ONLINE ASSESSMENT YOU WON'T GET ANY INTELLISENSE EXAMPLE IN LEETCODE YOU WON'T GET ANY OF THOSE
 */

/*
1 2 3 4 5 6 7 array
0 1 2 3 4 5 6 index
seach 6: then
mid=6/2=3 ar[3]=4 so 4<6 search in upper half
low=mid+1
searach from index 4 to 6

search 1
then arr[3]=4 so 4>1
so high=mid-1 search from 0 to index 2
 */

/*
5 5
1 2 5 6 8
5 1 2 8 8
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p25DirectBinarySeach {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStringArrayNandQ = br.readLine().split(" ");
        int N = Integer.parseInt(inputStringArrayNandQ[0]);
        int Q = Integer.parseInt(inputStringArrayNandQ[1]);

        String[] inputArrInt = br.readLine().split(" ");
        int[] inputArr = new int[N];
        for(int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(inputArrInt[i]);
        }

        String[] searchQueryArr = br.readLine().split(" ");
        for(int i = 0; i <Q; i++) {
            int searchItem = Integer.parseInt(searchQueryArr[i]);
            System.out.println(BinarySearch(inputArr, searchItem));
        }
    }

    public static int BinarySearch(int[] arr, int searchItem) {
        int low = 0;
        int high = arr.length - 1;
        int outIndex = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == searchItem) {
                outIndex = mid;
                break;
            }
            else if (arr[mid] < searchItem) {
                low = mid + 1;
            }
            else if (arr[mid] > searchItem) {
                high = mid -1;
            }
        }

        return outIndex;
    }
}
