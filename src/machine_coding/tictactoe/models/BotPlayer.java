package machine_coding.tictactoe.models;

import Generics.Solution.Pair;
import machine_coding.tictactoe.factories.botPlayingStrategyFactory;
import machine_coding.tictactoe.strategies.botPlaying.botPlayingStategy;

public class BotPlayer extends Player{
    private BotLevel botLevel;
    private botPlayingStategy botPlaingStategy;

    public BotPlayer(String name, Symbol s, BotLevel botLevel) {
        super(name, s);
        this.botLevel = botLevel;
        this.botPlaingStategy= botPlayingStrategyFactory.getBotPlayingStattegy(botLevel);
    }

    @Override
    public Pair<Integer, Integer> makeMove(Board board) {
        return botPlaingStategy.makeMove(board);
    }
}
