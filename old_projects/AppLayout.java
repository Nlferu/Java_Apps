import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppLayout {

    private JPanel MainPanel;
    private JButton startButton;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton bigRadioButton;
    private JRadioButton blackRadioButton;
    private JRadioButton redRadioButton;
    private JRadioButton freenRadioButton;
    private JLabel INFO;

    public AppLayout() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Program Started!");
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INFO.setFont(new Font("Small", Font.BOLD, 15));
                INFO.setFont(new Font("Medium", Font.BOLD, 35));
                INFO.setFont(new Font("Big", Font.BOLD, 55));
            }
        };

        smallRadioButton.addActionListener(listener);
        mediumRadioButton.addActionListener(listener);
        bigRadioButton.addActionListener(listener);
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INFO.setForeground(Color.GREEN);
                INFO.setForeground(Color.RED);
                INFO.setForeground(Color.BLACK);
            }
        };
        freenRadioButton.addActionListener(listener1);
        blackRadioButton.addActionListener(listener1);
        redRadioButton.addActionListener(listener1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new AppLayout().MainPanel);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
    }

}
