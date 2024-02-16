import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FilesLessonOne {
    public static void main(String[] args) {
        try {
            File directory = new File("something");
            directory.mkdir(); // creates a directory (folder)

            File multipleDirectories = new File("dir1" + File.separator + "dir2" + File.separator + "dir3"); // File.separator
                                                                                                             // == / as
                                                                                                             // in path
                                                                                                             // in
                                                                                                             // folders
            multipleDirectories.mkdirs();

            File file2 = new File("dir1" + File.separator + "dir2" + File.separator + "dir3", "lesson1.txt");
            if (!file2.exists())
                file2.createNewFile();

            File file = new File("text.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            System.out.println("-----------------------");
            System.out.println(file.getAbsolutePath()); // absolute path
            System.out.println(file.getCanonicalPath()); // always the true path (better)
            System.out.println(file);
            System.out.println("-----------------------");

            System.out.println("Can I write? " + file.canWrite());
            System.out.println("Can I execute? " + file.canExecute());
            System.out.println("Can I read? " + file.canRead());
            System.out.println("Is the file hidden? " + file.isHidden());
            System.out.println("Is it a File? " + file.isFile());
            System.out.println("Last modified: " + new Date(file.lastModified()));
            System.out.println("File length in bytes: " + file.length());

            file.list(); // Returns all visible directories from the given path

            // file.delete (); Deleting a file
            System.out.println("-----------------------");
            System.out.println("-----------------------");
            FilesLessonOne.printAllPaths(new File(System.getProperty("user.dir")));
            System.out.println("-----------------------");
            System.out.println("-----------------------");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.home"));

    }

    public static void printAllPaths(File directoryName) {
        String[] fileNames = directoryName.list();

        System.out.println(directoryName.getPath());

        for (int i = 0; i < fileNames.length; i++) {
            File file = new File(directoryName.getPath(), fileNames[i]);

            System.out.println(file.getPath());

            // if (file.isFile ()) // (Shows only FILES, not directories, from all folders)
            // System.out.println (file.getPath ()); // If it's a file, print paths,
            // otherwise don't!

            if (file.isDirectory())
                printAllPaths(new File(file.getPath())); // If it encounters a folder, the path name will no longer be
                                                         // 'lesson1' or the original one, it will change to the new one
        }
    }

}
