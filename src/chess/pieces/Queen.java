package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				p.setValues(position.getRow() + i, position.getColumn() + j);
				while (getBoard().positionExists(p) && !isThereMyPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					if (getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
						break;
					}
					p.setValues(p.getRow() + i, p.getColumn() + j);
				}
			}
		}
		return mat;
	}
}
