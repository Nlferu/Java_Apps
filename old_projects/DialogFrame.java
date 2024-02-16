import javax.swing.*;

public class DialogFrame extends JDialog {
    public DialogFrame(JFrame parent) {
        super(parent, true); // You must execute this frame because otherwise you won't return to the program
        initComps();

        int widthParent = (int) parent.getBounds().getWidth(); // 300
        int heightParent = (int) parent.getBounds().getHeight(); // 300

        int widthDialog = this.getSize().width; // 200
        int heightDialog = this.getSize().height; // 100

        this.setLocation(parent.getBounds().x + (widthParent - widthDialog) / 2,
                parent.getBounds().y + (heightParent - heightDialog) / 2); // Centering the frame relative to the parent
                                                                           // frame
    }

    static int i = 0;

    public void initComps() {
        setTitle("New Frame No. " + (++i)); // Counts from 1
        setBounds(300, 300, 200, 100);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
