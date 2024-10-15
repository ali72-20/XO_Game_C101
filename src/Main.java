import java.util.Scanner;

public class Main {
    static char[][] matrix = new char[3][3];

    public static void printError() {
        System.out.println("Error: in valid cell!");
    }

    public static void printCor(String cor) {
        System.out.println("Please Enter " + cor + " number: ");
    }

    public static void displayTurn(char turn) {
        System.out.println("Player " + turn);
    }

    public static void displayWinnerMessage(char turn) {
        System.out.println("The winner is: " + turn);
    }

    public static void displayDrawMessage() {
        System.out.println("OOPs: Draw Round");
    }

    public static void clearMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; ++j) {
                matrix[i][j] = '-';
            }
        }
    }

    public static void displayMatrix() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isWinner(char turn) {
        boolean winner = false;
        if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && matrix[0][0] != '-') {
            winner = true;
        } else if (matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2] && matrix[1][0] != '-') {
            winner = true;
        } else if (matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2] && matrix[2][0] != '-') {
            winner = true;
        } else if (matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0] && matrix[0][0] != '-') {
            winner = true;
        } else if (matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1] && matrix[0][1] != '-') {
            winner = true;
        } else if (matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2] && matrix[0][2] != '-') {
            winner = true;
        } else if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != '-') {
            winner = true;
        } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != '-') {
            winner = true;
        }
        if (winner) {
            displayWinnerMessage(turn);
        }
        return winner;
    }

    public static boolean isDraw(int cells, char turn) {
        if (cells == 9 && !isWinner(turn)) {
            return true;
        }
        return false;
    }

    public static boolean isInMatrix(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) return true;
        return false;
    }

    public static boolean isValidToSet(int row, int col) {
        if (matrix[row][col] == '-') {
            return true;
        }
        return false;
    }

    public static boolean setInMatrix(char turn) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        printCor("Row");
        row = scanner.nextInt();
        printCor("Column");
        col = scanner.nextInt();
        row--;
        col--;
        if (isInMatrix(row, col) && isValidToSet(row, col)) {
            matrix[row][col] = turn;
            return true;
        }
        printError();
        return false;
    }

    public static char changeTurn(char turn) {
        if (turn == 'X')
            return 'O';
        return 'X';
    }


    public static boolean isFinished(char turn, int cells) {
        if (isWinner(turn)) {
            displayMatrix();
            return true;
        } else if (isDraw(cells, turn)) {
            displayDrawMessage();
            displayMatrix();
            return true;
        }
        return false;
    }

    public static void play() {
        clearMatrix();
        int cells = 0;
        char turn = 'X';
        while (true) {
            displayMatrix();
            displayTurn(turn);
            if (setInMatrix(turn)) {
                cells++;
                if(isFinished(turn,cells))
                    break;
                turn = changeTurn(turn);
            }
        }
    }

    public static void main(String[] args) {
        play();
    }
}