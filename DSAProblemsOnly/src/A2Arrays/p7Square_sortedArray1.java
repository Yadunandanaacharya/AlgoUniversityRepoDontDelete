package A2Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Sample 1 INPUT:
4
0  1 2 3
-4 2 5 10
Sample 1 OUTPUT:

4 16 25 100
 */

public class p7Square_sortedArray1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        int noOfInteger = Integer.parseInt(bufferReader.readLine());
        String[] str1 = bufferReader.readLine().split(" ");

        int[] inputArray = new int[noOfInteger];
        for(int i = 0; i<noOfInteger; i++) {
            inputArray[i] = Integer.parseInt(str1[i]);
        }

        SortArrayWith2Pointer(inputArray);
        for(int i = 0; i < inputArray.length; i++)
            System.out.print(inputArray[i] + " ");

    }

    public static void SortArrayWith2Pointer(int[] inputArray) {
        int startofArray = 0;
        int endOfArray = inputArray.length - 1;
        int[] result = new int[inputArray.length];

        for(int i = inputArray.length - 1; i >= 0; i--) {
            if (Math.abs(inputArray[startofArray ]) > Math.abs(inputArray[endOfArray])) {
                result[i] = inputArray[startofArray] * inputArray[startofArray];
                startofArray++;
            }
            else {
                result[i] = inputArray[endOfArray] * inputArray[endOfArray];
                endOfArray--;
            }
        }

        for(int i = 0; i < result.length; i++) {
            inputArray[i] = result[i];
        }
    }
}
