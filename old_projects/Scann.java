import java.util.Scanner;

public class Scann {

    public static void main(String[] args) {
        int fnum, snum;

        System.out.println("Witaj w Programie!");
        System.out.println("Wpisz pierwszy parametr: ");

        Scanner x = new Scanner(System.in);
        fnum = x.nextInt();

        System.out.println("Wpisz drugi parametr: ");

        Scanner y = new Scanner(System.in);
        snum = y.nextInt();

        System.out.println("Oto Twoj wynik!!!");

        int i, j;

        for (i = 1; i <= fnum; i++)

            for (j = 1; j <= snum; j++) {
                if (j == snum) {
                    System.out.println(i * j + " ");
                } else {
                    System.out.print(i * j + " ");
                }
            }
    }
}
