import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static int[] field = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        boolean playAgain = true; // Переменная для контроля повторения игры
        int currentPlayer = 1;
        int move = -1;
        while (playAgain) {
            while (checkWinner() == 0) {
                // добавить имя ходящего пользователя
                move = getMoveFromUser();
                field[move] = currentPlayer;
                printField();
                currentPlayer *= -1;
                // добавить проверку на ничью(заполенность полей)

            } if (checkWinner()== 1) {
                System.out.println("Игра закончена Победил X");
            } else if (checkWinner()== -1){
                System.out.println("Игра закончена Победил O");
            }
            System.out.print("Хотите сыграть еще? (да/нет): ");
            Scanner scanner = new Scanner(System.in);
            String replay = scanner.next().toLowerCase();
            if (!replay.equals("да")) {
                playAgain = false;
            }
        }
        // добавить сравнение после хотите сыграть еще?
    }

    private static void printField() {
        for (int i = 0; i < 9; i +=3) {
            System.out.println(printCell(field[i]) + printCell(field[i+1]) + printCell(field[i+2]));
        }

    }

    private static String printCell(int cell) {
        if (cell == 1) {
            return "[X]";
        } else if (cell == -1) {
            return "[O]";
        }
        return "[ ]";
    }

    private static int checkWinner(){
        for (int i = 0; i < 3; i++){
            if (field[i*3]+field[i*3+1]+field[i*3+2]==3 || field[i]+field[i+3]+field[i+6]==3){
                return 1;
            } else if (field[i*3]+field[i*3+1]+field[i*3+2]==-3 || field[i]+field[i+3]+field[i+6]==-3){
                return -1;
            } else if ((field[0] + field[4] + field[8]) == 3 ||
                    (field[2] + field[4] + field[6]) == 3) {
                return 1;
            } else if ((field[0] + field[4] + field[8]) == -3 ||
                    (field[2] + field[4] + field[6]) == -3) {
                return -1;
            }

        }
        return 0;
    }
    public static int getMoveFromUser() {
        Scanner scanner = new Scanner(System.in);
        int move = -1;

        while (move < 0 || move >= 9) {
            System.out.print("Извольте сделать ход (ввести число от 0 до 8): ");

            if (scanner.hasNextInt()) {
                move = scanner.nextInt();
                // добавить проверку что поле не занято

                if (move < 0 || move >= 9)  {
                    System.out.println("Поздравляю, ты достиг комедии. А теперь, ожалуйста, введи число от 0 до 8.");
                }
            } else {
                scanner.next();  // Очистка буфера ввода
            }
        }

        return move;
    }

    // добавить метод для чтения хода игрока. Проверять значение int. Добавить метод перевода кодового обозначение в номер ячейки в массиве и проверка ячейки на пустоту

}


