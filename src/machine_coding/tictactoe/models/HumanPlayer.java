package machine_coding.tictactoe.models;

import Generics.Solution.Pair;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private int pendingUndo;
    public HumanPlayer(String name, Symbol s) {
        super(name, s);
    }

    @Override
    public Pair<Integer, Integer> makeMove(Board board) {
        System.out.println("this is"+ this.getName()+",s turn");
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter roe & col");
        int row= scanner.nextInt();
        int col= scanner.nextInt();
        return  new Pair<>(row,col);
    }

    public int getPendingUndo() {
        return pendingUndo;
    }

    public void setPendingUndo(int pendingUndo) {
        this.pendingUndo = pendingUndo;
    }
    public void decrementUndoCount() {
        this.pendingUndo--;
    }
}
