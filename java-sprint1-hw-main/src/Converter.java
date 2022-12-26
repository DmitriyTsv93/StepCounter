public class Converter {
    private static double step = 0.00075;
    private static int calorieInStep = 50;

    public static int convertToKm(int sumSteps) {
        return (int) (step * sumSteps);
    }
    public static int convertStepsToKilocalories(int sumSteps) {
        return sumSteps / calorieInStep;
    }
}
