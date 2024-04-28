package machine_coding.tictactoe.factories;

import machine_coding.tictactoe.models.Board;
import machine_coding.tictactoe.models.BotLevel;
import machine_coding.tictactoe.strategies.botPlaying.botPlayingStategy;
import machine_coding.tictactoe.strategies.botPlaying.easyBotPlayeingSrategy;

public class botPlayingStrategyFactory {
    public static botPlayingStategy getBotPlayingStattegy(BotLevel botLevel){
        switch (botLevel){
            case EASY:
            case MEDIUM:
            case DIFFICULT:
                return new easyBotPlayeingSrategy();
            default:
                throw new UnsupportedOperationException("give stategy not supported");
        }
    }
}
