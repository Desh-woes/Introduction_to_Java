import java.util.Scanner;

public class AkanNames {

    public static void main(String[] args) {
//        Getting user input
        Scanner reader = new Scanner(System.in);
//        int x = reader.nextInt();
//        System.out.println(x);

        // Getting user input for date of birth
        System.out.println("Please enter your date of birth");
        int day_input = reader.nextInt();

        System.out.println("Please enter your month of birth");
        int month_input = reader.nextInt();

        System.out.println("Please enter your year of birth");
        int year_input = reader.nextInt();

        System.out.println("Please enter your gender");
        String gender_input = reader.nextLine();


        System.out.println(akan(day_input, month_input, year_input));
    }

    public static int akan(int day, int month, int year){
        int yo = year - (14-month)/12;
        int x = yo + yo/4 - yo/100 + yo/400;
        int mo = month+12* ((14-month)/12) - 2;

        return (day + x + (31*mo)/12)%7;

    }
}
