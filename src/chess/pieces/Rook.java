package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		byte rookMove[][] = { { 0, -1}, { 0, 1 }, {-1, 0 }, { 1, 0 } }; 
		for (byte[] is : rookMove) {
			p.setValues(position.getRow() + is[0], position.getColumn() + is[1]);
			while (getBoard().positionExists(p) && !isThereMyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
				if (getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
					break;
				}
				p.setValues(p.getRow() + is[0], p.getColumn() + is[1]);
			}
		}

		return mat;
	}
}
