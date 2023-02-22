package LessonProblems.TwoPointerProblems;

/*
https://www.geeksforgeeks.org/two-pointers-technique/

Here for loop I have used similaar like while loop
 */

public class TwoSumInSortedArray {
    public static void main(String[] args) {
        int[] inputArray = {10, 20, 35, 50, 75, 80};
        int sum = 70;

        int arrLength = inputArray.length - 1;
        int i = 0; int j = inputArray.length - 1;
        //used for loop similar to while
        for (i = 0; i<j; i++,j--) {
            int currentSum = inputArray[i] + inputArray[j];
            if (inputArray[i] + inputArray[j] > sum)
                j--;
            else if (inputArray[i] + inputArray[j] < sum)
                i++;
            else {
                if (inputArray[i] + inputArray[j] == sum)
                    break;
            }
        }

        /*
        while (i < j) {
            int currentSum = inputArray[i] + inputArray[j];
            if (inputArray[i] + inputArray[j] > sum)
                j--;
            else if (inputArray[i] + inputArray[j] < sum)
                i++;
            else {
                if (inputArray[i] + inputArray[j] == sum)
                    break;
            }
        }
         */

        System.out.println(i + " " + j);

    }
}
