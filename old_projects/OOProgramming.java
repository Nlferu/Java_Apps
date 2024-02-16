public class OOProgramming {

    public static void main(String[] args) {

        /*
         * 
         * Settery i Gettery
         * 
         */

        BankAccount Savings = new BankAccount();

        Savings.wyplac(300);
        System.out.println("Current Balance:" + " " + Savings.getBalance());

        Savings.wplac(2000);
        System.out.println("Current Balance:" + " " + Savings.getBalance());

    }
}

class BankAccount {
    public BankAccount() {
        Balance = 1000;
        System.out.println("Current Balance:" + " " + Balance);
    }

    private double Balance; // private dziala tylko wewnatrz klasy

    double getBalance() {
        return Balance;
    }

    private boolean setBalance(double Balance) {
        /*
         * WARUNKI! zaloguj sie login + haslo
         */
        this.Balance = Balance;

        return true;
    }

    boolean wyplac(double ile) {
        if (Balance < ile) {
            System.out.println("Balance is too low");
            return false;
        } else
            Balance -= ile;
        System.out.println("Withdrawed:" + " " + ile);
        return true;
    }

    boolean wplac(double ile) {
        setBalance(Balance + ile); // mozna zapisac zamiast += w taki sposob jak po lewej
        System.out.println("Deposited" + " " + ile);
        return true;
    }

}
