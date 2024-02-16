import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonEight extends JFrame {
    public LessonEight() {
        initComps();
    }

    public void initComps() {
        setTitle("Przeszukiwacz Tekstu");
        setBounds(300, 300, 300, 200);

        panelSzukania.add(search);
        panelSzukania.add(szukanyTekst);
        panelSzukania.add(swap);
        panelSzukania.add(podmienTekst);

        // obszarTekstowy.selectAll (); // zaznacza all tekst
        // obszarTekstowy.select(0, 2); // zaznacza od 0 do 2 elementu
        // obszarTekstowy.replaceSelection ("lala"); // zamienia zaznaczone elementy
        // obszarTekstowy.replaceRange ("lama ", 0, 3); // 2 in 1
        // obszarTekstowy.insert ("mamba", 25); // wklada string na pozycje
        // obszarTekstowy.append ("Dingo"); // dopisuje String na koncu tekstu
        // obszarTekstowy.select(obszarTekstowy.getText ().indexOf ("tekst"),
        // obszarTekstowy.getText ().indexOf ("tekst") + "tekst".length ()); //
        // wyszukiwarka

        search.addActionListener(new znajdowanieHandler());
        swap.addActionListener(new podmianaHandler());

        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);

        setDefaultCloseOperation(3);
    }

    private JTextArea obszarTekstowy = new JTextArea("To jest tekst testowy tej jol", 7, 10); // tworzy sie taki
                                                                                              // notatnik, jak nie
                                                                                              // podamy parametrow to
                                                                                              // cala apka bedzie polem
    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekstowy); // pojawiaja sie suwaki na bokach apki do
                                                                             // przesuwania

    private JPanel panelSzukania = new JPanel();
    private JButton search = new JButton("Search");
    private JButton swap = new JButton("Swap");

    private JTextField szukanyTekst = new JTextField(4); // trzeba ustawic wielkosc
    private JTextField podmienTekst = new JTextField(4);

    private class znajdowanieHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            poczatekSzukania = obszarTekstowy.getText().indexOf(szukanyTekst.getText(),
                    poczatekSzukania + szukanyTekst.getText().length());

            if (poczatekSzukania == -1)
                poczatekSzukania = obszarTekstowy.getText().indexOf(szukanyTekst.getText());

            if (poczatekSzukania >= 0 && szukanyTekst.getText().length() > 0) {
                obszarTekstowy.requestFocus();
                obszarTekstowy.select(poczatekSzukania, poczatekSzukania + szukanyTekst.getText().length());
            }
        }

        private int poczatekSzukania = 0;
    }

    private class podmianaHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()) {
                zamienTekst();
            } else {
                search.doClick(0); // symuluje klikniecie Buttona Search (wtedy mozna po wpisaniu tekstu od razu go
                                   // podmienic)
                if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()) // zapobiega podmianie w
                                                                                            // nieskonczonosc
                    zamienTekst();
            }
        }

        private void zamienTekst() {
            obszarTekstowy.requestFocus();

            int opcja = JOptionPane.showConfirmDialog(rootPane,
                    "Czy chcesz zamienic \" " + szukanyTekst.getText() + " \" na \" " + podmienTekst.getText() + " \" ",
                    "Uwaga nastapi zmiana!", JOptionPane.YES_NO_CANCEL_OPTION);

            if (opcja == 0)

                obszarTekstowy.replaceRange(podmienTekst.getText(), obszarTekstowy.getSelectionStart(),
                        obszarTekstowy.getSelectionEnd());
        }
    }

    public static void main(String[] args) {
        new LessonEight().setVisible(true);
    }
}
