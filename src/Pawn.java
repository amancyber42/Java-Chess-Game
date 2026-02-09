package src;

import src.chess.Piece;
import src.chess.PieceColor;
import src.chess.Position;


public class Pawn extends Piece {
    public Pawn(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = newPosition.getRow() - position.getRow();
        int colDiff = Math.abs(newPosition.getColumn() - position.getColumn());
        
        if (getColor() == PieceColor.WHITE) {
            // Bijeli pješak ide prema GORE (smanjuje red) - jer su bijeli DOLJE
            if (rowDiff >= 0) return false; // Mora ići prema gore (negativan rowDiff)
            
            if (colDiff == 0) {
                // Ravno naprijed (GORE)
                if (rowDiff == -1 && board[newPosition.getRow()][newPosition.getColumn()] == null) {
                    return true;
                }
                if (rowDiff == -2 && position.getRow() == 6 && // Početni red za bijele
                    board[position.getRow()-1][position.getColumn()] == null &&
                    board[newPosition.getRow()][newPosition.getColumn()] == null) {
                    return true;
                }
            } else if (colDiff == 1 && rowDiff == -1) {
                // Dijagonalno GORE za uzimanje
                Piece target = board[newPosition.getRow()][newPosition.getColumn()];
                return target != null && target.getColor() != getColor();
            }
        } else {
            // Crni pješak ide prema DOLJE (povećava red) - jer su crni GORE
            if (rowDiff <= 0) return false; // Mora ići prema dolje (pozitivan rowDiff)
            
            if (colDiff == 0) {
                // Ravno naprijed (DOLJE)
                if (rowDiff == 1 && board[newPosition.getRow()][newPosition.getColumn()] == null) {
                    return true;
                }
                if (rowDiff == 2 && position.getRow() == 1 && // Početni red za crne
                    board[position.getRow()+1][position.getColumn()] == null &&
                    board[newPosition.getRow()][newPosition.getColumn()] == null) {
                    return true;
                }
            } else if (colDiff == 1 && rowDiff == 1) {
                // Dijagonalno DOLJE za uzimanje
                Piece target = board[newPosition.getRow()][newPosition.getColumn()];
                return target != null && target.getColor() != getColor();
            }
        }
        
        return false;
    }
}
