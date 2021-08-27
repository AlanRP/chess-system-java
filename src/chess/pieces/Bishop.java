package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
					// Move ->      nw        ne         se        sw
		byte bishopMove[][] = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } }; 
		for (byte[] i : bishopMove) {
			p.setValues(position.getRow() + i[0], position.getColumn() + i[1]);
			while (getBoard().positionExists(p) && !isThereMyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				if (getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
					break;
				}
				p.setValues(p.getRow() + i[0], p.getColumn() + i[1]);
			}
		}

		return mat;
	}
}
