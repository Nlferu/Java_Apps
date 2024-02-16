import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

public class LessonSixteen extends JFrame {
    public LessonSixteen() {
        initComps();
    }

    public void initComps() {
        setTitle("Ramki Wewnetrzne");
        setBounds(300, 300, 300, 200);

        JInternalFrame wewnetrznaRamka = new JInternalFrame("Tytul miniRamki", true, true, true, true);
        wewnetrznaRamka.add(new JButton("Testowy"), BorderLayout.SOUTH);
        wewnetrznaRamka.setVisible(true);
        wewnetrznaRamka.pack();
        // wewnetrznaRamka.setIcon (icon);
        wewnetrznaRamka.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

        JInternalFrame wewnetrznaRamka2 = new JInternalFrame("Tytul miniRamki2", true, true, true, true);
        wewnetrznaRamka2.add(new JButton("Testowy22"), BorderLayout.SOUTH);
        wewnetrznaRamka2.setVisible(true);
        wewnetrznaRamka2.pack();

        wewnetrznaRamka.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                System.out.println("Opened");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                String odp = JOptionPane.showInternalInputDialog(e.getInternalFrame(),
                        "Wpisz 'wyjscie' by wyjsc lub 'zamknij' aby zamknac ramke");

                if (odp != null)
                    if (odp.equals("wyjscie"))
                        System.exit(0);
                    else if (odp.equals("zamknij"))
                        e.getInternalFrame().dispose();
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                System.out.println("Closed");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
                System.out.println("Minimalize");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
                System.out.println("Maximalize");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                System.out.println("Activated");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
                System.out.println("Deactivated");
            }
        });

        desktopPane.add(wewnetrznaRamka);
        desktopPane.add(wewnetrznaRamka2);

        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        setDefaultCloseOperation(3);
    }

    private JDesktopPane desktopPane = new JDesktopPane();

    public static void main(String[] args) {
        new LessonSixteen().setVisible(true);
    }
}
