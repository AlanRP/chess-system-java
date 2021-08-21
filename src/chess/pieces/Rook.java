package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

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
		
		// for (i, j) -> scan all possible position for Rook
		//  0, -1 -> left
		//  0,  1 -> right
		// -1,  0 -> Above
		//  1,  0 -> below
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				
				if (i != 0 && j !=0) {
					continue;
				}
				
				p.setValues(position.getRow() + i, position.getColumn() + j);

				while (getBoard().positionExists(p) && !isThereMyPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					
					if(getBoard().positionExists(p) && getBoard().thereIsAPiece(p)) {
						break;
					}
					p.setValues(p.getRow() + i, p.getColumn() + j);
					
				}
			}
		}
		
		return mat;
	}
}
