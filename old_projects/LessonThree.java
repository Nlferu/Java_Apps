import javax.swing.*;

// CREATING A BUTTON LAYOUT CAN BE DONE USING THE JFRAME EDITOR BY MOVING ALL FROM THE PANEL BESIDE TO THE CONTENT PANE - LESSON 62!!!

public class LessonThree extends JFrame {

    public LessonThree() {
        this.setBounds(300, 300, 300, 200);

        initComps();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComps() {

        GroupLayout layout = new GroupLayout(getContentPane());

        this.getContentPane().setLayout(layout);

        // Gaps between buttons
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Horizontal - horizontal alignment (both Vertical and Horizontal must be
        // present for the program to work)
        layout.setHorizontalGroup(layout.createSequentialGroup()
                // 3 arguments: 1 - minimum button size, 2 - preferred size, i.e., the one used
                // if it's larger than 1, 3 - maximum size
                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup()
                        .addComponent(button2)
                        .addComponent(button4))
                .addComponent(button3)
                // The button below will be moved to the edge of the frame
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(bCancel));

        // Vertical - vertical alignment
        layout.setVerticalGroup(layout.createSequentialGroup() // Sequential - in order
                .addGroup(layout.createParallelGroup() // Parallel - parallel
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3))
                .addComponent(button4)
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(bCancel));

        pack(); // adjust the window size to the button layout (to content)
    }

    JButton button1 = new JButton("Button1");
    JButton button2 = new JButton("Button2");
    JButton button3 = new JButton("Button3");
    JButton button4 = new JButton("Button4");
    JButton bCancel = new JButton("Cancel");

    public static void main(String[] args) {
        new LessonThree().setVisible(true);
    }
}
