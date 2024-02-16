public class IntMultiplicatorSec {

    public static void main(String[] args) {

        int[] Tablica1 = new int[10];

        for (int i = 0; i < 10; i++)

            Tablica1[i] = i + 1;

        for (int i = 0; i < 10; i++)

            System.out.println("Tablica2: " + Tablica1[i] * 10);
    }
}
