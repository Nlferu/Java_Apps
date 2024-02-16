import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LessonSeventeen extends JFrame {
    public LessonSeventeen() {
        initComps();
    }

    public void initComps() {
        setTitle("Panele Dzielone");
        setBounds(300, 300, 300, 200);

        panelListy.add(lista);
        panelObrazka.add(obrazek);
        panelOpisu.add(opis);

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // aby dalo sie zaznaczyc tylko jeden
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Obrazek img = (Obrazek) ((JList) e.getSource()).getSelectedValue();

                    obrazek.setIcon(img.getImage());
                    opis.setText(img.getDescription());
                }
            }
        });

        JSplitPane podzielenie = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListy, panelObrazka);
        JSplitPane podzielenieGlowne = new JSplitPane(JSplitPane.VERTICAL_SPLIT, podzielenie, panelOpisu);

        this.getContentPane().add(podzielenieGlowne);
        setDefaultCloseOperation(3);
    }

    private JPanel panelListy = new JPanel();
    private JPanel panelObrazka = new JPanel();
    private JPanel panelOpisu = new JPanel();
    private JList lista = new JList(
            new Obrazek[] {
                    new Obrazek("Red", "Red Color"),
                    new Obrazek("Green", "Green Color"),
                    new Obrazek("Yellow", "Yellow Color")
            });
    private JLabel obrazek = new JLabel();
    private JLabel opis = new JLabel();

    private class Obrazek {
        public Obrazek(String nazwa, String opis) {
            this.nazwa = nazwa;
            this.opis = opis;

            obrazek = new ImageIcon(nazwa + ".png");
        }

        public String toString() {
            return nazwa;
        }

        public ImageIcon getImage() {
            return obrazek;
        }

        public String getDescription() {
            return opis;
        }

        String nazwa, opis;
        ImageIcon obrazek;
    }

    public static void main(String[] args) {
        new LessonSeventeen().setVisible(true);
    }
}
