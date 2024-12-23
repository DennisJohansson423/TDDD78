package se.liu.denjo163.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveAction {
    private Direction direction;
    private Board board;

    public MoveAction(Direction direction, Board board) {
	this.direction = direction;
	this.board = board;
    }

    final Action move = new AbstractAction() {
	@Override
	public void actionPerformed(final ActionEvent e) {
	    if (direction == Direction.LEFT) {
		board.move(Direction.LEFT);
	    } else if (direction == Direction.RIGHT) {
		board.move(Direction.RIGHT);
	    }
	}
    };
}