package Hw3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Circle {

    private double radius;
    public static int objectCount;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getCircumfenrence() {
        double circumfenrence = 2 * Math.PI * radius;
        BigDecimal circumfenrenceDecimal = new BigDecimal(Double.toString(circumfenrence));
        circumfenrenceDecimal = circumfenrenceDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat circumfenrenceFormatter = new DecimalFormat("#,###.00");
        return Double.parseDouble(circumfenrenceFormatter.format(circumfenrenceDecimal));
    }

    public String getFormattedCircumfenrence() {
        throw new UnsupportedOperationException();
    }

    public double getArea() {
        double area = Math.PI * Math.pow(radius, 2);
        BigDecimal areaDecimal = new BigDecimal(Double.toString(area));
        areaDecimal = areaDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat areaFormatter = new DecimalFormat("#,###.00");
        return Double.parseDouble(areaFormatter.format(areaDecimal));
    }

    public String getFormattedArea() {
        throw new UnsupportedOperationException();
    }

    private String formatNumber(double x) {
        throw new UnsupportedOperationException();
    }

    public static int getObjectCount() { return objectCount;
    }

}
