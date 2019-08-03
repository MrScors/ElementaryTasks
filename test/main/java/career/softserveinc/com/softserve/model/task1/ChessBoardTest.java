package main.java.career.softserveinc.com.softserve.model.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessBoardTest {

    @Test
    void getHeight() {
        ChessBoard chessBoard = new ChessBoard(1, 5);
        int actual = chessBoard.getHeight();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getWidth() {
        ChessBoard chessBoard = new ChessBoard(1, 5);
        int actual = chessBoard.getWidth();
        int expected = 5;
        assertEquals(expected, actual);

    }
}