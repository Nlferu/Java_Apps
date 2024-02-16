public class NestedClasses {

    public static void main(String[] args) {

        A a = new A(); // invoking the outer class

        A.B b = a.new B(); // invoking the inner class + you cannot invoke an inner class without the outer
                           // class
        System.out.println("What is that? " + b);

        A.C c = new A.C(); // static nested class can exist without the outer class
        System.out.println("And this? " + c);

    }
}

class A {
    int y = 7; // CAN be read by class B

    A() {
        System.out.println("I'm from outside class A");
    }

    class B {
        int x = 5; // cannot be read by class A

        B() {
            System.out.println("I'm from inside class B");
            System.out.println(y); // Nested class can read something from the higher class, but the higher class
                                   // cannot read from the lower class
        }

    }

    static class C {
        C() {
            System.out.println("I'm from inside class C");
            // System.out.println (y); it's not possible to refer to class A here (because
            // class A doesn't have to exist when C is static)
        }
    }
}
