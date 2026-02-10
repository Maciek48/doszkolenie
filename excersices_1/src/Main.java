import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int  MAX_MATRIX_SIZE = 3;
    public static final int CHESS_SIZE = 8;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Zadanie 1
//        System.out.println("Podaj dlugosc:");
//        int width = scanner.nextInt();
//
//        System.out.println("Podaj szerokosc:");
//        int length = scanner.nextInt();
//        printSquare(width, length);

        //Zadanie 2
//        System.out.println("Write height: ");
//        int height = scanner.nextInt();
//
//        printTriangle(height);

        //Zadanie 3
//        int[][] tab = createMatrix();
//        printMatrix(tab);

        //Zadanie 4
        printChessBoard();


    }

    public static void printSquare(int x, int y){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(i == 0 || i == x - 1 || j == 0 || j == y - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < height - i ; j++){
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int[][] createMatrix() {
        int[][] tab = new int[MAX_MATRIX_SIZE][MAX_MATRIX_SIZE];
        int counter = 1;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = counter;
                counter++;
            }
        }
        return tab;
    }

    public static void printMatrix(int[][] tab) {
        for (int i = 0; i < tab.length; i++){
            for (int j = 0; j < tab[i].length; j++){
                System.out.print(tab[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void printChessBoard() {
        for (int i = 0; i < CHESS_SIZE; i++) {
            for (int j = 0; j < CHESS_SIZE; j++) {
                if ((i + j) % 2 == 0){
                    System.out.print(" #");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
    }


}