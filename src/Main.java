import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Произволната правоъгълна таблица е: ");

        int[][] table = randNumOfColRow();
        printTable(table);
        Scanner scanner = new Scanner(System.in);
        int userRow = readValidRow(scanner, table.length);
        int userCol = readValidCol(scanner, table[0].length);
        int startRow = userRow - 1;
        int startCol = userCol - 1;

        fillDownLeft(table, startRow, startCol);

        System.out.println("Резултатната таблица е:");
        printTable(table);

        scanner.close();


    }

    public static int[][] randNumOfColRow() {
        int rowMax = (int) ((Math.random() * 9) + 2);
        int colMax = (int) ((Math.random() * 9) + 2);
        int[][] table = new int[rowMax][colMax];

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {

                table[row][col] = 1;

            }


        }
        return table;


    }

    public static void printTable(int[][] table) {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                System.out.printf("%3d", table[row][col]);
            }
            System.out.println();
        }
    }

    public static int readValidRow(Scanner scanner, int rowMax) {
        int userRow = 0;

        while (true) {
            System.out.print("Въведете номер на ред (от 1 до " + rowMax + "): ");

            try {
                userRow = scanner.nextInt();

                if (userRow < 1 || userRow > rowMax) {
                    System.out.println("Грешка: въведете число от 1 до " + rowMax + ".");
                    continue;
                }
                return userRow;

            } catch (InputMismatchException e) {
                System.out.println("Грешка: моля въведете цяло число.");
                scanner.next();
            }
        }
    }

    public static int readValidCol(Scanner scanner, int colMax) {
        int userCol = 0;

        while (true) {
            System.out.print("Въведете номер на колона (от 1 до " + colMax + "): ");

            try {
                userCol = scanner.nextInt();

                if (userCol < 1 || userCol > colMax) {
                    System.out.println("Грешка: моля въведете число от 1 до " + colMax + ".");
                    continue;
                }

                return userCol;

            } catch (InputMismatchException e) {
                System.out.println("Грешка: моля въведете цяло число.");
                scanner.next();
            }
        }
    }

    public static void fillDownLeft(int[][] table, int startRow, int startCol) {
        int value = 2;
        int row = startRow;
        int col = startCol;

        while (row < table.length && col >= 0) {
            table[row][col] = value;
            value++;
            row++;
            col--;
        }
    }
}
