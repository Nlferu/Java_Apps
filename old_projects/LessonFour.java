import java.io.*;

public class LessonFour {

    // Tokenization - splitting into elements, token - element
    public static void main(String[] args) {
        Commodity[] goods = new Commodity[3];

        goods[0] = new Commodity();
        goods[1] = new Commodity(29.0, "Coffee");
        goods[2] = new Commodity(399.0, "Gold", 2020, 02, 21);

        try {
            RandomAccessFile RAF = new RandomAccessFile("Database.txt", "rw"); // r - readable, w - writable, second
                                                                               // parameter is a string that tells what
                                                                               // to do with the file

            Commodity.writeToStream(goods, RAF);
            // after writing, getFilePointer is at the end of all saved data, so before
            // reading you have to rewind it

            RAF.seek(0);

            Commodity[] storedGoods = Commodity.readFromStream(RAF);

            for (int i = 0; i < storedGoods.length; i++) {
                System.out.println(storedGoods[i].getPrice());
                System.out.println(storedGoods[i].getName());
                System.out.println(storedGoods[i].getReleaseDate());
                System.out.println("--------------------------");
            }

            /*
             * int n = 2;
             * RAF.seek((n - 1) * Commodity.Record_Length);
             * 
             * Commodity a = new Commodity();
             * a.readData(RAF);
             * 
             * System.out.println(a);
             */
            try { // try, catch is much better than if when it comes to error handling
                Commodity b = new Commodity();
                b.readRecord(RAF, 23);

                System.out.println(b);
                System.out.println("Lama");
            } catch (NoRecordFound err) {
                System.out.println(err.getMessage());
            }

            RAF.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
