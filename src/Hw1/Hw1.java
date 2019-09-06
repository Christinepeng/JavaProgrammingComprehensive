package Hw1;

public class Hw1 {
    public static void main(String[] args) {
        AreaPerimeterCalculator areaPerimeterCalculator = new AreaPerimeterCalculator();
        areaPerimeterCalculator.run();

        LetterGradeConverter letterGradeConverter = new LetterGradeConverter();
        letterGradeConverter.run();

        TemperatureConverter temperatureConverter = new TemperatureConverter();
        temperatureConverter.run();

        TravelTimeCalculator travelTimeCalculator = new TravelTimeCalculator();
        travelTimeCalculator.run();

        CoinChangeCalculator coinChangeCalculator = new CoinChangeCalculator();
        coinChangeCalculator.run();
    }
}