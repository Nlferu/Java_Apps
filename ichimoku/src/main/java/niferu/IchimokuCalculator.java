package niferu;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IchimokuCalculator {
    public static void main(String[] args) throws Exception {
        new Ichimoku();

        // Ichimoku ichi = new Ichimoku();

        // System.out.println(Parametr.getChikou());
        // System.out.println(Parametr.getTenkan ());
        // System.out.println(Parametr.getKijun());
        // System.out.println(Parametr.getSSA());
        // System.out.println(ichi.getSSB());
        System.out.println("Program finished!");
    }
}

class Ichimoku {

    Scanner scan = new Scanner(System.in);

    int par1, par2, par3;

    {
        System.out.println("Welcome to the program for calculating the parameters of the Ichimoku indicator");
        System.out.println("Enter the first parameter of Ichimoku: ");

        while (!scan.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scan.next(); // Discard the invalid input
        }

        par1 = scan.nextInt();

        System.out.println("Enter the second parameter of Ichimoku: ");

        while (!scan.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scan.next(); // Discard the invalid input
        }

        par2 = scan.nextInt();

        System.out.println("Enter the third parameter of Ichimoku: ");

        while (!scan.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scan.next(); // Discard the invalid input
        }

        par3 = scan.nextInt();

        System.out.println("Oto Twoj wynik!!!");
    }

    File source = new File("E:\\Code\\Java\\Java_Apps\\ichimoku\\data\\IchiData.xlsx");
    FileInputStream file = new FileInputStream(source);
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet1 = workbook.getSheetAt(0);
    XSSFSheet sheet2 = workbook.createSheet("IchimokuParameters");

    Ichimoku() throws IOException {
    }

    double[] closePrice = new double[sheet1.getLastRowNum() + 1];
    {
        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            double data0 = sheet1.getRow(i).getCell(5).getNumericCellValue();

            closePrice[i] = data0;

            // System.out.println(closePrice[i]); // Prints all prices
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

    double[] chikou = new double[closePrice.length - par2 + 1];
    {
        for (int i = par2 - 1; i <= closePrice.length - 1; i++) {
            chikou[i - par2 + 1] = closePrice[i];
            // System.out.println("Chikou: " + chikou[i]);
        }
    }

    double[] tenkan = new double[closePrice.length];
    {

        for (int j = par1; j < closePrice.length; j++) {

            double maxValue = maxPrice[j];
            double minValue = minPrice[j];

            for (int i = j - par1 + 1; i < j; i++) {
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

        for (int j = par2; j < closePrice.length; j++) {
            double maxValue = maxPrice[j];
            double minValue = minPrice[j];

            for (int i = j - par2 + 1; i < j; i++) {
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

    double[] ssa = new double[closePrice.length + par2];
    {
        for (int j = par2; j < closePrice.length; j++) {

            ssa[j + par2] = (tenkan[j] + kijun[j]) / 2;
            // System.out.println("SSA: " + ssa[j]);
            // System.out.println("ssaTenkan: " + tenkan[j]);
            // System.out.println("ssaKijun: " + kijun[j]);
        }
    }

    double[] ssb = new double[closePrice.length + par2];

    {
        for (int j = par3; j < closePrice.length; j++) {
            double maxValue = maxPrice[j];
            double minValue = minPrice[j];

            for (int i = j - par3 + 1; i < j; i++) {
                if (maxPrice[i] > maxValue) {
                    maxValue = maxPrice[i];
                }
                if (minPrice[i] < minValue) {
                    minValue = minPrice[i];
                }
            }

            ssb[j + par2] = (maxValue + minValue) / 2;
            // System.out.println("SSB: " + ssb[j]);

            // System.out.println("ssbMax: " + maxValue);
            // System.out.println("ssbMin: " + minValue);
        }
    }

    double getChikou() {
        return chikou[closePrice.length - 1];
    }

    double getTenkan() {
        return tenkan[closePrice.length - 1];
    }

    double getKijun() {
        return kijun[closePrice.length - 1];
    }

    double getSSA() {
        return ssa[closePrice.length - 1];
    }

    double getSSB() {
        return ssb[closePrice.length - 1];
    }

    String userinput;

    {
        System.out.println("Do you want to save results in excel? ");
        System.out.println("Y/N");

        userinput = scan.next();
        scan.close();

        if (userinput.equalsIgnoreCase("Y")) {
            for (int rr = 0; rr < sheet1.getLastRowNum() + par2 + 2; rr++) {
                // Definiowanie / Tworzenie komorek w nowym sheecie

                sheet2.createRow(rr);
                sheet2.getRow(rr).createCell(rr);
            }

            sheet2.getRow(0).createCell(0).setCellValue("Tenkan");
            sheet2.getRow(0).createCell(1).setCellValue("Kijun");
            sheet2.getRow(0).createCell(2).setCellValue("SSA");
            sheet2.getRow(0).createCell(3).setCellValue("SSB");
            sheet2.getRow(0).createCell(4).setCellValue("Chikou");

            for (int rowNum = 1; rowNum < sheet1.getLastRowNum() + 1; rowNum++) {
                sheet2.getRow(rowNum).createCell(0).setCellValue(tenkan[rowNum]);
                sheet2.getRow(rowNum).createCell(1).setCellValue(kijun[rowNum]);
            }

            for (int rowNum = 1; rowNum < sheet1.getLastRowNum() + par2 + 1; rowNum++) {
                sheet2.getRow(rowNum).createCell(2).setCellValue(ssa[rowNum]);
                sheet2.getRow(rowNum).createCell(3).setCellValue(ssb[rowNum]);
            }

            for (int rowNum = 1; rowNum < sheet1.getLastRowNum() - par2 + 2; rowNum++) {
                sheet2.getRow(rowNum).createCell(4).setCellValue(chikou[rowNum]);
            }

            FileOutputStream fileSave = new FileOutputStream(source);
            workbook.write(fileSave);
            fileSave.close();

            System.out.println("File modified and saved!");
        }

        if (userinput.equalsIgnoreCase("N") && !userinput.equalsIgnoreCase("Y")) {
            System.out.println("Modified file not saved!");
        }

    }
}
