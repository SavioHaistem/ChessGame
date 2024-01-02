package boardgame;

public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("error ao criar board: e necessario que hajda pelomenos 1 linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer getRows() {
        return rows;
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)) {
            throw new BoardException("Posicao nao existe");
        }
        return pieces[row][column];

    }

    public Piece piece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Posicao nao existe");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("A posiçao ja esta ocupada");
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    };
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(),position.getColumn());
    }
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("A posiçao nao existe");
        }
        return piece(position) != null;
    }
}