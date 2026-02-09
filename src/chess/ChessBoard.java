package src.chess;


import src.Pawn;
import src.Rook;
import src.Knight;
import src.Bishop;
import src.Queen;
import src.King;

public class ChessBoard {
    private Piece[][] board;
    
    public ChessBoard() {
        board = new Piece[8][8];
        initializeBoard();
    }
    
    private void initializeBoard() {
        // BIJELI (DOLJE - redovi 6 i 7)
        // Pješaci - red 6
        for (int col = 0; col < 8; col++) {
            board[6][col] = new Pawn(PieceColor.WHITE, new Position(6, col));
        }
        
        // Topovi
        board[7][0] = new Rook(PieceColor.WHITE, new Position(7, 0));
        board[7][7] = new Rook(PieceColor.WHITE, new Position(7, 7));
        
        // Konji
        board[7][1] = new Knight(PieceColor.WHITE, new Position(7, 1));
        board[7][6] = new Knight(PieceColor.WHITE, new Position(7, 6));
        
        // Lovci
        board[7][2] = new Bishop(PieceColor.WHITE, new Position(7, 2));
        board[7][5] = new Bishop(PieceColor.WHITE, new Position(7, 5));
        
        // Kraljica i kralj
        board[7][3] = new Queen(PieceColor.WHITE, new Position(7, 3));
        board[7][4] = new King(PieceColor.WHITE, new Position(7, 4));
        
        // CRNI (GORE - redovi 0 i 1)
        // Pješaci - red 1
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(PieceColor.BLACK, new Position(1, col));
        }
        
        // Topovi
        board[0][0] = new Rook(PieceColor.BLACK, new Position(0, 0));
        board[0][7] = new Rook(PieceColor.BLACK, new Position(0, 7));
        
        // Konji
        board[0][1] = new Knight(PieceColor.BLACK, new Position(0, 1));
        board[0][6] = new Knight(PieceColor.BLACK, new Position(0, 6));
        
        // Lovci
        board[0][2] = new Bishop(PieceColor.BLACK, new Position(0, 2));
        board[0][5] = new Bishop(PieceColor.BLACK, new Position(0, 5));
        
        // Kraljica i kralj
        board[0][3] = new Queen(PieceColor.BLACK, new Position(0, 3));
        board[0][4] = new King(PieceColor.BLACK, new Position(0, 4));
    }
    
    public Piece getPiece(int row, int col) {
        if (row < 0 || row >= 8 || col < 0 || col >= 8) {
            return null;
        }
        return board[row][col];
    }
    
    public Piece[][] getBoard() {
        return board;
    }
    
    public void movePiece(Position from, Position to) {
        Piece piece = board[from.getRow()][from.getColumn()];
        if (piece != null) {
            board[to.getRow()][to.getColumn()] = piece;
            board[from.getRow()][from.getColumn()] = null;
            piece.setPosition(to);
        }
    }
    
    public Position findKing(PieceColor color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece instanceof King && piece.getColor() == color) {
                    return new Position(row, col);
                }
            }
        }
        return null;
    }
}