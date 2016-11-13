package Test.edu.tictactoe.player;

import Test.edu.tictactoe.game.Mark;

/**
 * Created by Aleksandr on 06.11.2016.
 */
public interface Player {

    void move();

    void setMyMark(Mark myMark);

    Mark getMyMark();

    String getName();
}
