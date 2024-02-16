public class Bottles {

    public static void main(String[] args) {
        Butelki[] bottle = new Butelki[6];

        for (int i = 0; i < bottle.length; i++) {
            bottle[i] = new Butelki(1 + i, (i + 1) * 2);

            System.out.println("Bottle " + i + " Liters: " + bottle[i].getLiters());
            System.out.println("Bottle " + i + " Capacity: " + bottle[i].getCapacity());
            System.out.println();
        }

        bottle[2].pour(2);
        System.out.println("After pouring " + "Liters: " + bottle[2].getLiters());
        System.out.println("After pouring " + "Capacity: " + bottle[2].getCapacity());
        System.out.println();

        bottle[3].pourOut(3);
        System.out.println("After pouring out " + "Liters: " + bottle[3].getLiters());
        System.out.println("After pouring out " + "Capacity: " + bottle[3].getCapacity());
        System.out.println();

        bottle[4].pourOver(4, bottle[5]);
        System.out.println("After pouring over " + "Liters: " + bottle[4].getLiters());
        System.out.println("After pouring over " + "Capacity: " + bottle[4].getCapacity());
        System.out.println("After pouring over " + "Liters: " + bottle[5].getLiters());
        System.out.println("After pouring over " + "Capacity: " + bottle[5].getCapacity());

    }
}

class Butelki {

    int liters;
    int capacity;

    Butelki(int liters, int capacity) {
        this.liters = liters;
        this.capacity = capacity;
    }

    int getLiters() {
        return liters;
    }

    int getCapacity() {
        return capacity;
    }

    boolean pour(int ilosc) {

        if (capacity >= (liters + ilosc))
            liters += ilosc;
        else {
            liters = capacity;
            System.out.println("Not enough space in bottle after pouring");
        }
        return true;
    }

    boolean pourOut(int ilosc) {
        if (liters >= ilosc)
            liters -= ilosc;
        else {
            liters = 0;
            System.out.println("Not enough water in bottle after pouring out");
        }
        return true;

    }

    boolean pourOver(int ilosc, Butelki whereToPour) {
        if ((liters >= ilosc) && (capacity >= (liters + ilosc))) {
            pourOut(ilosc);
            whereToPour.pour(ilosc);
        } else {
            whereToPour.pour(liters);
            if (liters - ilosc < 0)
                liters = 0;
            if (liters - ilosc > 0)
                liters = liters - ilosc;
            System.out.println("Not enough water or space in the bottle after pouring");
        }
        return true;
    }
}
