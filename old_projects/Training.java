public class Training {

    public static void main(String[] args) {

        // instance of - czy cos jest instancja obiektu

        Person[] person = new Person[4];
        person[0] = new Worker("Marcin", "Flet", 1000);
        person[1] = new Student("Rysio", "Groch");
        person[3] = new Worker("Jadsasio", "Ramboroch", 666);

        person[0].getDesc();

        for (int i = 0; i < person.length; i++) {
            if (person[i] instanceof Person) // jesli osoba[i] jest instancja klasy Osoba wtedy wykonaj funkcje getDesc
                                             // idac po petli
                person[i].getDesc();
            else // break po to zeby zatrzymal sie po podanych osobach a nie sprawdzal all do
                 // konca jak nie ma elementow
                break;
        }

        for (Person item : person) {
            if (item instanceof Person) // inny sposob na to samo - czyli ulepszona petla for (enhanced for)
                item.getDesc();
            else // break po to zeby zatrzymal sie po podanych osobach a nie sprawdzal all do
                 // konca jak nie ma elementow
                break;
        }

        for (Person item : person) {
            if (item instanceof Worker)
                ((Worker) item).working(); // Downcasting = Rzutowanie w dol, czyli z super klasy program idzie w dol i
                                           // bierze dane z podklasy(jesli podklasa ma wiecej)
            else if (item instanceof Student) {
                Student tmp = (Student) item; // to samo zapisane inaczej
                tmp.getDesc(); // late binding (Program wywola tylko Studentow)
            }
        }

    }
}

abstract class Person {
    String name;
    String surname;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    abstract void getDesc();
}

class Worker extends Person {
    double salary;

    Worker(String name, String surname, double salary) {
        super(name, surname);
        this.salary = salary;
    }

    @Override
    void getDesc() {
        System.out.println("I'm worker:");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Salary: " + salary);
    }

    void working() {
        System.out.println("I'm working");
    }
}

class Student extends Person {
    Student(String name, String surname) {
        super(name, surname);
    }

    @Override
    void getDesc() {
        System.out.println("I'm student:");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
    }
}
