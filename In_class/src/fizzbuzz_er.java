import java.util.Stack;

public class fizzbuzz_er {

    public static String fizzbuzz(long value){
        if (value != 0 && value%3 == 0){
            return "Fizz";
        }

        else if (value != 0 && value%5 == 0){
            return "buzz";
        }

        return null;
    }

    public static Boolean is_palindrome(String test_str){
        Stack new_stack = new Stack();

        for (Character i: test_str.toCharArray()) {
            new_stack.push(i);
        }

        StringBuilder new_str = new StringBuilder();
        while (!new_stack.empty()){
            new_str.append(new_stack.pop());
        }

        return new_str.toString().equalsIgnoreCase(test_str);
    }

    public static void main(String[] args) {
        System.out.println(fizzbuzz(1000000000));

    }
}
