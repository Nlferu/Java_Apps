public class BottlesChallenge {

    public static void main(String[] args) {

        // Zadanie: Butelki manualne

        Butelki[] butelka = new Butelki[3];

        butelka[0] = new Butelki(10, 20);
        butelka[1] = new Butelki(15, 30);
        butelka[2] = new Butelki(5, 10);

        butelka[0].wlej(7);
        butelka[1].wylej(1);
        butelka[1].przelej(4, butelka[2]);

        System.out.println(
                butelka[0].getIloscLitrow() + " " + "Litrow" + " " + butelka[0].getPojemnosc() + " " + "Pojemnosc");
        System.out.println(
                butelka[1].getIloscLitrow() + " " + "Litrow" + " " + butelka[1].getPojemnosc() + " " + "Pojemnosc");
        System.out
                .println(butelka[2].IloscLitrow + " " + "Litrow" + " " + butelka[2].getPojemnosc() + " " + "Pojemnosc");

    }
}

class Butelki {
    double IloscLitrow;
    double Pojemnosc;

    Butelki(double IloscLitrow, double Pojemnosc) {
        this.IloscLitrow = IloscLitrow;
        this.Pojemnosc = Pojemnosc;
    }

    double getIloscLitrow() {
        return IloscLitrow;
    }

    double getPojemnosc() {
        return Pojemnosc;
    }

    boolean wlej(double ilosc) {

        if (Pojemnosc >= (IloscLitrow + ilosc))
            IloscLitrow += ilosc; // dodaj do siebie ilosc
        else {
            IloscLitrow = Pojemnosc;
            System.out.println("Brak miejsca w butelce po wlaniu");
        }
        return true;
    }

    boolean wylej(double ilosc) {
        if (IloscLitrow >= ilosc)
            IloscLitrow -= ilosc; // odejmij od siebie ilosc
        else {
            IloscLitrow = 0;
            System.out.println("Za mało wody w butelce po wylaniu");
        }
        return true;
    }

    boolean przelej(double ilosc, Butelki gdziePrzelac) {
        if ((IloscLitrow >= ilosc) && (Pojemnosc >= (IloscLitrow + ilosc))) {
            wylej(ilosc);
            gdziePrzelac.wlej(ilosc);
        } else {
            gdziePrzelac.wlej(IloscLitrow);
            if (IloscLitrow - ilosc < 0)
                IloscLitrow = 0;
            if (IloscLitrow - ilosc > 0)
                IloscLitrow = IloscLitrow - ilosc;
            System.out.println("Za mało wody lub miejsca w butelce po przelaniu");
        }
        return true;
    }
}