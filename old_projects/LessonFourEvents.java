import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LessonFourEvents extends JFrame implements ActionListener {

    public LessonFourEvents() {
        super("Events"); // Mouse click, window close, etc.
        this.setBounds(300, 300, 300, 200);

        initComps();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComps() {
        redButton = new JButton("Red"); // This is the source that can add a listener, and the listener is an object
                                        // that must implement an interface with a specific event
        blackButton = new JButton("Black");
        purpleButton = new JButton("Purple");
        // redButton.addActionListener(new ColorListener(Color.red));
        blackButton.addActionListener(new ColorListener(Color.black)); // Action assigned to the button
        purpleButton.addActionListener(this);

        panel.add(redButton);
        panel.add(blackButton);
        panel.add(purpleButton);

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.red);
            }
        });

        buildButton("Green", Color.green); // Simplified code for red and black buttons

        getContentPane().add(panel); // Add to frame
    }

    JPanel panel = new JPanel();
    JButton redButton; // Color = component, listeners handle specific events
    JButton blackButton;
    JButton purpleButton;

    public void buildButton(String name, Color color) // Method for building buttons
    {
        JButton button = new JButton(name);
        button.addActionListener(new ColorListener(color));

        panel.add(button);
    }

    private class ColorListener implements ActionListener {
        public ColorListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(color);
        }

        Color color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == purpleButton)
            panel.setBackground(Color.magenta);
    }

    public static void main(String[] args) {
        new LessonFourEvents().setVisible(true);
    }
}
