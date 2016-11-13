package Test.edu.tictactoe.player;

import Test.edu.tictactoe.exception.InvalidMoveException;
import Test.edu.tictactoe.game.GameMap;
import Test.edu.tictactoe.game.Mark;

import java.util.Random;

/**
 * Created by Aleksandr on 06.11.2016.
 */
public class AiPlayer extends AbstractPlayer{
    private final static int POSTITION_NOT_FOUND = -1;

    //FIXME
    private final Random rand = new Random();
    private final int size;
    private final String name;

    public AiPlayer(String name, GameMap gameMap) {
        super(gameMap);
        size = gameMap.getSize();
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("Ход компьютера:");
        if (!makeCleverMove()) {
            makeRandomMove();
        }
    }

    //TODO check diagonals
    private boolean makeCleverMove() {
        for (int x = 0; x < size; x++) {
            int y = findBestPosition(gameMap.getHorizontalRow(x));
            if (y > POSTITION_NOT_FOUND) {
                gameMap.setValue(x,y, myMark);
                return true;
            }
        }

        for (int y = 0; y < size; y++) {
            int x = findBestPosition(gameMap.getVerticalRow(y));
            if (x > POSTITION_NOT_FOUND) {
                gameMap.setValue(x,y, myMark);
                return true;
            }
        }
       return false;
    }


    private int findBestPosition(Mark[] line) {
        int result = POSTITION_NOT_FOUND;
        int myMarkCounter = 0;
        int opponentMarkCounter = 0;

        for (int i = 0; i < size; i++) {
            Mark value = line[i];

            if (Mark.isBlank(value)) {
                result = i;
                continue;
            }

            if (value == myMark) {
                myMarkCounter++;
            } else {
                opponentMarkCounter++;
            }

        }

        if (opponentMarkCounter >= 2 || myMarkCounter >= 2) {
            return result;
        } else {
            return POSTITION_NOT_FOUND;
        }
    }

    private void makeRandomMove() {
        boolean success = false;

        do {
           int x = rand.nextInt(size); //x=sc.nextInt()-1;
           int y = rand.nextInt(size); //y=sc.nextInt()-1;
            try {
                gameMap.setValue(x, y, myMark);
                success = true;
            } catch (InvalidMoveException e) {
                //nothing
            }

        } while (!success);
    }
}
