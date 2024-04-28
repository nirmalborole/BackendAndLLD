package machine_coding.tictactoe.strategies.botPlaying;

import Generics.Solution.Pair;
import machine_coding.tictactoe.models.Board;

public interface botPlayingStategy {
    public Pair<Integer,Integer> makeMove(Board board);
}
