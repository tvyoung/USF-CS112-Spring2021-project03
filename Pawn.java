public class Pawn extends ChessPiece {

	//checks if the Pawn piece is on its first move
	private boolean firstMove;

	//default constructor, initializes firstMove to true upon creation of new Pawn
	public Pawn() {
		firstMove = true;
		chessValue = "p";
	}

	//moves one space forward/back at a time
	//can move 2 spaces ONLY if its the first move of the "game"
	@Override
	public boolean move(int x, int y) {		
		//if the Pawn piece's current move is its first
		if (firstMove == true) {
			//if the given X coordinate is the same as current X coordinate
			//and if the distance between given Y coordinate and current Y coordinate is 2 or less (absolute value), valid move
			if (xCoordinate == x && Math.abs(yCoordinate - y) <= 2) {
				//the move is valid. firstMove is made, then return true
				firstMove = false;
				return true;
			}
		//else the current move is not Pawn piece's first move
		} else {
			//if the given X coordinate is the same as current X coordinate
			//and if the distance between given Y coordinate and current Y coordinate is 1 (absolute value), valid move
			if (xCoordinate == x & Math.abs(yCoordinate - y) == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "PAWN";
	}
}