import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonSeven extends JFrame {

    public LessonSeven() {
        initComps();
    }

    public void initComps() {
        setTitle("Wlasne Menu");
        setBounds(300, 300, 300, 200);

        panelMenu.setLayout(new GridLayout(3, 1)); // 1 - ile wierszy, 2 - ile kolumn

        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);

        kontener.add(panelMenu);
        setDefaultCloseOperation(3);
    }

    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    private MenuButton menu1 = new MenuButton("1. Dodaj");
    private MenuButton menu2 = new MenuButton("2. Usun");
    private MenuButton menu3 = new MenuButton("3. Zmien");
    private int i = 0;

    private class MenuButton extends JButton implements FocusListener, ActionListener {
        public MenuButton(String nazwa) {
            super(nazwa); // wywoluje konstruktor wyzej polozony

            this.addFocusListener(this);
            this.addActionListener(this);
            this.addKeyListener(new KeyListener() {
                // kiedy wcisniemy "a" to: wywoluje sie najpierw KeyPressed, KeyTyped,
                // KeyReleased
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    keyPressedHandler(e);
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            this.setBackground(kDefault);
        }

        @Override
        public void focusGained(FocusEvent e) {
            this.setBackground(kFocusGained); // set focus czyli ustac cos tam
        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBackground(kDefault); // powrot do akcji, czyli lose focus
        }

        private void keyPressedHandler(KeyEvent e) {
            int dlMenu = panelMenu.getComponentCount();
            // 0 % 3 = 0, 1 % 3 = 1, 2 % 3 = 2, 3 % 3 = 0, 4 % 3 = 1 reszta z dzielenia

            if (i == 0)
                i = 10 * dlMenu; // jesli wartosc i spadnie do 0 wtedy i = 30 (zeby po wciskaniu UP nie wywalalo
                                 // erroru na ijemnej wartosci)
            if (i == 100)
                i = 10 * dlMenu; // bariera z gory zeby nie dobic do wartosci granicznej "i"
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                // System.out.println (++i); // licznik i
                panelMenu.getComponent(++i % dlMenu).requestFocus();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                --i; // licznik i
                panelMenu.getComponent(i % dlMenu).requestFocus();
            }

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // MenuButton tmp = (MenuButton)e.getSource ();
                // tmp.doClick ();

                ((MenuButton) e.getSource()).doClick();

            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action Performed!");
            JOptionPane.showMessageDialog(this, ((MenuButton) e.getSource()).getText());
        }

        private Color kFocusGained = Color.BLACK;
        private Color kDefault = Color.GREEN;
    }

    public static void main(String[] args) {
        new LessonSeven().setVisible(true);
    }
}
