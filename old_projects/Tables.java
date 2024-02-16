public class Tables {

    public static void main(String[] args) {

        /*
         * Tablice zaczynamy liczyć od 0
         * np. [5] to tablica skladajaca sie z {0,1,2,3,4}
         */

        int[] Tablica1 = new int[5];
        Tablica1[0] = 33;
        Tablica1[1] = 12;
        Tablica1[2] = 66;
        Tablica1[3] = 879;
        Tablica1[4] = 777;
        System.out.println(Tablica1[3]);

        int[] tab2 = { 3, 8, 77, 666 };
        System.out.println(tab2[2]);
        System.out.println(tab2.length); // "length = długość tablicy
        System.out.println(tab2[tab2.length - 1]); // ostatni element tablicy

        // Tablice wielowymiarowe,

        int[][] tab1 = new int[4][3]; // Pierwsza to ilosc wierszy, druga to kolumny
        tab1[2][1] = 55;
        System.out.println(tab1[2][1]);

        int[][] tab3 = {
                { 342, 432, 88 },
                { 22, 1, -2345 },
                { 77, 44, 11 },
                { 3214, 34422, 700 },
        };
        System.out.println(tab3[3][1]);

    }
}
