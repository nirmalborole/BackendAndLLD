package machine_coding.tictactoe.strategies.checkForWin;

import machine_coding.tictactoe.models.Board;
import machine_coding.tictactoe.models.Cell;
import machine_coding.tictactoe.models.Move;

public interface playerWonStrategy {
    public abstract boolean checkForWin(Board board, Cell currentCell);
    public void handleUndo(Move move);
}
