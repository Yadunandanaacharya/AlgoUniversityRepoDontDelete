package AssignmentProblems.A0WarmupBunch1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TakingInputsInJavaExamples {
    public static void main(String[] args) throws Exception {
        //using Scanner nextInt

//        System.out.println("Taking input from the user:");
//        Scanner scn =  new Scanner(System.in);
//        System.out.println("Enter 1st number: ");
//        int a = scn.nextInt();
//        System.out.println("Enter 2nd number: ");
//        int b = scn.nextInt();
//        System.out.println("Sum is: ");
//        System.out.println(a + b);


    // // //    //using next for string which reads only first word
//        System.out.println("Taking input string from the user:");
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter statment: ");
//        String string = scn.next();
//        System.out.println(string);


//  // //  input: Hi my name is yadu
//  // //  output:  Hi
//  // // Note: it doesn't read space separate strings

        // so to read space separated complete string with sentence use nextLine


        //using nextLine for string which reads only first word
//        System.out.println("Taking input string from the user:");
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter statment: ");
//        String string = scn.nextLine();
//        System.out.println(string);
//  // //  input: Hi my name is yadu
//  // //  output: Hi my name is yadu

//  // //  Like this we use bufferreader
//        System.out.println("Taking input string from the user:");
//        InputStreamReader ir = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(ir);
//        System.out.println("Enter statment: ");
//        String str = br.readLine();
//        System.out.println("Entered string is");
//        System.out.println(str);


//  // //  Like this we use bufferreader for integer inputs
//        System.out.println("Taking input string from the user:");
//        InputStreamReader ir = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(ir);
//        System.out.println("Enter numbers: ");
//        int numbers = Integer.parseInt(br.readLine());
//        System.out.println("Entered int is");
//        System.out.println(numbers);

// // // // you can enter only 1 number
//        Enter numbers:
//        1
//        Entered int is
//        1
        // if you type space separated integer you'll get error


// // // // for space separate inputs if you wish to enter use string for them
//        System.out.println("Taking input string from the user:");
//        InputStreamReader ir = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(ir);
//        System.out.println("Enter many  numbers: ");
//        String string = br.readLine();
//        System.out.println("Entered int is");
//        System.out.println(string);

//        Enter many  numbers:
//        1 2 3 4
//        Entered int is
//        1 2 3 4

// // // // but if you wish to get only 2 numbers from input then
// // // //Link:
// // // //https://www.geeksforgeeks.org/how-to-take-input-from-user-separated-by-space-in-java/#:~:text=There%20are%202%20methods%20to,nextInt(%20)%20method%20of%20Scanner%20class
        System.out.println("Taking input string from the user:");
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter many  numbers: ");
        String[] stringArray = br.readLine().split(" ");

        System.out.println("Entered int is");
        int a = Integer.parseInt(stringArray[0]);
        int b = Integer.parseInt(stringArray[1]);
        System.out.println("a is " + a + " and b is " + b);
    }
}
