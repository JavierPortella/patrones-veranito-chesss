package ui.pieces;

import ui.board.ChessGameBoard;

import javax.swing.ImageIcon;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Represents a Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen
        extends ChessGamePiece {
    // ----------------------------------------------------------
    /**
     * Create a new Queen object.
     *
     * @param board
     *              the board the queen is on
     * @param row
     *              the row location of the queen
     * @param col
     *              the column location of the queen
     * @param color
     *              either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this Queen.
     * 
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
				ArrayList<String>[] moves = new ArrayList[8];
				moves[0] = calculateNorthEastMoves(board, 8);
				moves[1] = calculateNorthWestMoves(board, 8);
				moves[2] = calculateSouthEastMoves(board, 8);
				moves[3] = calculateSouthWestMoves(board, 8);
				moves[4] = calculateNorthMoves(board, 8);
				moves[5] = calculateSouthMoves(board, 8);
				moves[6] = calculateEastMoves(board, 8);
				moves[7] = calculateWestMoves(board, 8);
        ArrayList<String> allMoves = new ArrayList<>();
				for(ArrayList<String> move : moves){
					allMoves.addAll(move);
				}
        return allMoves;
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
                    getClass().getResource("../../resources/chessImages/WhiteQueen.gif"));
            case ChessGamePiece.BLACK -> new ImageIcon(
                    getClass().getResource("../../resources/chessImages/BlackQueen.gif"));
            default -> new ImageIcon(
                    getClass().getResource("../../resources/chessImages/default-Unassigned.gif"));
        };
    }
}
