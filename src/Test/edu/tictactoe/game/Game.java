package Test.edu.tictactoe.game;

import Test.edu.tictactoe.player.Player;

/**
 * Created by Alex on 01.11.2016.
 */
public class Game {
    private final GameMap gameMap;
    private Player xPlayer;
    private Player oPlayer;
    private final int movesLimit;
    private int movesCounter;


    public Game(GameMap gameMap) {
        this.gameMap = gameMap;
        movesLimit = gameMap.getSize() * gameMap.getSize();
    }

    public void setXPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
        this.xPlayer.setMyMark(Mark.X);
    }

    public void setOPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
        this.oPlayer.setMyMark(Mark.O);
    }

    public void start() {
        Player winner = play();
        congratulate(winner);
    }

    private Player play() {
        Player currentPlayer;
        boolean gameHasWinner = false;
        gameMap.printMap();
        do {

            movesCounter++;
            currentPlayer = getCurrentPlayer();
            currentPlayer.move();
            gameHasWinner = isWinMove(currentPlayer.getMyMark());
            gameMap.printMap();

        } while (!gameHasWinner && movesCounter < movesLimit);

        //if (movesCounter>= movesLimit && !gameHasWinner) {
        //    return null;
        // } else {
        return (gameHasWinner && movesCounter <= movesLimit) ? currentPlayer : null;
        //}


    }

    public boolean isWinMove(Mark mark) {
        //TODO use gameMap : getHorizontalRow(), getVerticalRow(), getDiagonalRow(), getReverseDiagonalRow()
        if (isCheckWinCheck(mark, gameMap.getDiagonalRow())) return true;
        for (int i = 0; i < gameMap.getSize(); i++) {
            if (isCheckWinCheck(mark, gameMap.getHorizontalRow(i))) return true;
            if (isCheckWinCheck(mark, gameMap.getVerticalRow(i))) return true;
        }
        if (isCheckWinCheck(mark, gameMap.getReverseDiagonalRow())) return true;
        return false;
        // return isCheckWin(mark);
    }

    private Player getCurrentPlayer() {

        return (movesCounter % 2) == 0 ? oPlayer : xPlayer; //: set oPlayer : xPlayer;

    }

    private boolean isCheckWinCheck(Mark mark, Mark[] map) {
        for (int i = 0; i < gameMap.getWinSize(); i++) {
            if (map[i] != mark) {
                return false;
            }
        }
        return true;
    }

    //FIXME - не получилось вывести имена, хотя сделал геттеры
    private void congratulate(Player winner) {
        if (winner == null) {
            System.out.println(movesCounter + " attempts were made, but no luck. Draw game!");
        } else {
            System.out.println("We have a winner " + winner.getName());
            System.out.println(movesCounter + " attempts were made");
        }

    }
}
