import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonTen extends JFrame {
    public LessonTen() {
        initComps();
    }

    public void initComps() {
        setTitle("Pasek Menu");
        setBounds(300, 300, 300, 200);

        this.setJMenuBar(pasekMenu);
        JMenu menuFile = pasekMenu.add(new JMenu("File"));

        JMenuItem menuPod = menuFile.add(new JMenuItem("New"));

        // JMenu menuFAQ = pasekMenu.add(new JMenu("FAQ"));
        // JMenuItem menuShow = menuFAQ.add(new JMenuItem("Show"));

        menuPod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest jakis kod");
            }
        });

        menuFile.addSeparator();
        Action actionSave = new ActionSave("Save", "Save file on disc?", "ctrl S", new ImageIcon("ikona.png"),
                KeyEvent.VK_Z);
        // JMenuItem podMenuSave = menuFile.add(actionSave);
        // Wczesniej:
        // JMenuItem podMenuSave = menuFile.add("Save");

        buttonZapisz = new JButton(actionSave); // definicja przycisku

        // nie musi byc bo pod jest podMenuSave.setEnabled (false); // na starcie Save
        // jest wylaczony
        actionSave.setEnabled(false); // wylacza tez button Save

        menuFile.add(new JMenuItem("Load"));
        menuFile.addSeparator();
        JMenu menuOptions = new JMenu("Options");
        menuFile.add(menuOptions);
        menuOptions.add("Option 1");
        menuOptions.add(new JMenuItem("Option 2"));
        menuOptions.add(odczyt);
        menuOptions.add(idk);
        menuFile.setMnemonic('F'); // po wcisnieciu alt F klika (rozwija) nam menuFile oraz podkresli litere F

        odczyt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (odczyt.isSelected())
                    actionSave.setEnabled(false);
                else
                    actionSave.setEnabled(flagaObszaruTekstowego);
            }
        });

        strefaTekstowa.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (odczyt.isSelected())
                    e.consume(); // pozryj wcisniety klawisz
            }

            public void keyPressed(KeyEvent e) {
                if (odczyt.isSelected())
                    e.consume(); // nie mozna kopiowac i wycinac
                else if (!(strefaTekstowa.getText() + e.getKeyChar()).equals(przedZmianaObszaruTekstowego)
                        && czyToAscii(e.getKeyChar())) {
                    przedZmianaObszaruTekstowego = strefaTekstowa.getText() + e.getKeyChar(); // sprawdza czy tekst
                                                                                              // zostal zmieniony i
                                                                                              // pozwala na zapis tylko
                                                                                              // raz
                    actionSave.setEnabled(flagaObszaruTekstowego = true); // umozliwia zapis po zmianie tekstu
                }
                System.out.println(strefaTekstowa.getText() + e.getKeyChar()); // wypisuje to co wpiszemy do TextBox'a
                                                                               // po kazdym kliknieciu (jest tutaj jako
                                                                               // podpowiedz)
            }
        });
        /*
         * TO MOZNA DAC TERAZ POD KOMENTARZ BO STWORZYLISMY actionSave, trzeba podmienic
         * tylko podMenuSave w all sluchaczach na actionSave
         * podMenuSave.addActionListener (new ActionListener ()
         * {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e)
         * {
         * System.out.println ("File Saved!");
         * 
         * podMenuSave.setEnabled (flagaObszaruTekstowego = false); // wylacza mozliwosc
         * zapisu po jego wykonaniu az do kolejnego edytowania pliku
         * }
         * });
         * 
         * podMenuSave.setToolTipText ("Save file on disc?"); // podpowiedz po
         * najechaniu na Save
         * podMenuSave.setMnemonic ('S'); // alt + S wykona nam akcje z podMenuSave,
         * czyli wcisnie Save, bo zrobi skrot alt + S oraz podkresli litere S
         * podMenuSave.setAccelerator (KeyStroke.getKeyStroke ("ctrl S")); // od teraz
         * ctrl + s wykona akcje w podMenuSave oraz wyswietli sie podpowiedz obok tego
         * przycisku
         */
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(strefaTekstowa);
        this.getContentPane().add(buttonZapisz);

        setDefaultCloseOperation(3);
    }

    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem odczyt = new JCheckBoxMenuItem("Read Only");
    private JRadioButtonMenuItem idk = new JRadioButtonMenuItem("IDK");
    private JTextArea strefaTekstowa = new JTextArea();
    private boolean flagaObszaruTekstowego = false; // na starcie falsz
    private String przedZmianaObszaruTekstowego = ""; // sprawdza zmiane w obszarze tekstowym

    private boolean czyToAscii(char zn) // czy jest to znak Ascii
    {
        for (int i = 0; i < 255; i++) // jest Ascii(inne klawisze niz cyfry i liczby) dla tego warunku
            if (zn == i)
                return true; // jesli zn == i to prawda

        return false; // bazowo nie jest Ascii, program nie wlaczy zapisu ponownie po kliknieciu
                      // innego klawisza niz cyfra lub litera
    }

    // wyzwanie caly kod dla przycisku Save przeniesc do Buttona Save! !!!!!!! bez
    // kopiowania kodu ofc z miliona miejsc
    private JButton buttonZapisz; // zdefiniowany wyzej jako new bla bla

    // Wszystko co ponizej tworzylismy wyzej recznie (jest wziete pod duzy
    // komentarz)
    private class ActionSave extends AbstractAction // Metoda Action ma duuzo podMetod, check source!
    {
        public ActionSave(String nazwa, String podpowiedz, String skrot, Icon ikona, int mnemonicKey) {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, podpowiedz);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(skrot));
            this.putValue(Action.SMALL_ICON, ikona);
            this.putValue(Action.MNEMONIC_KEY, mnemonicKey); // mnemonic dodaje jednoczesnie skrot i podkresla pierwsza
                                                             // litere przycisku, ktora jest tym skrotem alt + litera
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("File Saved!");

            this.setEnabled(flagaObszaruTekstowego = false); // wylacza mozliwosc zapisu po jego wykonaniu az do
                                                             // kolejnego edytowania pliku
        }
    }

    public static void main(String[] args) {
        new LessonTen().setVisible(true);
    }
}
