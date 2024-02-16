import javax.swing.*;

public class NewFrame extends JFrame {
    public NewFrame(JFrame parent) {
        initComps();

        int szer = (int) parent.getBounds().getWidth(); // 300
        int wys = (int) parent.getBounds().getHeight(); // 300

        int szerRam = this.getSize().width; // 200
        int wysRam = this.getSize().height; // 100

        this.setLocation(parent.getBounds().x + (szer - szerRam) / 2, parent.getBounds().y + (wys - wysRam) / 2); // Center
                                                                                                                  // Frame
    }

    static int i = 0;

    public void initComps() {
        setTitle("New Frame Nr. " + (++i)); // counts from 1
        setBounds(300, 300, 400, 100);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
