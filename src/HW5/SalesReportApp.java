package HW5;

import java.text.DecimalFormat;

public class SalesReportApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Sales Report Application.\n");

        DecimalFormat formatter = new DecimalFormat("#,###.00");
        double[][] sales = {{1540,1130,1580,1105}, {2010,1168,2305,4102}, {2450,1847,2710,2391}, {1845,1491,1284,1576}};
        System.out.println("Region\tQ1\t\t\t\tQ2\t\t\t\tQ3\t\t\t\tQ4");
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "\t\t");
            for (int j = 0; j < 4; j ++) {
                System.out.print("$" + formatter.format(sales[i][j]) + "\t\t");
            }
            System.out.println();
        }

        System.out.println("\nSales by region:");
        double[] totalRegion = new double[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                totalRegion[i] += sales[j][i];
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Region " + (i + 1) + ": $" + formatter.format(totalRegion[i]));
        }

        System.out.println("\nSales by quarter:");
        double[] totalQuarter = new double[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                totalQuarter[i] += sales[i][j];
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Q" + (i + 1) + ": $" + formatter.format(totalQuarter[i]));
        }

        double total = 0;
        for (double r : totalRegion) {
            total += r;
        }
        System.out.println("\nTotal annual sales, all regions: $" + formatter.format(total));
    }
}