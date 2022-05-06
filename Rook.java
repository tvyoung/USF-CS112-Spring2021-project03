public class Rook extends ChessPiece {

	public Rook() {
		chessValue = "r";
	}

	//moves forwards/backwards and sideways
	@Override
	public boolean move(int x, int y) {
		//checks if moving forward/backward
		//if the given x coordinate is the same as the Rook's current x coordinate, returns true
		if (x == xCoordinate) {
			return true;
		//checks if moving sideways
		//if the given y coordinate is the same as the Rook's current y coordinate, returns true
		} else if (y == yCoordinate) {
			return true;
		}
		//if neither given x or y coordinate is the same as the Rook's current x and y coordinates, returns false 
		return false;
	}

	@Override
	public String toString() {
		return "ROOK";
	}
}