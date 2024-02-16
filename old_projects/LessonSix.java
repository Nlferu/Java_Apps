import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonSix extends JFrame {

    public LessonSix() {
        initComps();
        pack();
    }

    public void initComps() {
        setTitle("Radio Button Groups");
        setBounds(400, 300, 300, 200);
        panel2.add(label);
        panel4.add(bold);
        panel4.add(italic);
        panel3.add(createFrame);
        panel3.add(moveNext);

        ActionListener listener = new CheckBoxHandler();
        bold.addActionListener(listener);
        italic.addActionListener(listener);

        buildSizeRadioButton("Small", 15);
        buildSizeRadioButton("Medium", 25);
        buildSizeRadioButton("Large", 55);

        buildColorRadioButton("Green", Color.GREEN);
        buildColorRadioButton("Black", Color.BLACK);
        buildColorRadioButton("Blue", Color.BLUE);

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(panel3, BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.SOUTH);
        getContentPane().add(panel4, BorderLayout.EAST);

        createFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewFrame(thisFrame).setVisible(true);
            }
        });

        moveNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogFrame(thisFrame).setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buildSizeRadioButton(String name, final int size) {
        JRadioButton radioButton = new JRadioButton(name);

        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("MONOSPACED", Font.PLAIN, size));
            }
        });

        sizeGroup.add(radioButton);
        panel.add(radioButton);
    }

    public void buildColorRadioButton(String name, final Color color) {
        JRadioButton radioButton = new JRadioButton(name);

        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(color);
            }
        });

        colorGroup.add(radioButton);
        panel3.add(radioButton);
    }

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JLabel label = new JLabel("Something");
    private JButton createFrame = new JButton("Create Frame");
    private JFrame thisFrame = this;
    private JButton moveNext = new JButton("Move Next");

    JCheckBox bold = new JCheckBox("Bold");
    JCheckBox italic = new JCheckBox("Italic");

    ButtonGroup sizeGroup = new ButtonGroup();
    ButtonGroup colorGroup = new ButtonGroup();

    public class CheckBoxHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int basicStyle = Font.PLAIN;

            if (bold.isSelected())
                basicStyle += Font.BOLD;
            if (italic.isSelected())
                basicStyle += Font.ITALIC;

            label.setFont(new Font(label.getFont().getFamily(), basicStyle, label.getFont().getSize()));
        }
    }

    public static void main(String[] args) {
        new LessonSix().setVisible(true);
    }
}
