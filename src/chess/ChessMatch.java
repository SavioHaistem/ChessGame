package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessMat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                chessMat[row][column] = (ChessPiece) board.piece(row,column);
            };
        }

        return chessMat;
    }

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE),new Position(9,1));
        board.placePiece(new King(board, Color.BLACK),new Position(0,4));
        board.placePiece(new King(board, Color.WHITE),new Position(7,4));
    }
}
