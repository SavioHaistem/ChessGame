package application;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;

public class UI {

    public static void printBoard(ChessPiece[][] pieces) {
        for (int row = 0; row < pieces.length; row++) {
            System.out.print((row + 1) + " ");
                for (int column = 0; column < pieces[row].length; column++) {
                    printPiece(pieces[row][column]);
                }
            System.out.print("\n");
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        } else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
