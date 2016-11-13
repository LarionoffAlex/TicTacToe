package Test.edu.tictactoe.player;

import Test.edu.tictactoe.exception.InvalidMoveException;
import Test.edu.tictactoe.game.GameMap;

import java.util.Scanner;

/**
 * Created by Aleksandr on 06.11.2016.
 */
public class HumanPlayer extends AbstractPlayer{
    private final static Scanner CONSOLE_READER = new Scanner(System.in);
    private final String name;

    public HumanPlayer(String name, GameMap gameMap) {
        super(gameMap);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        boolean success = false;
        do {
            System.out.println("Введите координаты в формате X и Y ('X пробел Y')");
            int x = CONSOLE_READER.nextInt() - 1;
            int y = CONSOLE_READER.nextInt() - 1;
            try {
                gameMap.setValue(x, y, myMark);
                success = true;
            } catch (InvalidMoveException e) {
                //nothing
            }

        } while (!success);
    }

}
