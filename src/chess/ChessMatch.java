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

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
    };

    private void initialSetup() {
        this.placeNewPiece('b',6,new Rook(board,Color.WHITE));
        this.placeNewPiece('e',8, new King(board,Color.BLACK));
        this.placeNewPiece('e',1, new King(board,Color.WHITE));
    }
}
