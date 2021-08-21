package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition souce = UI.readChessPsition(sc);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPsition(sc);

				ChessPiece capturedPiece = chessMatch.performeChessMove(souce, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.hasNextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.hasNextLine();
			}
		}
	}

}
