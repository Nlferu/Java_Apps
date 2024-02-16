import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Product {
    public Product() {
        this.price = 0.0;
        this.name = " ";
        this.releaseDate = new GregorianCalendar().getTime();
    }

    public Product(double price, String name) {
        this(); // calling the default constructor (the one above) in this object to reset all +
                // create date
        this.price = price;
        this.name = name;
    }

    public Product(double price, String name, int year, int month, int day) {
        this(price, name); // calls the constructor above
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day); // -1 because it starts from 0
        releaseDate = calendar.getTime();
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.releaseDate = calendar.getTime();
    }

    public void setDate(Date date) {
        this.releaseDate = date;
    }

    public String toString() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.releaseDate);
        return this.price + " USD name: " + this.name + " " + calendar.get(Calendar.YEAR) + " year "
                + (calendar.get(Calendar.MONTH) + 1) + " month " + calendar.get(Calendar.DAY_OF_MONTH) + " day ";
    }

    public static void saveToFile(Product[] products, PrintWriter outS) {
        outS.println(products.length);

        GregorianCalendar calendar = new GregorianCalendar(); // base time

        for (int i = 0; i < products.length; i++) {
            calendar.setTime(products[i].getReleaseDate()); // after looping, we change the time to the time in the
                                                            // object
            // Tokenization of data, separating them with a chosen delimiter, in our case
            // "|"
            outS.println(products[i].getPrice() + "|" + products[i].getName() + "|" + calendar.get(Calendar.YEAR) + "|"
                    + (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
        }

        System.out.println("File Saved!");
    }

    public static Product[] readFromFile(BufferedReader inS) throws IOException {
        int length = Integer.parseInt(inS.readLine()); // casting to int

        Product[] products = new Product[length];

        for (int i = 0; i < length; i++) {
            String line = inS.readLine();
            StringTokenizer tokens = new StringTokenizer(line, "|"); // it will divide into tokens, replacing the tokens
                                                                     // used in the txt file "|" with data from toString
                                                                     // and print in the program with appropriate
                                                                     // assignments, e.g. USD

            double price = Double.parseDouble(tokens.nextToken());
            String name = tokens.nextToken();
            int year = Integer.parseInt(tokens.nextToken());
            int month = Integer.parseInt(tokens.nextToken());
            int day = Integer.parseInt(tokens.nextToken());

            products[i] = new Product(price, name, year, month, day);
        }

        return products;
    }

    public static final int Name_Length = 30; // Lesson 5!
    private double price; // 8 bytes = 64 bits
    private String name; // needs to be determined, e.g. Name_Length * 2 bytes
    private Date releaseDate; // integer takes 4 bytes, 4 + 4 + 4 = 12 bytes (because 3 dates) TOGETHER with
                              // maximum of 80 bytes!
}
