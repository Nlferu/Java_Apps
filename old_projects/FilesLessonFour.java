import java.io.*;

public class FilesLessonFour {
    // Tokenization - dividing into elements, token - token/element
    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Product();
        products[1] = new Product(29.0, "Coffee");
        products[2] = new Product(399.0, "Gold", 2020, 02, 21);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("ProductsDatabase.txt")); // Writing to a txt file

            Product.saveToFile(products, writer);

            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("ProductsDatabase.txt"));

            Product[] products2 = Product.readFromFile(reader);

            for (int i = 0; i < products2.length; i++)
                System.out.println(products2[i]);

            reader.close();

            // LESSON 5 !!!!!!!!

            /*
             * // FileOutputStream outS = new FileOutputStream("New.txt"); // writes in
             * bytes, always 8 characters for numbers, 2 bits for characters e.g. String
             * DataOutputStream outS = new DataOutputStream(new
             * FileOutputStream("New.txt")); // writes in binary form, the above and this
             * method consume less memory and space
             * 
             * //outS.write(49);
             * outS.writeDouble(1242.323);
             * 
             * outS.close();
             * 
             * DataInputStream inS = new DataInputStream(new FileInputStream("New.txt"));
             * 
             * System.out.println(inS.readDouble());
             * 
             * inS.close(); // 8 bytes is 64 bits in size in Product.java
             */

            RandomAccessFile RAF = new RandomAccessFile("New.txt", "rw"); // r - readable, w - writable, the second
                                                                          // parameter is a string that tells what to do
                                                                          // with the file

            RAF.writeDouble(45.666);
            RAF.writeDouble(8888.8888);
            RAF.writeChars("Lama "); // there must be a space at the end!! otherwise it writes in Chinese xD idk why

            System.out.println(RAF.getFilePointer()); // indicates where in the file we are

            RAF.seek(8); // reading position in bytes, 0 is the first digit, 8 is the second digit

            System.out.println(RAF.readDouble());
            System.out.println(RAF.readChar());
            System.out.println("Double: " + Double.SIZE + " Int: " + Integer.SIZE); // size of variables like Double in
                                                                                    // bits, dividing by 8 gives bytes!

            RAF.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
