package AssignmentProblems.A3Matrix;

public class session3SnowPattern {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2,3,4},
                {5, 6,7,8},
                {9, 10,11,12},
                {13, 14,15,16},
        };

        boolean flag = false;
        for(int i = 0;i<arr.length;i++){
            for(int j =0;j<arr[i].length;j++){
                if(flag == false){
                    System.out.print(arr[0][j] + " ");
                }
            }
            flag = true;
        }

        for(int i = 0;i<arr.length;i++){
            for(int j =arr[i].length-1;j>=0;j--){
                if(flag){
                    System.out.print(arr[1][j] + " ");
                }
            }
            flag = false;
        }

//        for (int i = 0; i<m;i++) {
//            for(int j = 0;j<n;j++) {
//                if (a[])
//            }
//        }
    }
}
