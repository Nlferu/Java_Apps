public class ConditionalInstructions {

    public static void main(String[] args) {

        // Additional conditions
        int x = 3,
                y = 3;
        if (x > y)
            System.out.println("x > y");
        else if (x < y) {
            System.out.println("x < y");
            System.out.println(
                    "You can have multiple ifs, but at the end there should be an else, but it doesn't have to be");
        } else
            System.out.println("x = y");

        // Switch, you can compare characters and integers
        int a = 25345;
        switch (a) {
            case 10:
                System.out.println("a is equal to 10");
                break;

            case 25:
                System.out.println("a is equal to 25");
                break;

            default:
                System.out.println("a is equal to" + " " + a);
        }

        // Simplifying notation

        int v = 3;
        if (v % 2 == 0)
            System.out.println("Even number");
        else
            System.out.println("Odd number");

        // After the "?" sign, we write what should happen when "True"
        // After the ":" sign, we write what should happen when "False"

        String IsEvenNumber = (v % 2 == 0) ? "Even" : "Odd";
        System.out.println(IsEvenNumber);

    }
}
