import java.io.*;

public class FilesLessonTwo {
    public static void main(String[] args) throws IOException {
        File file = new File("fileName.txt"); // allows you to find a file/path to a file

        // InputStream inS;
        // OutputStream outS;
        // Reader reader;

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        /**
         * Writer automatically creates a file if it doesn't exist
         * All data is stored in a buffer, after closing the stream, they are all
         * sent at once (faster program operation)
         * 2x new Connecting streams, BufferedWriter - memory space for temporary data
         * storage
         * FileOutputStream - opens a stream, OutputStreamWriter - allows writing to
         * a file, BufferedWriter - writes to file + stored in memory and sent in
         * packets
         */

        writer.write("Meow");

        ((BufferedWriter) writer).newLine();
        ((BufferedWriter) writer).write("Next line");

        ((BufferedWriter) writer).close(); // We always have to close the inputStream!!
    }

    void functionName(InputStream inS) {

    }
}
