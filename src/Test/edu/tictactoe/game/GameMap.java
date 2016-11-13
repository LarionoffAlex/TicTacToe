package Test.edu.tictactoe.game;

import Test.edu.tictactoe.exception.InvalidMoveException;
import Test.edu.tictactoe.player.Position;

/**
 * Created by Alex on 01.11.2016.
 */
public class GameMap {
    private final int size;

    public int getWinSize() {
        return winSize;
    }

    private final int winSize;
    private final Mark[][] map;

    // конструктор
    public GameMap(int size, int winSize) {
        this.size = size;
        this.winSize = winSize;
        map = new Mark[size][size];
        for (int i = 0; i < size; i++) { // двойным циклом пройти по массиву и заполнить *
            for (int j = 0; j < size; j++) {
                map[i][j] = Mark.BLANK; // string в кавычках, char в апострофах
            }
        }
    }

    public Mark getValue(Position position) {
        return getValue(position.getX(), position.getY());
    }

    public void setValue(int x, int y, Mark value) {
        if (isCellEmpty(x,y)) {
            map[x][y] = value;
        } else {
            throw new InvalidMoveException();
        }
    }

    public Mark getValue(int x, int y) {
        return map[x][y];
    }

    public int getSize() {
        return size;
    }

    public Mark[] getHorizontalRow(int x) {
        // это будет работать?
        return map[x];
    }

    public Mark[] getVerticalRow(int y) {
        Mark[] result = new Mark[size];
        for (int i=0; i < size; i++) {
            result[i] = map[i][y];
        }
        return result;
    }

    // сделал я
    public Mark[] getDiagonalRow() {
        Mark[] result = new Mark[size];
        for (int i=0; i < size; i++) {
            result[i] = map[i][i];
        }
        return result;
    }

    // сделал я
    public Mark[] getReverseDiagonalRow() {
        Mark[] result = new Mark[size];
        int j=0;
        for (int i=size-1; i >=0; i--, ++j) {
            result[i] = map[i][j];
        }
        return result;
    }

    // методы
    // печать игрового поля
    public void printMap() {
        String str = ""; // печать строчки координат
        for (int k = 0; k <= size; k++) {
            str = str + k + " ";
        }
        System.out.print(str); //("0 1 2 3");
        for (int i = 0; i < size; i++) { // двойным циклом пройти по массиву и заполнить *
            System.out.println();
            System.out.print(i + 1 + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(Mark.getPrintableCharacter(map[i][j]) + " ");
            }
        }
        System.out.println(); // переводим еще на одну строчку
    }

    // проверка попадания в поле и чтобы поле было пустое
    public  boolean isCellEmpty(int x, int y) {
        // boolean bool=true; не надо использовать переменную, достаточно вернуть true or false
        if (x < 0 || x > size || y < 0 || y > size) return false; // bool=false; // если указаны не верные координаты
        //if (map[y][x] != '*') return false; // bool = false; // если ячейка уже занята
        //return true; // bool;
        return map[x][y] == Mark.BLANK; // ну так же короче и понятнее
    }



}
