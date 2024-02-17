package niferu;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class IchimokuApp extends JFrame {

    public IchimokuApp() throws IOException {
        initComps();
    }

    public void initComps() throws IOException {
        this.setBounds(300, 300, 300, 300);

        /** Conditions for JTextFields */

        par1 = new JTextField(2);
        par1.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    Long.parseLong(par1.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Only Numbers Allowed");
                    par1.setText("");
                }
            }
        });
        par2 = new JTextField(2);
        par2.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    Long.parseLong(par2.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Only Numbers Allowed");
                    par2.setText("");
                }
            }
        });
        par3 = new JTextField(2);
        par3.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyReleased(java.awt.event.KeyEvent evt) {
                try {
                    Long.parseLong(par3.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Only Numbers Allowed");
                    par3.setText("");
                }
            }
        });

        /** Design */

        setTitle("Ichimoku");
        setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\Java\\Java_Apps\\ichimoku\\icons\\niferu.jpg"));
        rootPane.setCursor(
                Toolkit.getDefaultToolkit().createCustomCursor(
                        new ImageIcon("E:\\Code\\Java\\Java_Apps\\ichimoku\\icons\\skull.png").getImage(),
                        new Point(10, 10), "Our Cursor"));

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
        }

        /** Frame position in the middle */

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(width / 2, height / 2);

        int frameWidth = getSize().width;
        int frameHeight = getSize().height;

        this.setLocation((width - frameWidth) / 2, (height - frameHeight) / 2);

        /** JThings Layouts */

        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

        northPanel.setPreferredSize(new Dimension(100, 100));
        centerPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 100));

        c.gridy = 1;
        x.weighty = 1;

        northPanel.add(welcome, x);
        northPanel.add(info, c);

        c.gridy = 0;
        c.weightx = 1;

        centerPanel.add(par1, c);
        centerPanel.add(par2, c);
        centerPanel.add(par3, c);

        par1.setToolTipText("First Parameter");
        par2.setToolTipText("Second Parameter");
        par3.setToolTipText("Third Parameter");

        Action perform = new Calculate("Calculate!", "Do you wish to calculate?", "ctrl S",
                new ImageIcon("\"E:\\Code\\Java\\Java_Apps\\ichimoku\\icons\\virus.png"),
                KeyEvent.VK_C);
        button = new JButton(perform);

        /** Protection conditions */

        perform.setEnabled(false);

        par1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (par1.getText().equals("") || par2.getText().equals("") || par3.getText().equals(""))
                    perform.setEnabled(false);
                else
                    perform.setEnabled(true);
            }
        });
        par2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (par1.getText().equals("") || par2.getText().equals("") || par3.getText().equals(""))
                    perform.setEnabled(false);
                else
                    perform.setEnabled(true);
            }
        });
        par3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (par1.getText().equals("") || par2.getText().equals("") || par3.getText().equals(""))
                    perform.setEnabled(false);
                else
                    perform.setEnabled(true);
            }
        });

        /** Colour design */

        button.setPreferredSize(new Dimension(150, 50));
        southPanel.add(button);

        getContentPane().setBackground(Color.BLACK);
        northPanel.setBackground(Color.BLACK);
        centerPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);
        par1.setBackground(Color.GRAY);
        par2.setBackground(Color.GRAY);
        par3.setBackground(Color.GRAY);

        this.setDefaultCloseOperation(3);
    }

    /** JThings */

    private JLabel welcome = new JLabel("Welcome!");
    private JLabel info = new JLabel("Write your preferred parameters for Ichimoku indicator below:");

    private JPanel northPanel = new JPanel(new GridBagLayout());
    private JPanel centerPanel = new JPanel(new GridBagLayout());
    private JPanel southPanel = new JPanel();
    private GridBagConstraints c = new GridBagConstraints();
    private GridBagConstraints x = new GridBagConstraints();

    private JTextField par1;
    private JTextField par2;
    private JTextField par3;

    private JButton button;

    private class Calculate extends AbstractAction {
        File source = new File("E:\\Code\\Java\\Java_Apps\\ichimoku\\data\\IchiData.xlsx");
        FileInputStream file = new FileInputStream(source);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet1 = workbook.getSheetAt(0);
        XSSFSheet sheet2 = workbook.createSheet("IchimokuParameters");

        public Calculate(String name, String tip, String shortCut, Icon icon, int mnemonicKey) throws IOException {
            this.putValue(Action.NAME, name);
            this.putValue(Action.SHORT_DESCRIPTION, tip);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortCut));
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int parameter1 = Integer.parseInt(par1.getText());
            int parameter2 = Integer.parseInt(par2.getText());
            int parameter3 = Integer.parseInt(par3.getText());

            System.out.println(parameter1);
            System.out.println(parameter2);
            System.out.println(parameter3);

            int ten = parameter1 + parameter2 + parameter3;
            System.out.println("TS" + ten);

            double[] closePrice = new double[sheet1.getLastRowNum() + 1];
            {
                for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
                    double data0 = sheet1.getRow(i).getCell(5).getNumericCellValue();

                    closePrice[i] = data0;

                }
                System.out.println("Last Price Cell: " + closePrice.length);
                System.out.println("Prices Data Amount: " + sheet1.getLastRowNum());
            }

            double[] maxPrice = new double[sheet1.getLastRowNum() + 1];
            {
                for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
                    double data1 = sheet1.getRow(i).getCell(3).getNumericCellValue();

                    maxPrice[i] = data1;
                }
            }

            double[] minPrice = new double[sheet1.getLastRowNum() + 1];
            {
                for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
                    double data2 = sheet1.getRow(i).getCell(4).getNumericCellValue();

                    minPrice[i] = data2;
                }
            }

            double[] chikou = new double[closePrice.length - parameter2 + 1];
            {
                for (int i = parameter2 - 1; i <= closePrice.length - 1; i++) {
                    chikou[i - parameter2 + 1] = closePrice[i];
                    // System.out.println("Chikou: " + chikou[i]);
                }
            }

            double[] tenkan = new double[closePrice.length];
            {

                for (int j = parameter1; j < closePrice.length; j++) {

                    double maxValue = maxPrice[j];
                    double minValue = minPrice[j];

                    for (int i = j - parameter1 + 1; i < j; i++) {
                        if (maxPrice[i] > maxValue) {
                            maxValue = maxPrice[i];
                        }
                        if (minPrice[i] < minValue) {
                            minValue = minPrice[i];
                        }
                    }

                    tenkan[j] = (maxValue + minValue) / 2;
                    // System.out.println("Tenkan: " + tenkan[j]);

                    // System.out.println("tsMax: " + maxValue);
                    // System.out.println("tsMin: " + minValue);
                }
            }

            double[] kijun = new double[closePrice.length];
            {

                for (int j = parameter2; j < closePrice.length; j++) {
                    double maxValue = maxPrice[j];
                    double minValue = minPrice[j];

                    for (int i = j - parameter2 + 1; i < j; i++) {
                        if (maxPrice[i] > maxValue) {
                            maxValue = maxPrice[i];
                        }
                        if (minPrice[i] < minValue) {
                            minValue = minPrice[i];
                        }
                    }

                    kijun[j] = (maxValue + minValue) / 2;
                    // System.out.println("Kijun: " + kijun[j]);

                    // System.out.println("ksMax: " + maxValue);
                    // System.out.println("ksMin: " + minValue);
                }
            }

            double[] ssa = new double[closePrice.length + parameter2];
            {
                for (int j = parameter2; j < closePrice.length; j++) {
                    ssa[j + parameter2] = (tenkan[j] + kijun[j]) / 2;
                    // System.out.println("SSA: " + ssa[j]);
                    // System.out.println("ssaTenkan: " + tenkan[j]);
                    // System.out.println("ssaKijun: " + kijun[j]);
                }
            }

            double[] ssb = new double[closePrice.length + parameter2];

            {
                for (int j = parameter3; j < closePrice.length; j++) {
                    double maxValue = maxPrice[j];
                    double minValue = minPrice[j];

                    for (int i = j - parameter3 + 1; i < j; i++) {
                        if (maxPrice[i] > maxValue) {
                            maxValue = maxPrice[i];
                        }
                        if (minPrice[i] < minValue) {
                            minValue = minPrice[i];
                        }
                    }

                    ssb[j + parameter2] = (maxValue + minValue) / 2;
                    // System.out.println("SSB: " + ssb[j]);

                    // System.out.println("ssbMax: " + maxValue);
                    // System.out.println("ssbMin: " + minValue);
                }
            }
            int option = JOptionPane.showConfirmDialog(rootPane, "Would you like to save data?", "Saving",
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == 0) {
                for (int rr = 0; rr < sheet1.getLastRowNum() + parameter2 + 2; rr++) {
                    // Creating new cells in sheet

                    sheet2.createRow(rr);
                    sheet2.getRow(rr).createCell(rr);
                }

                sheet2.getRow(0).createCell(0).setCellValue("Chikou");
                sheet2.getRow(0).createCell(1).setCellValue("Tenkan Sen");
                sheet2.getRow(0).createCell(2).setCellValue("Kijun Sen");
                sheet2.getRow(0).createCell(3).setCellValue("Senkou Span A");
                sheet2.getRow(0).createCell(4).setCellValue("Senkou Span B");

                for (int rowNum = 1; rowNum < sheet1.getLastRowNum() + 1; rowNum++) {
                    sheet2.getRow(rowNum).createCell(0).setCellValue(tenkan[rowNum]);
                    sheet2.getRow(rowNum).createCell(1).setCellValue(kijun[rowNum]);
                }

                for (int rowNum = 1; rowNum < sheet1.getLastRowNum() + parameter2 + 1; rowNum++) {
                    sheet2.getRow(rowNum).createCell(2).setCellValue(ssa[rowNum]);
                    sheet2.getRow(rowNum).createCell(3).setCellValue(ssb[rowNum]);
                }

                for (int rowNum = 1; rowNum < sheet1.getLastRowNum() - parameter2 + 2; rowNum++) {
                    sheet2.getRow(rowNum).createCell(4).setCellValue(chikou[rowNum]);
                }

                FileOutputStream fileSave = null;
                try {
                    fileSave = new FileOutputStream(source);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                try {
                    workbook.write(fileSave);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("File Saved!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new IchimokuApp().setVisible(true);
    }
}
