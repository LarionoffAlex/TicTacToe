package Test.edu;

import Test.edu.tictactoe.game.Game;
import Test.edu.tictactoe.game.GameMap;
import Test.edu.tictactoe.player.AiPlayer;
import Test.edu.tictactoe.player.HumanPlayer;
import Test.edu.tictactoe.player.Player;

/**
 * Created by Alex on 01.11.2016.
 */
public class Main {
    private static final int SIZE = 3; // константа, размер поля
    private static final int WIN_SIZE = 3; // константа, длина для выиграша

    public static void main(String[] args) {
        // создаем объект класса
        GameMap gameMap = new GameMap(SIZE, WIN_SIZE);
        Player humanPlayer = new HumanPlayer("Alex", gameMap);
        Player computer = new AiPlayer("Computer", gameMap);


        Game game=new Game(gameMap);
        game.setOPlayer(computer);
        game.setXPlayer(humanPlayer);
        game.start();

//        Player alex = new Player("Human");
//        Player computer = new Player("Computer");
//
//        Game game = new Game(alex, computer);
//        game.start();
    }
}
