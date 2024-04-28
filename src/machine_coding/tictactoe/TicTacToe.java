package machine_coding.tictactoe;

import Design_Pattern.Factory.Products.Platform;
import machine_coding.tictactoe.controller.GameController;
import machine_coding.tictactoe.models.*;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController= new GameController();
        Scanner scanner=new Scanner(System.in);

        System.out.println("how many human player?");
        int numOfHumanPlayer= scanner.nextInt();
        List<Player>players= new ArrayList<>();
        Set<Character> symbolset= new HashSet<>();

        for(int i=0;i<numOfHumanPlayer;i++){
            System.out.println("Enter name & symbol");
            String name= scanner.next();
            String symbolstr= scanner.next();

            char symbol= symbolstr.charAt(0);
            while(symbolset.contains(symbol)){
                System.out.println("enter new symbol");
                symbolstr= scanner.next();
                symbol= symbolstr.charAt(0);
            }
            symbolset.add(symbol);
            players.add(new HumanPlayer(name,new Symbol(symbolstr.charAt(0))));
        }

        System.out.println("how many bot player?");
        int numOfBotPlayer= scanner.nextInt();

        String s="abcdefghijklmnopqrstvwxyz1234567890";
        Random random= new Random();
        for(int i=0;i<numOfBotPlayer;i++){
            System.out.println("Choose bot difficulty level: E/M/D");
            String botdifflevel= scanner.next();
            BotLevel botLevel;

            switch (botdifflevel.charAt(0)){
                case 'E':
                    botLevel=BotLevel.EASY;
                    break;
                case 'M':
                    botLevel=BotLevel.MEDIUM;
                    break;
                case 'D':
                    botLevel=BotLevel.DIFFICULT;
                default:
                    botLevel=BotLevel.EASY;
                    break;
            }
            int idx = random.nextInt(s.length());
            char botsymbol= s.charAt(idx);

            while(symbolset.contains(botsymbol)){
                idx = random.nextInt(s.length());
                botsymbol= s.charAt(idx);
            }
            symbolset.add(botsymbol);
            players.add(new BotPlayer("Bot "+(i+1),new Symbol(botsymbol),botLevel));

        }

        System.out.println("Enter the undo limit for player can do");
        int limit= scanner.nextInt();
        Game game;
        try{
            game=gameController.createGame(players,limit);
        }catch(Exception e){
            System.out.println("error while creting game"+ e.getMessage());
            return;
        }

        //start playing game

        while (gameController.getGameStatus(game)== GameStatus.IN_PROGRESS){
            gameController.printBoard(game);
            gameController.makeMove(game);
            gameController.undo(game);
        }
        GameStatus gameStatus = gameController.getGameStatus(game);
        if(gameStatus.equals(GameStatus.ENDED)){
            Player winningPlayer = gameController.getCurrentPlayer(game);
            System.out.println(winningPlayer.getName() + " has won with symbol "+ winningPlayer.getSymbol().getSymbol());
            gameController.printBoard(game);
        }else{
            System.out.println("this game drawn");
        }
        gameController.printBoard(game);

        System.out.println("do you need replay?(y/n");
        String replay = scanner.next();
        if(replay.charAt(0)=='y'|| replay.charAt(0)=='Y'){
            gameController.replay(game);
        }
    }
}
