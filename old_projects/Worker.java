public class Worker {
    private String name;
    private String surname;
    private double salary;

    /**
     * Constructor with two strings
     *
     * @see <a href="http://youtube.com" target="_blank"> YouTube Page </a>
     * @param name    - gives us the name
     * @param surname - gives us the surname
     */
    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Constructor with two strings and salary
     * 
     * @param name    gives us the name of the Worker
     * @param surname gives us the surname of the Worker
     * @param salary  gives us the Worker's salary
     */
    public Worker(String name, String surname, double salary) {
        this(name, surname);
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * <pre>
     * How to use:
     * Worker p = new Worker();
     * p.setSalary(1000);
     * </pre>
     * 
     * @param newSalary - sets the salary for the Worker
     */
    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    /**
     * <code>Salary</code>
     * Description of the method
     * 
     * @param Salary the salary of this Worker
     * @return returns the salary of the Worker
     * @since version 1.0.0
     * @see Program.Worker#getSalary(double)
     */
    public double getSalary() {
        return salary;
    }
}
