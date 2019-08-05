package main.java.career.softserveinc.com.softserve.model.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessBoardTest {

    @Test
    void createBoardTest1() {
        ChessBoard chessBoard = new ChessBoard(3, 3);
        StringBuilder actual = chessBoard.createBoard();
        StringBuilder expected = new StringBuilder("+-----+\n"+
                "| |#| |\n" +
                "|#| |#|\n" +
                "| |#| |\n" +
                "+-----+\n");
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void createBoardTest2() {
        ChessBoard chessBoard = new ChessBoard(1, 10);
        StringBuilder actual = chessBoard.createBoard();
        StringBuilder expected = new StringBuilder("+-------------------+\n"+
                "| |#| |#| |#| |#| |#|\n" +
                "+-------------------+\n");
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void createBoardTest3() {
        ChessBoard chessBoard = new ChessBoard(5, 2);
        StringBuilder actual = chessBoard.createBoard();
        StringBuilder expected = new StringBuilder("+---+\n"+
                "| |#|\n" +
                "|#| |\n" +
                "| |#|\n" +
                "|#| |\n" +
                "| |#|\n" +
                "+---+\n");
        assertEquals(expected.toString(), actual.toString());
    }



}