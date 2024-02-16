public class LoopsTwo {

    public static void main(String[] args) {

        String[] Mauppa = {
                "Miauka miala chalke",
                "Rychu peja solowa",
                "Dzwonie na paly",
                "Halo Policja",
                "Uuuu maakarenaaa",
                "Lamalala +1 do wiedzy"
        };

        // for(inicjalizacja zmiennych; warunek petli; co ma sie stac po wykonaniu
        // polecen wszystkich w petli)

        for (int i = 0; i < Mauppa.length; i++) {
            System.out.println(Mauppa[i]);
        }

        // Enhanced For

        for (String Pojemnik1 : Mauppa) // Ze zbioru "Mauppa" pobierz mi wartosci tego zbioru i wypisz
        {
            System.out.println(Pojemnik1);
        }

        // Pętla w pętli

        for (int a = 1; a <= 10; a++) {
            for (int b = 1; b <= 10; b++) {
                System.out.print(a * b + " ");
            }

            System.out.println();
        }

        // Continue i Break

        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0)
                continue; // Kiedy reszta z dzielenia przez 2 jest rowne 0, nie wykonuj polecenia
                          // println(x)
            System.out.println(x);
        }

        for (int y = 0; y < 10; y++) {
            if (y == 4)
                break; // Kiedy y jest rowne 4, nie wykonuj w ogole polecenia println(x) i zakoncz
                       // petle
            System.out.println(y);
        }

        // Działania w pętli dla zmiennych

        int[] liczby = { 1, 33, 88, 109 };
        int suma = 0;

        for (int g = 0; g < liczby.length; g++) {
            suma += liczby[g]; // mozna tez zapisac to jako "suma = suma + liczby[g];"
        }
        System.out.println(suma);
    }
}
