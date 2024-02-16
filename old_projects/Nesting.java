public class Nesting {

    public static void main(String[] args) {

        BankAccount bankAcc = new BankAccount(1000);

        System.out.println(bankAcc.getBalance());

        bankAcc.calculateInt(5);

        System.out.println(bankAcc.getBalance());

        // Klasy anonimowe - LAMBDA to skrocony zapis klasy anonimowej

        AfterMagic x = new AfterMagic() // klasa anonimowa
        {
            @Override
            public void action() {
                System.out.println("I'm from annonymous class");
            }
        };

        x.action();

        // klasa anonimowa przy uzyciu LAMBDA
        // LAMBDA moze byc uzyta tylko dla interfejsu z JEDNA akcja!!!!

        AfterMagic y = () -> // mozna tez bez {} wtedy po strzalce sout;
        {
            System.out.println("I'm from LAMBDA annonymous class");
        };

        y.action();

        // Agregacja i kompozycja

        Worker w = new Worker("Marcin", new Adress("Podlaska", 8));

        System.out.println(w);

        // LAMBDA testing

        AfterLambda z = (a, b) -> a + b;

        double results = z.action(10, 15);

        System.out.println(results);

        AfterLambda c = (a, b) -> {
            System.out.println("Dzielenie: ");
            return a / b;
        };

        double res = c.action(33, 66);

        System.out.println(res);

        Form sq = (a) -> a;

        double fin = sq.calculate(4);
        double fiz = sq.sqrt(25);

        System.out.println(fin);
        System.out.println(fiz);

        A rams = new A();
        System.out.println(rams.calculate(20));
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return this.balance;
    }

    void calculateInt(double rate) // jesli dodamy final to wtedy mozna usunac rate z class'y Interests i bedzie
                                   // dzialalo all
    {
        Interests interests = new Interests(rate);
    }

    class Interests // klase ta mozna tez wrzucic do metody poprzedniej klasy np. start i tez bedzie
                    // smigac
    {

        private double interestsRate;

        public Interests(double interestsRate) {
            this.interestsRate = interestsRate;
            this.changeBalance(interestsRate);
        }

        void changeBalance(double rate) {
            double interests = (balance * rate) / 100;
            balance += interests;
        }

    }

}

interface AfterMagic {
    void action();
}

interface AfterLambda {
    double action(double a, double b);
}

interface Form // Domyslne metody interfejsow, abstrakcyjna i publiczna
{
    double calculate(int a);

    default double sqrt(int a) // Default pozwala uzyc lambdy wyzej poniewaz default nie jest abstrakcyjne
    {
        return Math.sqrt(a);
    }
}

class A implements Form {

    @Override
    public double calculate(int a) {
        return this.sqrt(a * 5);
    }

}

class Merlin implements AfterMagic {
    @Override
    public void action() {
        System.out.println("Marlin 1 hits!");
    }
}

class Merlin2 implements AfterMagic {
    @Override
    public void action() {
        System.out.println("Merlin 2 crits!");
    }
}

class Worker {
    String name;
    Adress adress; // agregacja czyli laczenie klass

    public Worker(String name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return this.name + ": " + adress.road + " " + adress.houseNumber;
    }
}

class Adress {
    String road;
    int houseNumber;

    public Adress(String road, int houseNumber) // auto constructor create is: Alt + Insert
    {
        this.road = road;
        this.houseNumber = houseNumber;
    }
}
