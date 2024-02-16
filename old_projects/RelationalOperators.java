public class RelationalOperators {

    public static void main(String[] args) {

        // Prawda fałsz

        int a = 1, b = 3;
        boolean Porównanie = a == b;
        System.out.println(Porównanie);

        boolean Porównanie2 = 4 == 4;
        System.out.println(Porównanie2);

        // Operatory logiczne (&& = i), (|| = lub), (!=(rożne)), (==(równe))

        int aa = 3,
                bb = 8,
                cc = 8;
        if (aa != bb && cc >= 8)
            System.out.println("Zgadza się");

        if (aa == bb && cc >= 8)
            System.out.println("Nie zgadza się"); // tutaj jest fałsz więc nie otrzymamy nic w konsoli, dostaniemy puste
                                                  // pole

        int x = 3,
                z = 8,
                y = 8;
        boolean PrawdziweLubFałszywe = (x == z || y >= 8);
        System.out.println(PrawdziweLubFałszywe);

        /*
         * Operatory bitowe:
         * 
         * #Przed kazdym kodem 01 jest nieskonczona ilosc 0
         * 0 - false 1 - true
         * & - iloczyn bitowy
         * | - suma bitowa
         * ^ - OR
         * x << 1 - przesunięcie w lewo o 1
         * x >> 2 - przesunięcie w prawo o 2
         * 
         * potega 4-1 bo są 4 cyfry
         * 1 0 1 0 = 1 * 2^(4-1) + 0 * 2^(3-1) + 1 * 2^(2-1) + 0 * 2^(1-1) = 8 + 0 + 2 +
         * 0 = 10
         * 1 1 1 1 = 8 + 4 + 2 + 1 = 15
         * 
         * Iloczyn & (koniunkcja)
         * 1 0 1 0
         * 1 1 1 0
         * 
         * 1 0 1 0 = 10
         * 
         * Suma | (alternatywa)
         * 1 0 1 0
         * 1 1 1 0
         * 
         * 1 1 1 0 = 14
         * 
         * XOR ^
         * 1 1 = 0
         * 1 0 = 1
         * 0 1 = 1
         * 0 0 = 0
         * 
         * 1 0 1 0
         * 1 1 1 0
         * 
         * 0 1 0 0 = 4
         * Funkcja np. System.out.println(10^14);
         * 
         * Przesunięcia <<, >>
         * 
         * 1 0 1 0 = 1 0 1 0 0 << o 1
         * 1 1 1 0 = 0 0 1 1 >> o 2
         * 
         * 1 0 1 0 = 10 x << 1 = 20 inaczej x*2, x << 3 = x*8
         * 1 1 1 0 = 14 x >> 2 = 3 inaczej x/4 (14/4=3,5 liczba calkowita int = 3), x >>
         * 4 (2^4=16) = x/16
         * 
         * Funkcja np. System.out.println(14 << 2);
         * 
         * ~ negacja (zamienia WSZYSTKIE 0 na 1 i odwrotnie)
         * 1 0 1 0 = 0 1 0 1 ALE PRZED KODEM NIE MA JUZ 0 TYLKO SA 1
         * 1 0 1 0 = 10
         * ~10 = -11
         * System.out.println(~10);
         */

        System.out.println(~10);

    }
}
