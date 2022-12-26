import java.util.Scanner;

public class StepTracker {

    private static int[][] monthToData = new int [12][30];
    private int month;
    public int day;
    public int step;
    private int average;
    private int goalSteps = 10000;
    private int sumSteps;
    private Scanner scanner;
    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
    }

    public void DaySteps() {
    System.out.println ( "Введите порядковый номер месяца от 0 до 11" );
    month = scanner.nextInt ( );
    System.out.println ( "Введите порядковый номер дня от 1 до 30" );
    day = scanner.nextInt ( );
    System.out.println ( "Введите пройденное количество шагов" );
    step = scanner.nextInt ( );
    if ((month < 11 && month >= 0) && (day < 30 && day >= 0) && (step > 0)) {
        monthToData[month][day] = step;
    } else {
    System.out.println ( "Введены некорректные данные" );
    }
}
    public void statisticStep() {
        System.out.println ( "Введите месяц за который хотите увидеть статистику" );
        month = scanner.nextInt ( );
        statisticStepsByDayMonth ( );
        totalNumberStepsInMonth ();
        maxNumberOfStepsInMonth ();
        averageNumberSteps ();
        System.out.println ( "Пройденная дистанция " + Converter.convertToKm ( sumSteps ) + " в км.");
        System.out.println ( "Количество сожженных килокалорий " +
                Converter.convertStepsToKilocalories ( sumSteps ) + " Ккал.");
        bestSeries ();
    }
    public void setGoalSteps () {
        System.out.println ( "Введите цель по количеству шагов за день" );
        int goalsSteps = scanner.nextInt ();
        if (goalsSteps >= 0) {
            goalSteps = goalsSteps;
            System.out.println ( "Новая цель по шагам = " + goalSteps );
        } else {
        System.out.println ( "Введены неверные данные" );
        }
    }
    private void statisticStepsByDayMonth () {
        System.out.println ( "Количество пройденных шагов по дням за " + month + " месяц: ");
        for (int i = 0; i < monthToData [month].length; i++) {
            if (monthToData[month][i] != 0) {
                System.out.println (i + " день " + monthToData[month][i] + ", " );
            }
        }
        System.out.println(" ");
    }

    private void maxNumberOfStepsInMonth () {
        int maxSteps = monthToData[month][0];
        for (int i = 0; i < monthToData[month].length; i++) {
            if (monthToData[month][i] > maxSteps) {
                maxSteps = monthToData[month][i];
            }
        }
    System.out.println("Максимальное пройденное количеcтво шагов в указанном месяце " + maxSteps + ".");
    }

    private void totalNumberStepsInMonth () {
        for (int i = 0; i < monthToData[month].length; i++) {
            sumSteps += monthToData[month][i];
            if (monthToData[month][i] != 0) {
                average++;
            }
        }
        System.out.println ( "Общее количество шагов за месяц " + sumSteps + "." );
    }
    private void averageNumberSteps() {
    if ( sumSteps != 0 && average != 0 ) {
        System.out.println ( "Среднее количество шагов " + ( sumSteps / average ) + "." );
    } else {
        System.out.println ( "Среднее количество шагов - 0." );
    }
    }

    private void bestSeries() {
    int maxLength = 0;
    int tempLength = 0;
    for (int i = 0; i <= monthToData[month].length - 1; i++) {
        if (monthToData[month][i] >= goalSteps) {
            tempLength++;
        } else {
            tempLength = 0;
        }
        if (tempLength > maxLength) {
            maxLength = tempLength;
        }
    }
    System.out.println ( "Лучшая серия: максимальное количество подряд идущих дней, " +
            "в течение которых кол-во шагов было равно или выше заданного значения: " + maxLength);
    }
}



