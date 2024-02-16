import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class LessonNine extends JFrame {
    public LessonNine() {
        initComps();
    }

    public void initComps() {
        setTitle("Suwak");
        setBounds(300, 300, 300, 200);

        wartoscSuwaka.setEditable(false);

        suwak.setMajorTickSpacing(10); // Wieksze cyfry na osi
        suwak.setMinorTickSpacing(1); // Mniejsze cyfry na osi
        suwak.setPaintTicks(true); // Uwidacznia kreseczki na osi
        suwak.setPaintLabels(true); // Uwidacznia cyfry na osi
        suwak.setSnapToTicks(true); // Przesuwa suwak do najblizszej kreski (jesli jest gdzies po srodku niczego =
                                    // wartosc po przecinku np)
        tekst.setFont(new Font(tekst.getFont().getFontName(), tekst.getFont().getStyle(), suwak.getValue())); // Ustawia
                                                                                                              // taka
                                                                                                              // wartosc
                                                                                                              // jaka ma
                                                                                                              // suwak
                                                                                                              // na
                                                                                                              // starcie

        suwak.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wartoscSuwaka.setText("" + ((JSlider) e.getSource()).getValue()); // Zczytuje aktualna wartosc z suwaka,
                                                                                  // ktory przesuwamy

                tekst.setFont(new Font(tekst.getFont().getFontName(), tekst.getFont().getStyle(),
                        ((JSlider) e.getSource()).getValue())); // zmienia wielkosc tekstu Label'a
            }
        });

        this.getContentPane().add(suwak, BorderLayout.SOUTH);
        this.getContentPane().add(wartoscSuwaka, BorderLayout.NORTH);
        getContentPane().add(tekst, BorderLayout.CENTER);

        setDefaultCloseOperation(3);
    }

    JSlider suwak = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
    JTextField wartoscSuwaka = new JTextField("" + suwak.getValue());
    JLabel tekst = new JLabel("Something");

    public static void main(String[] args) {
        new LessonNine().setVisible(true);
    }
}
