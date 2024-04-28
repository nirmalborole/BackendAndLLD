package machine_coding.tictactoe.strategies.botPlaying;

import Generics.Solution.Pair;
import machine_coding.tictactoe.exceptions.InvalidGameStateException;
import machine_coding.tictactoe.models.Board;
import machine_coding.tictactoe.models.Cell;
import machine_coding.tictactoe.models.CellStatus;

import java.util.List;

public class easyBotPlayeingSrategy implements botPlayingStategy{
    @Override
    public Pair<Integer, Integer> makeMove(Board board) {
        for (List<Cell> row : board.getCells()) {
            for (Cell cell : row) {
                if(cell.getCellStutus().equals(CellStatus.Unoccupied)){
                    return new Pair<>(cell.getRow(), cell.getCol());
                }
            }
        }
        throw new InvalidGameStateException("no palce for bot to move");
    }
}
