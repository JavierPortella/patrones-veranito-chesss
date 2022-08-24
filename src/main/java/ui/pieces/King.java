package ui.pieces;

import ui.board.ChessGameBoard;

import javax.swing.ImageIcon;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Represents a King game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class King
        extends ChessGamePiece {
    // ----------------------------------------------------------
    /**
     * Create a new King object.
     *
     * @param board
     *              the board to create the king on
     * @param row
     *              the row to create the king on
     * @param col
     *              the column to create the king on
     * @param color
     *              either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, false);
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board
     *              the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
				ArrayList<String>[] moves = new ArrayList[8];
				moves[0] = calculateNorthEastMoves(board, 1);
				moves[1] = calculateNorthWestMoves(board, 1);
				moves[2] = calculateSouthEastMoves(board, 1);
				moves[3] = calculateSouthWestMoves(board, 1);
				moves[4] = calculateNorthMoves(board, 1);
				moves[5] = calculateSouthMoves(board, 1);
				moves[6] = calculateEastMoves(board, 1);
				moves[7] = calculateWestMoves(board, 1);
        ArrayList<String> allMoves = new ArrayList<>();
				for(ArrayList<String> move : moves){
					allMoves.addAll(move);
				}
        return allMoves;
    }

    /**
     * Determines if this King is checked.
     *
     * @param board
     *              the board to check on
     * @return true if checked, false if not checked
     */
    public boolean isChecked(ChessGameBoard board) {
        return !getCurrentAttackers(board).isEmpty();
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        return switch (getColorOfPiece()) {
            case ChessGamePiece.WHITE -> new ImageIcon(
                    getClass().getResource("../../resources/chessImages/WhiteKing.gif"));
            case ChessGamePiece.BLACK -> new ImageIcon(
                    getClass().getResource("../../resources/chessImages/BlackKing.gif"));
            default -> new ImageIcon(
                    getClass().getResource("../../resources/chessImages/default-Unassigned.gif"));
        };
    }
}
