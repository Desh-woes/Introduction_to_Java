public class Bubble_sort {

    // Main function where we call our sorting algorithm
    public static void main(String[] args) {
        // Define test array
        int [] arr= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        // Sort test array
        sort_array(arr);

        // Display sorted elements in test array
        for (int i = 0; i < arr.length; i = i+1){
            System.out.println(arr[i]);
        }


    }

    // Function that helps us with our sorting
    public static int[] sort_array(int[] arr) {

        // By default, our array is not sorted
        boolean array_sorted = false;

        // List end
        int list_end = arr.length - 1;

        // While array is not sorted, go through the array and bubble the largest element to the end.
        while (!array_sorted){

            // First set the array to be sorted.
            array_sorted = true;

            // Go through the array and check if there is any element that is out of place.
            for (int i = 0; i < list_end; i = i + 1){

                // If array value in position x is grater than array value in position x+1, swap.
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);

                    // If we find any elements that are not sorted, then our array_sorted value becomes false
                    array_sorted = false;
                }

            }
            // Decrease our list end because we know the right part of our list is already sorted.
            list_end = list_end - 1;

        }
        // If all elements have been sorted, the while loop ends and returns our sorted array.
        return arr;
    }


    // Function to help with the swapping process.
    public static void swap(int[] arr, int position_1, int position_2){
        int temp = arr[position_1];
        arr[position_1] = arr[position_2];
        arr[position_2] = temp;
    }
}
