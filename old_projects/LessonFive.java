import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LessonFive extends JFrame {

    public LessonFive() {
        super("Clock");
        setBounds(300, 300, 300, 300);

        initComps();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComps() {
        panel.add(label);
        panel.add(time);

        ActionListener timerListener = new Clock();

        Timer timer = new Timer(1000, timerListener); // Refresh rate in milliseconds, second parameter is the listener
        timer.start();

        getContentPane().add(panel);
        pack(); // Adjusts the panel's content to the frame's size by resizing it appropriately
    }

    // JLabel = label is the component name
    JLabel label = new JLabel("Time: ");
    JPanel panel = new JPanel();
    JLabel time = new JLabel();

    private class Clock implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            time.setText(getTime());
        }
    }

    public String getTime() {
        GregorianCalendar calendar = new GregorianCalendar();

        String hour = "" + calendar.get(Calendar.HOUR_OF_DAY); // Hour, adding ""+ before the expression converts it
                                                               // into a String
        String minute = "" + calendar.get(Calendar.MINUTE); // Minute
        String second = "" + calendar.get(Calendar.SECOND); // Second

        if (Integer.parseInt(hour) < 10) // Convert String to int
            hour = "0" + hour; // Executes what's on the right side first

        if (Integer.parseInt(minute) < 10)
            minute = "0" + minute;

        if (Integer.parseInt(second) < 10)
            second = "0" + second;

        return hour + ":" + minute + ":" + second;
    }

    public static void main(String[] args) {
        new LessonFive().setVisible(true);
    }
}
