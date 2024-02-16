public class Objects {

    public static void main(String[] args) {

        /*
         * 
         * Class posiada: (w klasie jest wiele obiektow, ktore maja
         * parametry(int,double) i funkcje(void))
         * 
         * Konstruktor - konstruuje nam obiekt czyli go opisuje (MUSI SIE NAZYWAC JAK
         * KLASA, METODA NIE!!!)
         * 
         * Parametry: np. szerokosc, wysokosc;
         * 
         * Funkcje: np. wlacz, wylacz;
         * 
         * Przeciazanie metod to np. dla funkcji "dzielenie" na dole zrobienie i int'ow
         * i double'ow (tak samo all), wtedy program sam wybiera z ktorej skorzystac i
         * wyszarzy to drugie
         * 
         * this. uzywamy dla np. class Point a w niej x = 5 i konstruktor a w nim x =
         * 100 oraz Point.this.x wtedy po wywolaniu sout dostaniemy 5 a bez this.
         * dostaniemy 100
         * lub w konstruktorze kiedy odwolujemy sie do tych samych parametrow
         * np. nad konstruktorem mamy int x oraz int y a w konstruktorze Punkt(int x,
         * int y) wtedy { this.x = x and this.y = y } //
         */

        Punkt p = new Punkt(); // konstruktor domyslny wywolujemy kiedy nie ma parametrow w nawiasach
        System.out.println(p.x);
        System.out.println(p.y);
        System.out.println(p.c);

        Punkt p2 = new Punkt(3, 33); // konstruktor z parametrami
        System.out.println(p2.x);
        System.out.println(p2.y);
        System.out.println(p2.z);
        // this. to obiekt na ktorym aktualnie pracujesz
        Punkt funkcje = new Punkt();

        funkcje.wypisz("Tenkan", "Sen", 10); // w nawiasie podajemy argumenty

        int wynik = funkcje.dodawanie(3, 8); // jak mamy zwracanie to musimy podac co to jest i dopiero "="
        System.out.println(wynik);

        double wynik2 = funkcje.dzielenie(5, 7);
        System.out.println(wynik2);

        String imie = "Lama";
        String imie2 = "Lama";

        System.out.println("Porownanie Stringow:" + imie.equals(imie2)); // Porownywanie Stringow .equals zamiast == (bo
                                                                         // == porowna nam adresy a nie wartosci
                                                                         // Stringa)

    }
}

class Punkt {
    double x; // definiujemy czym maja byc x i y, bez tego program nie ruszy
    int y; // mozna tez zdefiniowac zmienne od razu w konstruktorze lub metodzie
    int z;
    double c;

    Punkt() // to jest konstruktor, a w nim piszemy co ma sie stac po jego wywolaniu wyzej
    { // w nawiasie konstruktora sa parametry
        System.out.println("Wywolano konstruktor domyslny");
        x = 10.05; // wartosci domyslne tych dwoch zmiennych
        y = 20;
        c = x + y;
    }

    Punkt(int pierwszy, int drugi) // mozna sie odwolac wyzej do Punkt ble = new Punkt(5,10)
    {
        System.out.println("Wywolano konstruktor dla dwoch zmiennych");
        x = pierwszy;
        y = drugi;
        this.z = pierwszy + drugi; // this.stosujemy kiedy mamy kolize nazw i odwolujemy sie do "z" bazowego
                                   // zdefiniowanego zaraz pod klasa
    }

    // metody(funkcje) sluza do opisania np. obliczen, wypisania na ekran itd
    void wypisz(String first, String second, double x) // void = metoda, ktora nic nie zwraca (brak return)
    {
        System.out.println(first + " " + second + " " + x);
    }

    int dodawanie(int a, int b) // int, double itd zwracaja (return)
    {
        System.out.println("Dodawanie");
        return a + b;
    }

    double dzielenie(double j, double k) {
        if (k == 0)
            return 0;
        if (j != 5)
            return 1;

        // moze ale nie musi tu byc "else"
        System.out.println("Dzielenie");
        return j / k;
    }

}