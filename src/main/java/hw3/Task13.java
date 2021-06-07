package hw3;

import java.util.Arrays;

public class Task13 {
    public static void main(String[] args) {

        String[][] chessDesk = new String[8][8];

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 7; j+=2) {
                    chessDesk[i][j] = " W ";
                    chessDesk[i][j + 1] = " B ";
                }
            } else {
                for (int j = 0; j < 7; j+=2) {
                    chessDesk[i][j] = " B ";
                    chessDesk[i][j + 1] = " W ";
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessDesk[i][j]);
            }
            System.out.println();
        }
    }

}
