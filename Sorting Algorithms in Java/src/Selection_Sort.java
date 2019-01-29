public class Selection_Sort {

    // Main function where we call our sorting algorithm
    public static void main(String[] args) {
        // Define test array
        int [] arr= {140, 89, 678, 767, 766, 765, 6764, 73, 562, 3451, 250, 2607};

        // Sort test array
        sort_array(arr);

        // Display sorted elements in test array
        for (int i : arr){
            System.out.println(i);
        }
    }

    // Function to help with sorting our array
    public static int[] sort_array(int[] arr) {

        // Outer loop to go through every element in position i
        for (int i = 0; i < arr.length-1; i++){

            // Minimum value starts at position i
            int min_value = i;

            // Inner loop to compare elements in position I to every other element after it
            for (int j= i+1; j < arr.length; j++){

                // If current value(J) is less than the current minimum value, update the minimum value.
                if (arr[j] < arr[min_value]){
                    min_value = j;
                }
            }

            //If the current minimum value is not equal to the value of i, swap the values
            if (min_value != i){
                swap(arr, i, min_value);
            }
        }
        // Return the sorted array
        return arr;
    }


    // Function to help with the swapping process.
    public static void swap(int[] arr, int position_1, int position_2){
        int temp = arr[position_1];
        arr[position_1] = arr[position_2];
        arr[position_2] = temp;
    }
}
