import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LessonFifteen extends JFrame {
    public LessonFifteen() {
        initComps();
    }

    public void initComps() {
        setTitle("Zakladki");
        setBounds(300, 300, 300, 200);

        JPanel panel = new JPanel();
        panel.add(new JButton("Test"));

        zakladka.addTab("Zakladka 1", new JLabel("This is first"));
        zakladka.addTab("Zakladka 2", new ImageIcon("Color.PNG"), panel, "testowy test");
        zakladka.addTab("Kurs", new ImageIcon("skull 32.png"), panelTworzenia);

        panelTworzenia.add(new JLabel("Stworz nowy plik o nazwie:"));
        JTextField nazwaNoweZakladki = new JTextField(7);
        panelTworzenia.add(nazwaNoweZakladki);
        JButton stworzZakladke = new JButton("Stworz");
        panelTworzenia.add(stworzZakladke);

        stworzZakladke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelTekstowy = new JPanel();
                panelTekstowy.setLayout(new GridLayout(1, 1));
                JTextArea obszarTekstowy = new JTextArea();
                panelTekstowy.add(new JScrollPane(obszarTekstowy));

                zakladka.addTab(nazwaNoweZakladki.getText() + ".txt", panelTekstowy);
                zakladka.setSelectedIndex(zakladka.getTabCount() - 1);

                obszarTekstowy.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (!(tytulZakladki + e.getKeyChar()).equals(przedZmianaObszaruTekstowego)
                                && czyToAscii(e.getKeyChar()) && flagaZapisu) {
                            przedZmianaObszaruTekstowego = tytulZakladki + e.getKeyChar();
                            zakladka.setTitleAt(indeksZakladki, tytulZakladki + "*"); // po jakiejkolwiek wprowadzonej
                                                                                      // zmianie w polu txt, pojawia sie
                                                                                      // gwiazdka przy tytule zakladki
                            System.out.println("Cos zaczalem pisac/zmieniac");
                            flagaZapisu = false;
                        }

                        // jesli wcisniemy ctrl+S po zmianie w pliku txt nowej zakladki, wtedy gwiazdka
                        // zniknie
                        else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && !flagaZapisu) {
                            zakladka.setTitleAt(indeksZakladki, tytulZakladki);
                            System.out.println("Saved!");
                            flagaZapisu = true;
                        }
                    }

                    private boolean czyToAscii(char zn) {
                        for (int i = 0; i < 255; i++)
                            if (zn == i)
                                return true;

                        return false;
                    }

                    String przedZmianaObszaruTekstowego = "";
                    int indeksZakladki = zakladka.getSelectedIndex(); // na ktorej zakladce jestesmy
                    String tytulZakladki = zakladka.getTitleAt(indeksZakladki);
                    boolean flagaZapisu = true;

                });
            }
        });

        zakladka.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT); // defaultowo jest wrap (nowe zakladki pojawiaja sie
                                                                    // obok)
        zakladka.setMnemonicAt(0, KeyEvent.VK_T); // skrot do przeniesienia sie do zakladki 1
        this.getContentPane().add(zakladka);
        setDefaultCloseOperation(3);
    }

    private JTabbedPane zakladka = new JTabbedPane();
    private JPanel panelTworzenia = new JPanel();

    public static void main(String[] args) {
        new LessonFifteen().setVisible(true);
    }
}
