package se.liu.denjo163.tetris;

public class BoardTester {
    public static void main(String[] args) {
	Poly poly = TetrominoMaker.getPoly(5);

	Board board = new Board(11, 13, poly);
	BoardToTextConverter converter = new BoardToTextConverter();
	String textBoard = converter.convertToText(board);
	TetrisViewer viewer = new TetrisViewer(board);
	viewer.startGame();
    }
}