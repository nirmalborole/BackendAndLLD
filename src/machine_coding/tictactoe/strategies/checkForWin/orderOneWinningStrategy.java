package machine_coding.tictactoe.strategies.checkForWin;

import machine_coding.tictactoe.models.Board;
import machine_coding.tictactoe.models.Cell;
import machine_coding.tictactoe.models.Move;
import machine_coding.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderOneWinningStrategy implements playerWonStrategy{

    private List<HashMap<Character,Integer>> rowsMap;
    private List<HashMap<Character,Integer>>colsMap;
    private HashMap<Character,Integer>diagonalMap;
    private HashMap<Character,Integer>revdiagonalMap;
    private int n;

    public orderOneWinningStrategy(int n) {
        rowsMap= new ArrayList<>();
        colsMap= new ArrayList<>();
        revdiagonalMap=new HashMap<>();
        diagonalMap=new HashMap<>();
        for(int i=0;i<n;i++){
            rowsMap.add(new HashMap<>());
            colsMap.add(new HashMap<>());
        }
        this.n=n;
    }

    @Override
    public boolean checkForWin(Board board, Cell currentCell) {
        // update map
        int row = currentCell.getRow();
        int col = currentCell.getCol();
        char symbol = currentCell.getPlayer().getSymbol().getSymbol();

        HashMap<Character, Integer> rowMap = rowsMap.get(row);
        rowMap.put(symbol,rowMap.getOrDefault(symbol,0)+1);
        HashMap<Character, Integer> colMap = colsMap.get(col);
        colMap.put(symbol,colMap.getOrDefault(symbol,0)+1);
        if(checkIfCellIsOnDiagonal(row,col)){
            diagonalMap.put(symbol,diagonalMap.getOrDefault(symbol,0)+1);
        }
        if(checkIfCellIsOnRevDiagonal(row,col,board.getSize())){
            revdiagonalMap.put(symbol,revdiagonalMap.getOrDefault(symbol,0)+1);
        }

        // check player won
        if(rowsMap.get(row).get(symbol) == board.getSize()){
            return  true;
        }
        if(colsMap.get(col).get(symbol)== board.getSize()){
            return true;
        }
        if(checkIfCellIsOnDiagonal(row,col)&& diagonalMap.get(symbol)== board.getSize()){
            return true;
        }
        if(checkIfCellIsOnRevDiagonal(row,col,board.getSize()) && revdiagonalMap.get(symbol)== board.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Move move) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();
        Player player = move.getPlayer();
        char symbol = player.getSymbol().getSymbol();

        HashMap<Character, Integer> rowmap = rowsMap.get(symbol);
        rowmap.put(symbol,rowmap.get(symbol)-1);

        HashMap<Character, Integer> colmap = colsMap.get(symbol);
        colmap.put(symbol, colmap.get(symbol)-1);

        if(checkIfCellIsOnDiagonal(row,col)){
            diagonalMap.put(symbol,diagonalMap.get(symbol)-1);
        }
        if(checkIfCellIsOnRevDiagonal(row,col,n)){
            revdiagonalMap.put(symbol,revdiagonalMap.get(symbol)-1);
        }
    }

    private boolean checkIfCellIsOnDiagonal(int row,int col){
        return row==col;
    }
    private boolean checkIfCellIsOnRevDiagonal(int row,int col,int n){
        return row+col == n-1;
    }
}
