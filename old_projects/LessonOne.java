import javax.swing.*;
import java.awt.*;

public class LessonOne extends JFrame {

    public LessonOne() {
        /*
         * 
         * JFrame frame = new JFrame(); // Creating a frame with zero dimensions
         * 
         * frame.setDefaultCloseOperation(3);
         * // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 3 = exit on
         * close
         * 
         * frame.setVisible(true); // Frame should be visible
         * 
         * frame.setTitle("Dinga Frame");
         * 
         * frame.setSize(500, 500);
         * // frame.setSize(new Dimension(10, 10)); or like this
         * 
         * frame.setLocation(500, 100); // x -> to the right, y -> downwards
         * 
         * frame.setBounds(500, 100, 500, 500); // or set boundaries
         * frame.setResizable(false); // false = cannot resize the frame
         * 
         * frame.setIconImage(Toolkit.getDefaultToolkit().getImage("JavIko.jpg")); //
         * setting an icon
         * 
         */

        // Extending the Main class with JFrame -> you can program the frame as below
        // without referring to frame. (supposedly everywhere should be this. but idk
        // wtf with that yet)

        super("Wiska Frame");

        // this.setBounds(500, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack(); // when we have components, it adjusts the data
        setIconImage(Toolkit.getDefaultToolkit().getImage("JavIko.jpg"));

        // centering the frame

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(screenWidth / 2, screenHeight / 2);
        // this.setLocation (screenWidth/4, screenHeight/4);

        int frameWidth = getSize().width;
        int frameHeight = getSize().height;

        this.setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2); // now when resizing the
                                                                                            // frame, it will always be
                                                                                            // centered

        System.out.println(screenWidth);
        System.out.println(screenHeight);

    }

    public static void main(String[] args) {
        new LessonOne().setVisible(true); // method always called
    }
}
