package machine_coding.tictactoe.models;

public class Cell {
    private int row;
    private  int col;
    private CellStatus cellStatus;
    private Player player;


    public Cell(int row, int col, CellStatus cellStatus) {
        this.row = row;
        this.col = col;
        this.cellStatus = cellStatus;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getCellStutus() {
        return cellStatus;
    }

    public void setCellStutus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player){
        this.player=player;
        this.cellStatus= CellStatus.Occupied;
    }
    public void removePlayer(){
        this.player=null;
        this.cellStatus=CellStatus.Unoccupied;
    }
    public boolean isUnoccupied(){
        return this.player==null && cellStatus.equals(CellStatus.Unoccupied);
    }
    public void printCell(){
        if(cellStatus.equals(CellStatus.Unoccupied)){
            System.out.print(" _ ");
        }else{
            System.out.print(" "+ this.player.getSymbol().getSymbol()+" ");
        }
    }
}
