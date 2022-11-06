package Contest1Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArrayString = br.readLine().split(" ");
        int arrayLength = Integer.parseInt(inputArrayString[0]);
        int rotateNum = Integer.parseInt(inputArrayString[1]);

        String[] enteredInputs = br.readLine().split(" ");
        int[] inputArray = new int[arrayLength];
        for(int i = 0; i <arrayLength;i++){
            inputArray[i] = Integer.parseInt(enteredInputs[i]);
        }

        Rotate(inputArray, rotateNum);

        for (int i = 0; i < arrayLength;i++) {
            System.out.print(inputArray[i] + " ");
        }
    }

    public static void Rotate(int[] array , int k) {
        k = k % array.length;
        if (k < 0)
            k = k + array.length;

        for(int i = 0; i < k; i++){
            int j, first;
            first = array[0];
            for(j = 0; j < array.length-1; j++){
                array[j] = array[j+1];
            }
            array[j] = first;
        }
    }
}
