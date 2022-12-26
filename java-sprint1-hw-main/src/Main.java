import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in); // создание нового экземпляра
        while (true) {
            StepTracker stepTracker = new StepTracker ( scanner );
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.DaySteps ();
            } else if (i == 2) {
                stepTracker.statisticStep ();
            } else if (i == 3) {
                stepTracker.setGoalSteps ();
            } else if (i == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }
    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println ( "1 - Ввести количество шагов за определенный день" );
        System.out.println ( "2 - Напечатать статистику за определенный месяц");
        System.out.println ( "3 - Изменить цель по количеству шагов в день" );
        System.out.println ( "4 - Выйти из приложения" );
    }
}

