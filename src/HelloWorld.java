// Exploring functions in Java
// Function to print hello world

public class HelloWorld {
    // Public: Defines who has access to the defined function
    // Static: **Not sure what this does yet
    // Void: Defines the return type of the function written
    // 'main': Defines the name of the function

    public static void main(String[] args) {
        // System.out.print: prints in same line
        // System.out.println is the equivalent of print in python. Prints in new line
        System.out.println("Hello World");

        // In java, when declaring a variable, you have to specify the variable type
        char gender = 'M';
        int age = 20;

        // Java is good at converting primitive types so you can add an integer to a sting without explicit
        // Conversion
        System.out.println("Hello " + (age+age));

        // Using my defined function
        print_fake("My name is Oluwarotimi E.");
    }

    // Defined a fake print function to mimic the simple print statement in Python
    public static void print_fake(String text) {
        System.out.println(text);
    }
}