package src.chess;


import java.util.List;
import java.util.ArrayList;
import src.King;


public class ChessGame {
    private ChessBoard board;
    private PieceColor currentPlayer;
    private Position selectedPosition;
    private boolean isPieceSelected;
    
    public ChessGame() {
        board = new ChessBoard();
        currentPlayer = PieceColor.WHITE;
        isPieceSelected = false;
    }
    
    public ChessBoard getBoard() {
        return board;
    }
    
    public PieceColor getCurrentPlayerColor() {
        return currentPlayer;
    }
    
    public boolean isPieceSelected() {
        return isPieceSelected;
    }
    
    public boolean handleSquareSelection(int row, int col) {
        Position clickedPos = new Position(row, col);
        
        if (!isPieceSelected) {
            Piece piece = board.getPiece(row, col);
            if (piece != null && piece.getColor() == currentPlayer) {
                selectedPosition = clickedPos;
                isPieceSelected = true;
                return false;
            }
        } else {
            Position fromPos = selectedPosition;
            Position toPos = clickedPos;
            
            if (isMoveLegal(fromPos, toPos)) {
                board.movePiece(fromPos, toPos);
                isPieceSelected = false;
                selectedPosition = null;
                currentPlayer = (currentPlayer == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
                return true;
            } else {
                isPieceSelected = false;
                selectedPosition = null;
            }
        }
        return false;
    }
    
    private boolean isMoveLegal(Position from, Position to) {
        Piece piece = board.getPiece(from.getRow(), from.getColumn());
        if (piece == null) return false;
        
        if (!piece.isValidMove(to, board.getBoard())) {
            return false;
        }
        
        Piece[][] tempBoard = copyBoard(board.getBoard());
        tempBoard[to.getRow()][to.getColumn()] = piece;
        tempBoard[from.getRow()][from.getColumn()] = null;
        
        return !isKingInCheck(currentPlayer, tempBoard);
    }
    
    private Piece[][] copyBoard(Piece[][] original) {
        Piece[][] copy = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, 8);
        }
        return copy;
    }
    
    private boolean isKingInCheck(PieceColor kingColor, Piece[][] boardState) {
        Position kingPos = null;
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = boardState[row][col];
                if (piece instanceof King && piece.getColor() == kingColor) {
                    kingPos = new Position(row, col);
                    break;
                }
            }
            if (kingPos != null) break;
        }
        
        if (kingPos == null) return false;
        
        PieceColor enemyColor = (kingColor == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = boardState[row][col];
                if (piece != null && piece.getColor() == enemyColor) {
                    if (piece.isValidMove(kingPos, boardState)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean isInCheck(PieceColor color) {
        return isKingInCheck(color, board.getBoard());
    }
    
    public List<Position> getLegalMovesForPieceAt(Position position) {
        List<Position> legalMoves = new ArrayList<>();
        Piece piece = board.getPiece(position.getRow(), position.getColumn());
        
        if (piece == null || piece.getColor() != currentPlayer) {
            return legalMoves;
        }
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position newPos = new Position(row, col);
                if (isMoveLegal(position, newPos)) {
                    legalMoves.add(newPos);
                }
            }
        }
        
        return legalMoves;
    }
    
    public boolean isCheckmate(PieceColor color) {
        if (!isInCheck(color)) {
            return false;
        }
        
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.getColor() == color) {
                    Position fromPos = new Position(row, col);
                    List<Position> moves = getLegalMovesForPieceAt(fromPos);
                    if (!moves.isEmpty()) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public void resetGame() {
        board = new ChessBoard();
        currentPlayer = PieceColor.WHITE;
        isPieceSelected = false;
        selectedPosition = null;
    }
}