package src.chess;
        

public class Position {
    private final int row;
    private final int column;
    
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public int getRow() { return row; }
    public int getColumn() { return column; }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return row == other.row && column == other.column;
    }
    
    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }
}