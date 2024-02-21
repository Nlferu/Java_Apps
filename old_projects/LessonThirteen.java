import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class LessonThirteen extends JFrame {
    public LessonThirteen() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Lists");
        setBounds(300, 300, 300, 200);

        listaPrzedmiotow.setVisibleRowCount(4); // By default, it's set to 8 elements (a set), setting it to 3 will
                                                // display only 3 visible elements.
        listaPrzedmiotow.setBackground(Color.WHITE);
        listaPrzedmiotow.setSelectionBackground(Color.BLACK);
        listaPrzedmiotow.setSelectionForeground(Color.GREEN); // Font color
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Selection mode options

        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("I have changed " + (++i)); // Outputs a message when the selection changes

                if (e.getValueIsAdjusting()) // If the value is changing
                    System.out.println("Holding mouse button");
                else
                    System.out.println("Releasing mouse button");

                if (!e.getValueIsAdjusting()) {
                    Object[] selectedValues = ((JList<?>) e.getSource()).getSelectedValuesList().toArray(); // Gets
                                                                                                            // selected
                                                                                                            // values
                                                                                                            // from
                    // the list
                    String items = "";

                    for (int i = 0; i < selectedValues.length; i++)
                        items += selectedValues[i] + " ";

                    System.out.println(items); // Outputs selected items

                    komunikat.setText("I don't like " + items); // Updates the label text
                }
            }
        });

        DefaultListModel<String> listModel = new DefaultListModel<>();

        String[] subjects = { "Mat", "Fiz", "Inf", "Bio", "Chem", "PO", "Nuke", "Dingo", "Maupa", "Lambo" };

        for (String subject : subjects)
            listModel.addElement(subject);

        JList<String> lista2 = new JList<>(listModel);

        lista2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // modelListy.removeAllElements (); // Removes all elements from the list when
                // clicked
                for (int i = 0; i < subjects.length; i++) // Automatically adds the above elements to the list
                    listModel.addElement(subjects[i]);
            }
        });

        panelListy.add(scrollListy);
        panelKomunikatu.add(komunikat);

        this.getContentPane().add(panelListy, BorderLayout.NORTH);
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
        this.getContentPane().add(lista2, BorderLayout.SOUTH);

        setDefaultCloseOperation(3);
    }

    private int i = 0;
    private JList<String> listaPrzedmiotow = new JList<>(
            new String[] { "Mat", "Fiz", "Inf", "Bio", "Chem", "PO", "Nuke", "Dingo", "Maupa", "Lambo" });
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel("Error 404!");

    public static void main(String[] args) {
        new LessonThirteen().setVisible(true);
    }
}
