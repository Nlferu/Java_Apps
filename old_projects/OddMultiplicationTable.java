public class OddMultiplicationTable {

    public static void main(String[] args) {

        for (int a = 1; a <= 10; a++) {
            for (int b = 1; b <= 10; b++) {
                if (b % 2 == 0) {
                    continue;
                }
                if (a % 2 == 0) {
                    continue;
                }
                System.out.print(a * b + " ");
            }
            System.out.println();
        }
    }
}
