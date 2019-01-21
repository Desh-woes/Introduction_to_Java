public class CompareNumbers {

    //Function to compare two numbers and observe the larger of the two.
    public static String compare(int a, int b) {
        // Compare the two numbers
        if (a > b) {
            // Compare A and B
            System.out.println("A is greater than B");
            return "A is greater than B";
        }
        else {
            System.out.println("B is greater than A");
            return "B is greater than A";
        }

    }

    // Main function to run the defined function
    public static void main(String[] args) {
        System.out.println(compare(5, 2));
    }
}
