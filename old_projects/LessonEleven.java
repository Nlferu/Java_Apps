import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonEleven extends JFrame {
    public LessonEleven() {
        initComps();
    }

    public void initComps() {
        setTitle("Pasek Narzedzi");
        setBounds(300, 300, 300, 200);

        this.pasekNarzedzi
                .add(new ColorButton(new ActionColor("I change color on Red", new ImageIcon("Red.PNG"), Color.RED)));
        this.pasekNarzedzi.add(
                new ColorButton(new ActionColor("I change color on Green", new ImageIcon("Green.PNG"), Color.GREEN)));
        this.pasekNarzedzi.add(new ColorButton(
                new ActionColor("I change color on Yellow", new ImageIcon("Yellow.PNG"), Color.YELLOW)));
        this.pasekNarzedzi.add(wylaczMalowanie);
        this.pasekNarzedzi.add(wyczyscPanel);

        wylaczMalowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                aktywny = null;

                for (int i = 0; i < pasekNarzedzi.getComponentCount(); i++) {
                    if (pasekNarzedzi.getComponent(i) instanceof ColorButton) {
                        ColorButton tmp = (ColorButton) pasekNarzedzi.getComponent(i);
                        tmp.setBackground(Color.WHITE);
                        tmp.setZaznaczone(false);
                    }
                }
            }
        });

        wyczyscPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.WHITE);
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (aktywny != null)
                    panel.setBackground((Color) aktywny.getAction().getValue("color"));
            }
        });

        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(pasekNarzedzi);
        this.getContentPane().add(panel);

        setDefaultCloseOperation(3);
    }

    private JToolBar pasekNarzedzi = new JToolBar("NazwaNowej Ramki");
    private JButton wylaczMalowanie = new JButton("Disable Painting");
    private JButton wyczyscPanel = new JButton("Clear Panel");
    private JPanel panel = new JPanel();
    private ColorButton aktywny = null;

    private class ActionColor extends AbstractAction {
        public ActionColor(String toolTip, Icon icon, Color color) {
            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            aktywny = (ColorButton) e.getSource();
        }
    }

    private class ColorButton extends JButton {
        public ColorButton(ActionColor actionColor) {
            super(actionColor);

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < pasekNarzedzi.getComponentCount(); i++) {
                        if (pasekNarzedzi.getComponent(i) instanceof ColorButton) {

                            ColorButton tmp = (ColorButton) pasekNarzedzi.getComponent(i);
                            tmp.setBackground(Color.WHITE);
                            tmp.setZaznaczone(false);
                            // rootPane.setCursor (new Cursor (Cursor.CROSSHAIR_CURSOR)); // ustawia jakis
                            // kursor wszedzie w aplikacji

                            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                                    new ImageIcon("E:\\Code\\Java\\Java_Apps\\ichimoku\\icons\\poison.png").getImage(),
                                    new java.awt.Point(10, 10), "Our Cursor"));

                        }
                    }

                    ten.setBackground((Color) actionColor.getValue("color"));
                    ten.setZaznaczone(true);
                }
            });
        }

        public void setZaznaczone(boolean zazn) {
            this.zaznaczone = zazn;
        }

        ColorButton ten = this;
        boolean zaznaczone = false;
    }

    public static void main(String[] args) {
        new LessonEleven().setVisible(true);
    }
}
