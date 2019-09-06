package Hw6;

import java.text.NumberFormat;
public class Conversion
{
    private String fromUnit;
    private String toUnit;
    private double ratio;
    private double fromValue;
    private double toValue;
    public Conversion(String fromUnit, String toUnit, double ratio)
    {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.ratio = ratio;
    }
    public String getFromUnit()
    {
        return fromUnit;
    }
    public String getToUnit()
    {
        return toUnit;
    }
    public double getRatio()
    {
        return ratio;
    }
    public void calculateConversion(double fromValue)
    {
        this.fromValue = fromValue;
        this.toValue = fromValue * ratio;
    }
    public String getCalculationString()
    {
        // if you want to add formatting...
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(4);
        String cs = fromValue + " " + fromUnit + " = " +
                number.format(toValue) + " " + toUnit;
        return cs;
    }
    public String toString()
    {
        return fromUnit + " to " + toUnit + ": " + ratio;
    }
}