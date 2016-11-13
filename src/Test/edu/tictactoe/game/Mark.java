package Test.edu.tictactoe.game;

/**
 * Created by Aleksandr on 06.11.2016.
 */
public enum Mark {
    X, O, BLANK;

//    public final static char X = 'X';
//    public final static char O = 'O';
//    public final static char BLANK = '*';

    public static boolean isBlank(Mark value) {
        return BLANK == value;
    }

    public static char getPrintableCharacter(Mark value) {
        switch (value) {
            case X : return 'X';
            case O : return 'O';
            default: return '*';
        }
    }
}
