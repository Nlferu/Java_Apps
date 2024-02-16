public class ObjectClass {

    public static void main(String[] args) {

        // Object - superclass for all classes
        // ctrl + N - type the class you are looking for, e.g., Object, and select it
        // from the list = it will open
        // its code next to it
        // alt + shift + enter - importing, e.g., the "Date" class
        // final - you can't override or change the value anymore, it's constant and
        // final

        Point p = new Point(20, 30); // address1
        Point p2 = new Point(20, 30); // address2

        System.out.println(p.getClass()); // getClass - prints the class name

        // p.equals(p2); compares ADDRESSES, not object values, so you need to override
        // this method from the Object class
        if (p.equals(p2))
            System.out.println("They are equal");
        else
            System.out.println("They are not equal");

        Object[] points = new Point[4];

        points[0] = new Point(33, 666);
        points[1] = new Point(343, 777);
        points[2] = new Point(21, 99);
        points[3] = new Point(3, 6);

        for (int i = 0; i < points.length; i++) // iterate through all elements of the array
        {
            System.out.println(points[i]); // and print these elements one by one (toString method overridden from the
                                           // Object superclass)
        }

    }
}

class Point extends Object {
    private int x;
    private int y;

    Point() {

    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override // overridden method from the Object class
    public boolean equals(Object o) {
        if (this == o) // is p equal to p
            return true;

        if (o == null) // is p equal to null
            return false;

        if (this.getClass() != o.getClass()) // is the class different from the class passed
            return false;

        Point sent = (Point) o; // Downcasting = casting to a lower class (casting o from Object to Point)
        return this.x == sent.x && y == sent.y;
    }

    @Override
    public String toString() {
        return getX() + " " + getY();
    }

}
