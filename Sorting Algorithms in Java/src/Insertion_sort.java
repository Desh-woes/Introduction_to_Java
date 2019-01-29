public class Insertion_sort {

    public static void main(String[] args) {
        // Define test array
        int [] arr= {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};

        // Sort test array
        sort_array(arr);

        // Display sorted elements in test array
        for (int i : arr){
            System.out.println(i);
        }

    }

    public static void sort_array(int[] arr) {

        // Insertion sort assumes that the elements to the left has been sorted
        for (int i = 1; i < arr.length; i = i + 1){

            // Our current value iterator points to the value we want to place in a sorted position
            int curr_value = arr[i];

            // Second iterator to check elements to the left of our current value
            int j = i - 1;

            // While the numbers to the left of our current value are larger than our current value, shift the values
            while (j >= 0 && arr[j] > curr_value){

                // Shift the value to the right and look at the value to the left
                arr[j+1] = arr[j];
                j = j - 1;
            }
            // In a case where our current value is not less than the value in position J, insert current value into position j+1
            arr[j+1] = curr_value;
        }
        // Return sorted list
//        return arr;
    }
}
