import java.util.Arrays;
import java.util.Collections;

public class Interface {

    public static void main(String[] args) {

        // interface == class (METHODS - they are public and abstract, PROPERTIES -
        // public, final, and static)
        // with interfaces, we demand certain behavior from classes

        interfaceName a = new Worker(); // you cannot refer to an interface, only to a class

        ((Worker) a).getSalary();
        System.out.println(interfaceName.PI);

        int[] table = new int[5];
        table[0] = 3;
        table[1] = 0;
        table[2] = 11;
        table[3] = 88;
        table[4] = -3;

        Arrays.sort(table);
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }

        Worker[] worker = new Worker[3];
        worker[0] = new Worker(7000);
        worker[1] = new Worker(1000);
        worker[2] = new Worker(13000);

        System.out.println(worker[0].compareTo(worker[1]));

        System.out.println("Without sorting");
        for (Worker w : worker) // print all without sorting
        {
            System.out.println(w.getSalary());
        }

        Arrays.sort(worker); // print all after sorting in ascending order (default)

        System.out.println("After sorting");
        for (Worker w : worker) {
            System.out.println(w.getSalary());
        }

        Arrays.sort(worker, Collections.reverseOrder()); // print all after sorting in descending order

        System.out.println("After reverse sorting");
        for (Worker w : worker) {
            System.out.println(w.getSalary());
        }

    }
}

interface interfaceName {
    double PI = 3.14; // public static final

    void smth(); // public abstract

}

interface someth {

}

// interface `implements` can be extended by as many classes as we want
class Worker implements interfaceName, someth, Comparable<Object> {
    public Worker() {

    } // extends - we only extend by 1 class

    @Override
    public void smth() {

    }

    private double salary;

    Worker(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public int compareTo(Object o) {
        Worker sent = (Worker) o;

        if (this.salary < sent.salary)
            return -1;

        else if (this.salary > sent.salary)
            return 1;

        return 0;
    }
}
