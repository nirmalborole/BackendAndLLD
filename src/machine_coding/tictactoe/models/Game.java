package machine_coding.tictactoe.models;

import Generics.Solution.Pair;
import machine_coding.tictactoe.exceptions.BotCountExceededException;
import machine_coding.tictactoe.exceptions.InvalidGameStateException;
import machine_coding.tictactoe.strategies.checkForWin.orderOneWinningStrategy;
import machine_coding.tictactoe.strategies.checkForWin.playerWonStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private int currentPlayerIndex;
    private List<Move>moves;
    private playerWonStrategy winningstategy;


    public Game(Board board, List<Player> players, GameStatus gameStatus, int currentPlayerIndex, List<Move> moves, playerWonStrategy winningstategy,int undoLimitPerPlayer) {
        this.board = board;
        this.players = players;
        this.gameStatus = gameStatus;
        this.currentPlayerIndex = currentPlayerIndex;
        this.moves = moves;
        this.winningstategy=winningstategy;
        for(Player player:players){
            if(player instanceof HumanPlayer){
                HumanPlayer humanPlayer= (HumanPlayer) player;
                humanPlayer.setPendingUndo(undoLimitPerPlayer);
            }
        }
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public void makeMove(){
        Player player= this.players.get(currentPlayerIndex);
        Pair<Integer, Integer> rowcol = player.makeMove(board);
        while(!this.board.checkIfCellUnoccupied(rowcol.getFirst(),rowcol.getSecond())){
            if(player instanceof HumanPlayer){
                System.out.println("move on diff cell");
            }
            rowcol=player.makeMove(this.board);
        }
        this.board.setPlayer(rowcol.getFirst(),rowcol.getSecond(),player);
        Cell cell=this.board.getCell(rowcol.getFirst(),rowcol.getSecond());
        Move move= new Move(cell,player);
        this.moves.add(move);
        if(winningstategy.checkForWin(this.board,cell)){
            this.gameStatus=GameStatus.ENDED;
            return;
        }else if(checkForDrawn()){
            this.gameStatus=GameStatus.DRAWN;
            return;
        }
        this.currentPlayerIndex= (currentPlayerIndex+1) % (this.board.getSize()-1);

    }

    public void undo(){
        int previndex= (this.currentPlayerIndex-1);
        if(previndex<0){
            previndex=players.size()-1;
        }
        Player player = this.players.get(previndex);
        if(player instanceof HumanPlayer){
            Scanner scanner= new Scanner(System.in);
            HumanPlayer humanPlayer=(HumanPlayer)player;
            if(humanPlayer.getPendingUndo()>0) {
                System.out.println("do you need undo?");
                String input = scanner.next();
                if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                    Move move = moves.remove(moves.size() - 1);
                    Cell cell = move.getCell();
                    cell.removePlayer();
                    this.currentPlayerIndex = previndex;
                    winningstategy.handleUndo(move);
                    System.out.println("we have sucessfully undo: " + player.getName() + "'s last move");
                    humanPlayer.decrementUndoCount();
                    if(humanPlayer.getPendingUndo()==0){
                        System.out.println("this was your last undo, no more left");
                    }
                }
            }
        }
    }
    public void replay() throws InvalidGameStateException {
        if(gameStatus==GameStatus.IN_PROGRESS){
            throw new InvalidGameStateException("Invalid game");
        }
        int count=0;
        board.resetBoard();
        for (Move move : moves) {
            Cell cell = move.getCell();
            Player player = move.getPlayer();
            board.setPlayer(cell.getRow(), cell.getRow(), player);
            System.out.println("turn #"+ count++ +"player:"+ player.getName()+"makes a move");
            printBoard();
        }

    }
    private boolean checkForDrawn(){
        int n= this.board.getSize();
        return n*n==this.moves.size();
    }

    public Player getCurrentPlayer(){
        return  this.players.get(currentPlayerIndex);
    }
    public static class GameBuilder{
        private Board board;
        private List<Player> players;
        private GameStatus gameStatus;
        private int currentPlayerIndex;
        private List<Move>moves;
        private playerWonStrategy winningstategy;
        private  int undoLimitPerPlayer;

        public GameBuilder setPlayer(List<Player>players){
            this.players=players;
            int n= players.size();
            this.board= new Board(n+1);
            return this;
        }
        public GameBuilder setUndoLimit(int undoLImit){
            this.undoLimitPerPlayer=undoLImit;
            return this;
        }
        public Game build() throws BotCountExceededException{
            int botcount=0;
            for(Player p:players){
                if(p instanceof BotPlayer){
                    botcount++;
                }
                if(botcount > 1){
                    throw new BotCountExceededException("Found more than 1 bot, max 1 bot alloewd");
                }
            }
            return new Game(this.board, this.players, GameStatus.IN_PROGRESS,0, new ArrayList<>(), new orderOneWinningStrategy(board.getSize()),undoLimitPerPlayer);


        }
    }
}
