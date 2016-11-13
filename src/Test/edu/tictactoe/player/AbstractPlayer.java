package Test.edu.tictactoe.player;

import Test.edu.tictactoe.game.GameMap;
import Test.edu.tictactoe.game.Mark;

/**
 * Created by Aleksandr on 06.11.2016.
 */
public abstract class AbstractPlayer implements Player {
    protected final GameMap gameMap;
    protected Mark myMark;
    protected final String name="";

    protected AbstractPlayer(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void setMyMark(Mark myMark) {
        this.myMark = myMark;
    }

    public Mark getMyMark() {
        return myMark;
    }
    public String getName() {
        return name;
    }
}
