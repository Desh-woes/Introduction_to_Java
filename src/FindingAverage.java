public class FindingAverage {

    public static float average(int[] array) {
        float sum_values = 0;

        for (int i = 0; i < array.length; i = i + 1){
            sum_values = sum_values + array[i];
        }

        return sum_values/array.length;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(average(list));
    }
}
