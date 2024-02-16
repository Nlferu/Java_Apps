public class Loops {

    public static void main(String[] args) {

        String[] Mauppa = {
                "Miauka miala chalke",
                "Rychu peja solowa",
                "Dzwonie na paly",
                "Halo Policja",
                "Uuuu maakarenaaa",
                "Lamalala +1 do wiedzy"
        };

        int i = 0;

        while (i < Mauppa.length) // while = zapetlanie
        {
            if (i != 1) // jesli i rozne od 1 wypisz sout, inaczej nie wypisuj nic (czyli nie wypisuj
                        // i=1, pamietamy, ze liczymy tabele od 0)
                System.out.println(Mauppa[i]);
            i++; // ++ przesuwanie od i=0 o 1 do przodu po kazdej petli (zrunnowaniu)
        }

        i = 0; // wyzerowanie "i"
        do // wykonuj dopoki warunek while nie zostanie spelniony
        {
            System.out.println(Mauppa[i]);
            i++;
        } while (i < Mauppa.length);

        /*
         * To samo dziala dla komendy "for"
         * for(inicjalizacja zmiennych; warunek petli; co ma sie stac po wykonaniu
         * polecenia)
         * 
         * for (int i = 0; i < Mauppa.length; i++)
         * {
         * System.out.println(Mauppa[i]);
         * }
         */
    }
}
