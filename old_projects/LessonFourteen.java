import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

// Spiners - takie strzaleczki w dwie strony (do gory i w dol)

public class LessonFourteen extends JFrame {
    public LessonFourteen() {
        initComps();
    }

    public void initComps() {
        setTitle("Spinners");
        setBounds(300, 300, 300, 200);

        // Spinner 1
        String[] miesiace = new DateFormatSymbols().getMonths(); // Zaciagniecie miesiecy z kompa
        MySpinnerListModel modelMiesiecy = new MySpinnerListModel(obetnijArray(miesiace, -150, 1135)); // SpinnerListModel
                                                                                                       // - rodzaj
                                                                                                       // spinera
                                                                                                       // posiadajaca
                                                                                                       // liste stringow
                                                                                                       // np

        // Spinner 2
        SpinnerNumberModel modelLiczb = new SpinnerNumberModel(1, 1, 5, 1); // wartosc startowa, min, max oraz skok po
                                                                            // kliknieciu spinnera

        // Spinner 3
        SpinnerDateModel modelDat = new SpinnerDateModel();

        // Spinner 4 custom z ograniczeniami
        Calendar kalendarz = Calendar.getInstance();
        Date poczatkowaWartosc = kalendarz.getTime(); // wartosc poczatkowa
        kalendarz.add(Calendar.DAY_OF_MONTH, -14); // przesuwanie o 14 dni w tyl (mamy dzis 14.01)
        Date minimalnaWartosc = kalendarz.getTime();
        kalendarz.add(Calendar.DAY_OF_MONTH, 28); // przesuwanie o 14 dni up (bo -14 + 28)
        Date maksymalnaWartosc = kalendarz.getTime();
        SpinnerDateModel modDate = new SpinnerDateModel(poczatkowaWartosc, minimalnaWartosc, maksymalnaWartosc,
                Calendar.DAY_OF_MONTH);

        JPanel panel = new JPanel();

        JSpinner spinner = new JSpinner(modelMiesiecy);
        JSpinner spinner2 = new JSpinner(modelLiczb);
        JSpinner spinner3 = new JSpinner(modelDat);
        JSpinner spinner4 = new JSpinner(modDate);

        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);
        panel.add(spinner4);

        this.getContentPane().add(panel, BorderLayout.NORTH);

        setDefaultCloseOperation(3);
    }

    private class MySpinnerListModel extends SpinnerListModel // zapetlanie miesiecy aby lecialy od poczatku
    {
        public MySpinnerListModel(Object[] values) {
            super(values);
            firstValue = values[0];
            lastValue = values[values.length - 1];
        }

        public Object getNextValue() // albo zwraca nextValue albo null jak jej brak, dlatego trzeba zmienic aby
                                     // zwracala nastepny miesiac
        {
            if (super.getNextValue() == null)
                return firstValue;
            else
                return super.getNextValue();
        }

        public Object getPreviousValue() // albo zwraca previousValue albo null jak jej brak, dlatego trzeba zmienic aby
                                         // zwracala poprzedni miesiac
        {
            if (super.getPreviousValue() == null)
                return lastValue;
            else
                return super.getPreviousValue();
        }

        Object firstValue, lastValue;
    }

    // Usuwanie pustego pola z miesiecy (miedzy styczniem a grudniem)
    private Object[] obetnijArray(Object[] operowany, int poczatek, int koniec) {
        // ? = jesli poprzedni warunek nie jeste spelniony zwroc 0 : dla wartosci
        // poczatek/koniec
        koniec = koniec > operowany.length - 1 || koniec < 0 ? operowany.length - 2 : koniec; // ograniczenie co do
                                                                                              // wielkosci liczby
                                                                                              // wprowadzonej na samej
                                                                                              // gorze w spinner 1
        poczatek = poczatek < 0 || poczatek > koniec ? 0 : poczatek;

        Object[] tmp = new Object[koniec + 1 - poczatek]; // puste pole w miesiacach

        for (int i = poczatek, j = 0; i < koniec + 1; i++, j++)
            tmp[j] = operowany[i];

        return tmp;
    }

    public static void main(String[] args) {
        new LessonFourteen().setVisible(true);
    }
}
