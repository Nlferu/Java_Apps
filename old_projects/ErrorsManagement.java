/**
 * Object <code>Documentation</code> First documentation
 * description1
 * description2
 *
 * @author Niferu
 * @version 1.0.0
 *          date 13.11.2019
 */

public class ErrorsManagement {

    public static void main(String[] args) {

        int a = 10;

        if (a == 10)
            try {
                throw new OurException("A is equal to 10"); // throw = throw exception
            } catch (OurException exc) {
                System.out.println(exc.getMessage());
            }

        try {
            System.out.println(5 / 0); // You can add to method void mx (double x) throws Exception, and below if...
                                       // else throw new Exception("Not enough water");
        } catch (ArithmeticException exc) // You can leave just Exception because it's a superclass and arithmetic and
                                          // others
                                          // inherit from it all
        {
            System.out.println("Exception is: " + exc.getMessage());
        } finally {
            System.out.println("This will always pop");
        }

        System.out.println("Rest of the Program");

        /*
         * try {
         * // INSTRUCTIONS THAT MAY POTENTIALLY CAUSE AN ERROR
         * }
         * catch(ReturnedExceptionName variableName) {
         * // INSTRUCTIONS HANDLING THE CAUGHT EXCEPTION
         * }
         */

    }
}

class OurException extends Exception {
    public OurException(String message) {
        super(message);
    }
}
