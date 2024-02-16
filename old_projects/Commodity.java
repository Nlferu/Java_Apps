import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Commodity {
    private double price;
    private String name;
    private Date releaseDate;

    public Commodity() {
        this.price = 0.0;
        this.name = " ";
        this.releaseDate = new GregorianCalendar().getTime();
    }

    public Commodity(double price, String name) {
        this();
        this.price = price;
        this.name = name;
    }

    public Commodity(double price, String name, int year, int month, int day) {
        this(price, name);
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.releaseDate = calendar.getTime();
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public Date getReleaseDate() {
        return releaseDate;
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

    @Override
    public String toString() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.releaseDate);
        return this.price + " USD name: " + this.name + " " + calendar.get(Calendar.YEAR) + " year "
                + (calendar.get(Calendar.MONTH) + 1) + " month " + calendar.get(Calendar.DAY_OF_MONTH) + " day ";
    }

    public static void writeToStream(Commodity[] commodities, DataOutput outputStream) throws IOException {
        for (Commodity commodity : commodities)
            commodity.writeData(outputStream);
        System.out.println("File Saved!");
    }

    public static Commodity[] readFromStream(RandomAccessFile RAF) throws IOException {
        int numOfRecords = (int) (RAF.length() / Commodity.Record_Length);
        Commodity[] commodities = new Commodity[numOfRecords];

        for (int i = 0; i < numOfRecords; i++) {
            commodities[i] = new Commodity();
            commodities[i].readData(RAF);
        }
        return commodities;
    }

    public void writeData(DataOutput outputStream) throws IOException {
        outputStream.writeDouble(this.price);

        StringBuffer stringBuffer = new StringBuffer(Commodity.Name_Length);
        stringBuffer.append(this.name);
        stringBuffer.setLength(Commodity.Name_Length);

        outputStream.writeChars(stringBuffer.toString());

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.releaseDate);

        outputStream.writeInt(calendar.get(Calendar.YEAR));
        outputStream.writeInt((calendar.get(Calendar.MONTH) + 1));
        outputStream.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public void readData(DataInput inputStream) throws IOException {
        this.price = inputStream.readDouble();

        StringBuffer stringBuffer = new StringBuffer(Commodity.Name_Length);

        for (int i = 0; i < Commodity.Name_Length; i++) {
            char tempChar = inputStream.readChar();
            if (tempChar != '\0')
                stringBuffer.append(tempChar);
        }
        this.name = stringBuffer.toString();

        int year = inputStream.readInt();
        int month = inputStream.readInt();
        int day = inputStream.readInt();

        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.releaseDate = calendar.getTime();
    }

    public void readRecord(RandomAccessFile RAF, int n) throws IOException, NoRecordFound {
        if (n <= RAF.length() / Commodity.Record_Length) {
            RAF.seek((n - 1) * Commodity.Record_Length);
            this.readData(RAF);
        } else
            throw new NoRecordFound("Unfortunately, there is no such record.");
    }

    public static final int Name_Length = 30;
    public static final int Record_Length = (Character.SIZE * Name_Length + Double.SIZE + 3 * Integer.SIZE) / 8;
}
