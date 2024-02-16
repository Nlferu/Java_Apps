import java.io.*;

public class FilesLessonThree {

    public static void main(String[] args) {
        try {
            PrintWriter printer = new PrintWriter(new FileWriter("Data.txt")); // second parameter true = data will be
                                                                               // written to the file all at once
                                                                               // instead of creating a new file each
                                                                               // time

            printer.println(1234);
            // printer.flush(); // forces writing despite the stream still being open

            printer.close(); // You must close the stream or else data writing and other operations won't
                             // work; it must always be at the end

            printer = new PrintWriter(new FileWriter("Data.txt", true));

            printer.append("Mango");
            printer.println();
            printer.printf("It weighs %d kg and is %.2f %s tall", 50, 188.458, "cm"); // placeholder %d - for integers,
                                                                                      // %f - for floating-point
                                                                                      // numbers, .2 - for two decimal
                                                                                      // places, %s - for strings

            printer.close();

            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));

            // System.out.println((char)reader.read()); // reads only the first character
            // System.out.println(reader.readLine()); // prints one line

            BufferedWriter writer = new BufferedWriter(new FileWriter("Database.txt")); // another text file

            String content = "";
            while ((content = reader.readLine()) != null) // checks if the line is not null, then continues reading,
                                                          // prints all data from the file
            {
                writer.write(content); // moves and writes the read files from the Data.txt file to the Database.txt
                                       // file in one line
                writer.newLine(); // adds a new line after each reading
                // System.out.println(content);
            }

            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Main.test(1, 34, 32.233, "Lama", 85, "Orgon"); // storing all data in an
        // Object type variable named "a", allowing multiple arguments of different
        // types to be stored in Object a

    }

    static void test(Object... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
