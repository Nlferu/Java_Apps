import javax.swing.*;
import java.awt.*;

public class LessonTwo extends JFrame {

    public LessonTwo() {

        super("Layout Manager");
        this.setBounds(300, 320, 300, 200);

        initComponents();
        // this.pack(); // automatically sets the display of buttons to be visible all

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initComponents() {
        centrum = new JButton("I am in the center");
        top = new JButton("I am on the top");
        // right = new JButton ("I am on the right");
        left = new JButton("I am on the left");
        top2 = new JButton("Button 2");
        bottom = new JButton("I am at the bottom");
        cancel = new JButton("Cancel");

        Container container = this.getContentPane(); // get content pane context = content, pane = quick

        container.add(centrum, BorderLayout.CENTER);
        container.add(top, BorderLayout.PAGE_START);
        container.add(right, BorderLayout.LINE_END);
        container.add(left, BorderLayout.LINE_START);
        // container.add (top2, BorderLayout.PAGE_START);
        container.add(bottom, BorderLayout.PAGE_END);

        panel1.add(top);
        panel1.add(top2);

        this.getContentPane().add(panel1, BorderLayout.PAGE_START); // Coordinates of the button set

        // We set ourselves where the button should be

        // cancel.setLocation (215, 135);
        // cancel.setSize (cancel.getPreferredSize ());
        // container.setLayout (null);
        // container.add (cancel);

    }

    JPanel panel1 = new JPanel(); // Collection of buttons, you can also set here how it should be displayed,
                                  // e.g., JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JButton centrum;
    JButton top;
    JButton right = new JButton("I am on the right");
    JButton left;
    JButton top2;
    JButton bottom;
    JButton cancel;

    public static void main(String[] args) {
        new LessonTwo().setVisible(true);
    }
}
