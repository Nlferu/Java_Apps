import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LessonLwelve extends JFrame {
    public LessonLwelve() {
        initComps();
    }

    public void initComps() {
        setTitle("Pasek Narzedzi");
        setBounds(300, 300, 300, 200);

        JPopupMenu menuKontekstowe = new JPopupMenu();

        menuKontekstowe.add(new JMenuItem(new AbstractAction("Close") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Copy"));
        menuKontekstowe.add(new JMenuItem("Paste"));

        testowy.addMouseListener(new MouseAdapter() // "testowy" zamiast getContentPane() powoduje, ze menu wyswietli
                                                    // sie po kliknieciu tylko na JButton Test
        {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Released");

                if (e.getClickCount() == 3 && e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown()) // okno pokaze sie
                                                                                                      // po kliknieciu 3
                                                                                                      // razy lewego
                                                                                                      // myszy i
                                                                                                      // trzymaniu
                                                                                                      // shifta
                    JOptionPane.showMessageDialog(rootPane, "Naklikane tej!");
                // if (e.getButton () == MouseEvent.BUTTON3) // button3 = prawy myszy
                if (e.isPopupTrigger()) // mozna to zapisac tez tak
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        this.getContentPane().add(testowy, BorderLayout.SOUTH);
        this.getContentPane().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) // klikniecie
            {

            }

            @Override
            public void mousePressed(MouseEvent e) // przytrzymanie klikniecia
            {

            }

            @Override
            public void mouseReleased(MouseEvent e) // puszczenie po kliknieciu bez wywolania go
            {

            }

            @Override
            public void mouseEntered(MouseEvent e) // kiedy kursorznajdzie sie w polu np. aplikacji
            {

            }

            @Override
            public void mouseExited(MouseEvent e) // kiedy kursor opusci pole np. aplikacji
            {

            }
        });

        setDefaultCloseOperation(3);
    }

    JButton testowy = new JButton("Test");

    public static void main(String[] args) {
        new LessonLwelve().setVisible(true);
    }
}