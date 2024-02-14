import java.util.Scanner;

public class Initial {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scan.nextLine();
        System.out.println("Hello " + name);
        scan.close();
    }
}
